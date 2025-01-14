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

/**
 * {@code GL_ARB_ES3_1_compatibility}
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GLARBES32Compatibility {
    public static final int GL_PRIMITIVE_BOUNDING_BOX_ARB = 0x92BE;
    public static final int GL_MULTISAMPLE_LINE_WIDTH_RANGE_ARB = 0x9381;
    public static final int GL_MULTISAMPLE_LINE_WIDTH_GRANULARITY_ARB = 0x9382;

    public static void load(GLExtCaps ext, GLLoadFunc load) {
        if (!ext.GL_ARB_ES3_2_compatibility) return;
        ext.glPrimitiveBoundingBoxARB = load.invoke("glPrimitiveBoundingBoxARB", FunctionDescriptors.FFFFFFFFV);
    }

    public static void glPrimitiveBoundingBoxARB(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
        var ext = GLLoader.getExtCapabilities();
        try {
            GLLoader.check(ext.glPrimitiveBoundingBoxARB).invokeExact(minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }
}
