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

package overrungl.opengl.ext.amd;

import overrungl.opengl.GLExtCaps;
import overrungl.opengl.GLLoadFunc;
import overrungl.opengl.GLLoader;

import static overrungl.FunctionDescriptors.IIIIIIV;

/**
 * {@code GL_AMD_framebuffer_multisample_advanced}
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GLAMDFramebufferMultisampleAdvanced {
    public static void load(GLExtCaps ext, GLLoadFunc load) {
        if (!ext.GL_AMD_framebuffer_multisample_advanced) return;
        ext.glNamedRenderbufferStorageMultisampleAdvancedAMD = load.invoke("glNamedRenderbufferStorageMultisampleAdvancedAMD", IIIIIIV);
        ext.glRenderbufferStorageMultisampleAdvancedAMD = load.invoke("glRenderbufferStorageMultisampleAdvancedAMD", IIIIIIV);
    }

    public static void glNamedRenderbufferStorageMultisampleAdvancedAMD(int renderbuffer, int samples, int storageSamples, int internalFormat, int width, int height) {
        var ext = GLLoader.getExtCapabilities();
        try {
            GLLoader.check(ext.glNamedRenderbufferStorageMultisampleAdvancedAMD).invokeExact(renderbuffer, samples, storageSamples, internalFormat, width, height);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }

    public static void glRenderbufferStorageMultisampleAdvancedAMD(int target, int samples, int storageSamples, int internalFormat, int width, int height) {
        var ext = GLLoader.getExtCapabilities();
        try {
            GLLoader.check(ext.glRenderbufferStorageMultisampleAdvancedAMD).invokeExact(target, samples, storageSamples, internalFormat, width, height);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }
}
