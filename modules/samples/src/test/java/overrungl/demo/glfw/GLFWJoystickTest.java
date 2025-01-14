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

import overrungl.glfw.GLFWCallbacks;
import overrungl.glfw.GLFW;
import overrungl.glfw.GLFWErrorCallback;
import overrungl.glfw.GLFWGamepadState;
import overrungl.util.CheckUtil;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * Tests GLFW joystick
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GLFWJoystickTest {
    private MemorySegment window;

    public void run() {
        init();
        loop();

        GLFWCallbacks.free(window);
        GLFW.destroyWindow(window);

        GLFW.terminate();
        GLFW.setErrorCallback(null);
    }

    private void init() {
        GLFWErrorCallback.createPrint().set();
        CheckUtil.check(GLFW.init(), "Unable to initialize GLFW");
        GLFW.defaultWindowHints();
        GLFW.windowHint(GLFW.VISIBLE, false);
        GLFW.windowHint(GLFW.RESIZABLE, true);
        GLFW.windowHint(GLFW.CLIENT_API, GLFW.NO_API);
        window = GLFW.createWindow(200, 100, "Holder", MemorySegment.NULL, MemorySegment.NULL);
        CheckUtil.checkNotNullptr(window, "Failed to create the GLFW window");
        GLFW.setKeyCallback(window, (handle, key, scancode, action, mods) -> {
            if (key == GLFW.KEY_ESCAPE && action == GLFW.RELEASE) {
                GLFW.setWindowShouldClose(window, true);
            }
        });
        GLFW.setJoystickCallback((jid, event) -> {
            switch (event) {
                case GLFW.CONNECTED -> {
                    boolean isGamepad = GLFW.joystickIsGamepad(jid);
                    var prefix = isGamepad ? "Gamepad " : "Joystick ";
                    System.out.println(STR."\{prefix}\{jid}: \"\{(isGamepad ? GLFW.getGamepadName(jid) : GLFW.getJoystickName(jid))}\" has connected");
                }
                case GLFW.DISCONNECTED -> System.out.println(STR."Joystick \{jid} has disconnected");
            }
        });

        GLFW.showWindow(window);
    }

    private void loop() {
        var states = new GLFWGamepadState[GLFW.JOYSTICK_LAST + 1];
        for (int i = 0; i < states.length; i++) {
            states[i] = GLFWGamepadState.create(Arena.global());
        }
        while (!GLFW.windowShouldClose(window)) {
//            try (var arena = Arena.openShared()) {
            for (int i = 0; i <= GLFW.JOYSTICK_LAST; i++) {
                if (GLFW.joystickPresent(i)) {
                    if (GLFW.joystickIsGamepad(i)) {
                        var state = states[i];
                        if (GLFW.getGamepadState(i, state)) {
                            System.out.println(STR."""
                                Get gamepad state for [jid=\{i},name=\{GLFW.getGamepadName(i)}] successful:
                                Buttons: [A(Cross)=\{state.button(GLFW.GAMEPAD_BUTTON_A)}, B(Circle)=\{state.button(GLFW.GAMEPAD_BUTTON_B)}, X(Square)=\{state.button(GLFW.GAMEPAD_BUTTON_X)}, Y(Triangle)=\{state.button(GLFW.GAMEPAD_BUTTON_Y)},
                                Left bumper=\{state.button(GLFW.GAMEPAD_BUTTON_LEFT_BUMPER)}, Right bumper=\{state.button(GLFW.GAMEPAD_BUTTON_RIGHT_BUMPER)}, Back=\{state.button(GLFW.GAMEPAD_BUTTON_BACK)}, Start=\{state.button(GLFW.GAMEPAD_BUTTON_START)},
                                Guide=\{state.button(GLFW.GAMEPAD_BUTTON_GUIDE)}, Left thumb=\{state.button(GLFW.GAMEPAD_BUTTON_LEFT_THUMB)}, Right thumb=\{state.button(GLFW.GAMEPAD_BUTTON_RIGHT_THUMB)},
                                DPAD(up=\{state.button(GLFW.GAMEPAD_BUTTON_DPAD_UP)}, right=\{state.button(GLFW.GAMEPAD_BUTTON_DPAD_RIGHT)}, down=\{state.button(GLFW.GAMEPAD_BUTTON_DPAD_DOWN)}, left=\{state.button(GLFW.GAMEPAD_BUTTON_DPAD_LEFT)})],
                                Axis: [Left(x=\{state.axe(GLFW.GAMEPAD_AXIS_LEFT_X)}, y=\{state.axe(GLFW.GAMEPAD_AXIS_LEFT_Y)}), Right(x=\{state.axe(GLFW.GAMEPAD_AXIS_RIGHT_X)}, y=\{state.axe(GLFW.GAMEPAD_AXIS_RIGHT_Y)}), Trigger(left=\{state.axe(GLFW.GAMEPAD_AXIS_LEFT_TRIGGER)}, right\{state.axe(GLFW.GAMEPAD_AXIS_RIGHT_TRIGGER)})]
                                """);
                        }
                    }
                }
            }
//        }
            GLFW.waitEventsTimeout(3);
        }
    }

    public static void main(String[] args) {
        new GLFWJoystickTest().run();
    }
}
