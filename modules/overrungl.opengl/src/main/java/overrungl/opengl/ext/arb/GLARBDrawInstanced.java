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

package overrungl.opengl.ext.arb;

import overrungl.opengl.GLExtCaps;
import overrungl.opengl.GLLoadFunc;
import overrungl.opengl.GLLoader;
import overrungl.FunctionDescriptors;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

import static java.lang.foreign.ValueLayout.*;

/**
 * {@code GL_ARB_draw_instanced}
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GLARBDrawInstanced {
    public static void load(GLExtCaps ext, GLLoadFunc load) {
        if (!ext.GL_ARB_draw_instanced) return;
        ext.glDrawArraysInstancedARB = load.invoke("glDrawArraysInstancedARB", FunctionDescriptors.IIIIV);
        ext.glDrawElementsInstancedARB = load.invoke("glDrawElementsInstancedARB", FunctionDescriptors.IIIPIV);
    }

    public static void glDrawArraysInstancedARB(int mode, int first, int count, int primCount) {
        var ext = GLLoader.getExtCapabilities();
        try {
            GLLoader.check(ext.glDrawArraysInstancedARB).invokeExact(mode, first, count, primCount);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }

    public static void glDrawElementsInstancedARB(int mode, int count, int type, MemorySegment indices, int primCount) {
        var ext = GLLoader.getExtCapabilities();
        try {
            GLLoader.check(ext.glDrawElementsInstancedARB).invokeExact(mode, count, type, indices, primCount);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }

    public static void glDrawElementsInstancedARB(SegmentAllocator allocator, int mode, int count, int type, byte[] indices, int primCount) {
        glDrawElementsInstancedARB(mode, count, type, allocator.allocateArray(JAVA_BYTE, indices), primCount);
    }

    public static void glDrawElementsInstancedARB(SegmentAllocator allocator, int mode, int count, int type, short[] indices, int primCount) {
        glDrawElementsInstancedARB(mode, count, type, allocator.allocateArray(JAVA_SHORT, indices), primCount);
    }

    public static void glDrawElementsInstancedARB(SegmentAllocator allocator, int mode, int count, int type, int[] indices, int primCount) {
        glDrawElementsInstancedARB(mode, count, type, allocator.allocateArray(JAVA_INT, indices), primCount);
    }
}
