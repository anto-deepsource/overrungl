/*
 * MIT License
 *
 * Copyright (c) 2022-2023 Overrun Organization
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

package overrungl.demo.glfw;

import overrungl.demo.util.IOUtil;
import overrungl.glfw.GLFWCallbacks;
import overrungl.glfw.GLFW;
import overrungl.glfw.GLFWErrorCallback;
import overrungl.glfw.GLFWImage;
import overrungl.opengl.GL;
import overrungl.opengl.GLLoader;
import overrungl.stb.STBImage;
import overrungl.util.CheckUtil;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Objects;

import static java.lang.foreign.ValueLayout.JAVA_INT;

/**
 * Tests GLFW window icon and STB image
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GLFWWindowIconTest {
    private MemorySegment window;

    public void run() {
        try (var arena = Arena.ofShared()) {
            init(arena);
            load();
        }
        loop();

        GLFWCallbacks.free(window);
        GLFW.destroyWindow(window);

        GLFW.terminate();
        GLFW.setErrorCallback(null);
    }

    private void init(Arena arena) {
        GLFWErrorCallback.createPrint().set();
        CheckUtil.check(GLFW.init(), "Unable to initialize GLFW");
        GLFW.defaultWindowHints();
        GLFW.windowHint(GLFW.VISIBLE, false);
        GLFW.windowHint(GLFW.RESIZABLE, true);
        window = GLFW.createWindow(300, 300, "Hello World!", MemorySegment.NULL, MemorySegment.NULL);
        CheckUtil.checkNotNullptr(window, "Failed to create the GLFW window");

        try {
            var px = arena.allocate(JAVA_INT);
            var py = arena.allocate(JAVA_INT);
            var pc = arena.allocate(JAVA_INT);
            var data = STBImage.loadFromMemory(
                IOUtil.ioResourceToSegment(arena, "image.png", 256),
                px, py, pc, STBImage.RGB_ALPHA
            );
            GLFW.setWindowIcon(window, GLFWImage.create(arena, 1)
                .width(px.get(JAVA_INT, 0))
                .height(py.get(JAVA_INT, 0))
                .pixels(data));
            STBImage.free(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GLFW.setKeyCallback(window, (handle, key, scancode, action, mods) -> {
            if (key == GLFW.KEY_ESCAPE && action == GLFW.RELEASE) {
                GLFW.setWindowShouldClose(window, true);
            }
        });
        GLFW.setFramebufferSizeCallback(window, (handle, width, height) ->
            GL.viewport(0, 0, width, height));
        var vidMode = GLFW.getVideoMode(GLFW.getPrimaryMonitor());
        if (vidMode != null) {
            var size = GLFW.getWindowSize(window);
            GLFW.setWindowPos(
                window,
                (vidMode.width() - size.x()) / 2,
                (vidMode.height() - size.y()) / 2
            );
        }

        GLFW.makeContextCurrent(window);
        GLFW.swapInterval(1);

        GLFW.showWindow(window);
    }

    private void load() {
        Objects.requireNonNull(GLLoader.load(GLFW::getProcAddress, true), "Failed to load OpenGL");

        GL.clearColor(0.4f, 0.6f, 0.9f, 1.0f);
    }

    private void loop() {
        while (!GLFW.windowShouldClose(window)) {
            GL.clear(GL.COLOR_BUFFER_BIT | GL.DEPTH_BUFFER_BIT);

            GLFW.swapBuffers(window);

            GLFW.pollEvents();
        }
    }

    public static void main(String[] args) {
        new GLFWWindowIconTest().run();
    }
}
