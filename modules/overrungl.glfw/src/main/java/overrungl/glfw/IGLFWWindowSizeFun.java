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

package overrungl.glfw;

import overrungl.Callback;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * This is the function pointer type for window size callbacks. A window size
 * callback function has the following signature:
 * {@snippet :
 * @Invoker(IGLFWWindowSizeFun::invoke)
 * void callbackName(MemorySegment window, int width, int height);
 * }
 *
 * @author squid233
 * @see GLFW#setWindowSizeCallback
 * @since 0.1.0
 */
@FunctionalInterface
public interface IGLFWWindowSizeFun extends Callback {
    FunctionDescriptor DESC = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT);
    MethodType MTYPE = DESC.toMethodType();

    /**
     * The function pointer type for window size callbacks.
     *
     * @param window The window that was resized.
     * @param width  The new width, in screen coordinates, of the window.
     * @param height The new height, in screen coordinates, of the window.
     */
    void invoke(MemorySegment window, int width, int height);

    @Override
    default FunctionDescriptor descriptor() {
        return DESC;
    }

    @Override
    default MethodHandle handle(MethodHandles.Lookup lookup) throws NoSuchMethodException, IllegalAccessException {
        return lookup.findVirtual(IGLFWWindowSizeFun.class, "invoke", MTYPE);
    }
}
