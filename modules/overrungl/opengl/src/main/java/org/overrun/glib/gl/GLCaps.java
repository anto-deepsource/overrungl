/*
 * MIT License
 *
 * Copyright (c) 2022 Overrun Organization
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
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.overrun.glib.gl;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.overrun.glib.FunctionDescriptors;

import java.lang.foreign.MemorySession;
import java.lang.invoke.MethodHandle;
import java.util.regex.Pattern;

/**
 * The OpenGL loader.
 *
 * @author squid233
 * @since 0.1.0
 */
public class GLCaps {
    private static final Pattern VERSION_PATTERN = Pattern.compile("^(\\d+)\\.(\\d+).*$");

    /**
     * The OpenGL context version flags
     */
    public static boolean
        Ver10, Ver11, Ver12, Ver13, Ver14, Ver15,
        Ver20, Ver21,
        Ver30, Ver31, Ver32, Ver33,
        Ver40, Ver41, Ver42, Ver43, Ver44, Ver45, Ver46;
    /**
     * Forward compatible flag. {@code false} for deprecated and removed function.
     */
    public static boolean forwardCompatible;

    @NotNull
    @Contract(value = "null -> fail; !null -> param1", pure = true)
    public static MethodHandle check(MethodHandle handle) {
        if (handle == null)
            throw new IllegalStateException("The argument 'handle' is null; may be no context or function exists.");
        return handle;
    }

    static boolean checkAll(MethodHandle... handles) {
        for (var handle : handles) {
            if (handle == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Pack the version into an integer.
     *
     * @param major the major version
     * @param minor the minor version
     * @return the packed version
     */
    public static int makeVersion(int major, int minor) {
        return major * 10000 + minor;
    }

    /**
     * Gets the major version.
     *
     * @param version the packed version
     * @return the major version
     */
    public static int versionMajor(int version) {
        return version / 10000;
    }

    /**
     * Gets the minor version.
     *
     * @param version the packed version
     * @return the minor version
     */
    public static int versionMinor(int version) {
        return version % 10000;
    }

    /**
     * Load OpenGL compatibility profile by the given load function with shared memory session.
     *
     * @param getter the function pointer getter
     * @return the OpenGL version returned from the graphics driver, or {@code 0} if no OpenGL context found.
     * no guaranteed to actually supported version, please use {@code Ver##}
     */
    public static int loadShared(GLLoadFunc.Getter getter) {
        try (var load = GLLoadFunc.ofShared(getter)) {
            return load(load);
        }
    }

    /**
     * Load OpenGL by the given load function with shared memory session.
     *
     * @param forwardCompatible If {@code true}, only loading core profile functions.
     * @param getter            the function pointer getter
     * @return the OpenGL version returned from the graphics driver, or {@code 0} if no OpenGL context found.
     * no guaranteed to actually supported version, please use {@code Ver##}
     */
    public static int loadShared(boolean forwardCompatible, GLLoadFunc.Getter getter) {
        try (var load = GLLoadFunc.ofShared(getter)) {
            return load(forwardCompatible, load);
        }
    }

    /**
     * Load OpenGL compatibility profile by the given load function with the given memory session.
     *
     * @param getter  the function pointer getter
     * @param session the memory session. will be <b>auto-closed</b>
     * @return the OpenGL version returned from the graphics driver, or {@code 0} if no OpenGL context found.
     * no guaranteed to actually supported version, please use {@code Ver##}
     */
    public static int load(MemorySession session, GLLoadFunc.Getter getter) {
        try (var load = GLLoadFunc.of(session, getter)) {
            return load(load);
        }
    }

    /**
     * Load OpenGL by the given load function with the given memory session.
     *
     * @param forwardCompatible If {@code true}, only loading core profile functions.
     * @param session           the memory session. will be <b>auto-closed</b>
     * @param getter            the function pointer getter
     * @return the OpenGL version returned from the graphics driver, or {@code 0} if no OpenGL context found.
     * no guaranteed to actually supported version, please use {@code Ver##}
     */
    public static int load(boolean forwardCompatible, MemorySession session, GLLoadFunc.Getter getter) {
        try (var load = GLLoadFunc.of(session, getter)) {
            return load(forwardCompatible, load);
        }
    }

    /**
     * Load OpenGL compatibility profile by the given load function.
     *
     * @param load the load function
     * @return the OpenGL version returned from the graphics driver, or {@code 0} if no OpenGL context found.
     * no guaranteed to actually supported version, please use {@code Ver##}
     */
    public static int load(GLLoadFunc load) {
        return load(false, load);
    }

    /**
     * Load OpenGL by the given load function.
     *
     * @param forwardCompatible If {@code true}, only loading core profile functions.
     * @param load              the load function
     * @return the OpenGL version returned from the graphics driver, or {@code 0} if no OpenGL context found.
     * no guaranteed to actually supported version, please use {@code Ver##}
     */
    public static int load(boolean forwardCompatible, GLLoadFunc load) {
        GL10C.glGetString = load.invoke("glGetString", FunctionDescriptors.IP);
        if (GL10C.glGetString == null) return 0;
        if (GL10C.getString(GLConstC.GL_VERSION) == null) return 0;

        GLCaps.forwardCompatible = forwardCompatible;

        GL10C.load(load);
        GL11C.load(load);
        GL12C.load(load);
        GL13C.load(load);
        GL14C.load(load);
        GL15C.load(load);
        GL20C.load(load);
        GL21C.load(load);
        GL30C.load(load);
        GL31C.load(load);
        GL32C.load(load);
        GL33C.load(load);
        GL40C.load(load);
        GL41C.load(load);
        GL42C.load(load);
        GL43C.load(load);
        GL44C.load(load);
        GL45C.load(load);
        GL46C.load(load);

        int version = findCoreGL();
        if (!forwardCompatible) {
            GL10.load(load);
            GL11.load(load);
            GL13.load(load);
            GL14.load(load);
        }

        try (var session = MemorySession.openShared()) {
            if (!GLExtCaps.findExtensionsGL(version, session)) return 0;
        }
        GLExtCaps.load(load);

        return version;
    }

    private static int findCoreGL() {
        final String[] prefixes = {
            "OpenGL ES-CM ",
            "OpenGL ES-CL ",
            "OpenGL ES ",
            "OpenGL SC "
        };
        var version = GL10C.getString(GLConstC.GL_VERSION);
        if (version == null) return 0;
        for (var prefix : prefixes) {
            int len = prefix.length();
            if (version.startsWith(prefix)) {
                version = version.substring(len);
                break;
            }
        }
        var matcher = VERSION_PATTERN.matcher(version);
        int major, minor;
        if (matcher.find()) {
            major = Integer.parseInt(matcher.group(1));
            minor = Integer.parseInt(matcher.group(2));
        } else {
            major = 0;
            minor = 0;
        }
        Ver10 = (major == 1 && minor >= 0) || major > 1 || GL10C.isSupported();
        Ver11 = (major == 1 && minor >= 1) || major > 1 || GL11C.isSupported();
        Ver12 = (major == 1 && minor >= 2) || major > 1 || GL12C.isSupported();
        Ver13 = (major == 1 && minor >= 3) || major > 1 || GL13C.isSupported();
        Ver14 = (major == 1 && minor >= 4) || major > 1 || GL14C.isSupported();
        Ver15 = (major == 1 && minor >= 5) || major > 1 || GL15C.isSupported();
        Ver20 = (major == 2 && minor >= 0) || major > 2 || GL20C.isSupported();
        Ver21 = (major == 2 && minor >= 1) || major > 2 || GL21C.isSupported();
        Ver30 = (major == 3 && minor >= 0) || major > 3 || GL30C.isSupported();
        Ver31 = (major == 3 && minor >= 1) || major > 3 || GL31C.isSupported();
        Ver32 = (major == 3 && minor >= 2) || major > 3 || GL32C.isSupported();
        Ver33 = (major == 3 && minor >= 3) || major > 3 || GL33C.isSupported();
        Ver40 = (major == 4 && minor >= 0) || major > 4 || GL40C.isSupported();
        Ver41 = (major == 4 && minor >= 1) || major > 4 || GL41C.isSupported();
        Ver42 = (major == 4 && minor >= 2) || major > 4 || GL42C.isSupported();
        Ver43 = (major == 4 && minor >= 3) || major > 4 || GL43C.isSupported();
        Ver44 = (major == 4 && minor >= 4) || major > 4 || GL44C.isSupported();
        Ver45 = (major == 4 && minor >= 5) || major > 4 || GL45C.isSupported();
        Ver46 = (major == 4 && minor >= 6) || major > 4 || GL46C.isSupported();
        return makeVersion(major, minor);
    }
}
