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
 * This is the function pointer type for mouse button callback functions.
 * A mouse button callback function has the following signature:
 * {@snippet :
 * @Invoker(IGLFWMouseButtonFun::invoke)
 * void functionName(MemorySegment window, int button, int action, int mods);
 * }
 *
 * @author squid233
 * @see GLFW#setMouseButtonCallback
 * @since 0.1.0
 */
@FunctionalInterface
public interface IGLFWMouseButtonFun extends Callback {
    FunctionDescriptor DESC = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT);
    MethodType MTYPE = DESC.toMethodType();

    /**
     * The function pointer type for mouse button callbacks.
     *
     * @param window The window that received the event.
     * @param button The <a href="https://www.glfw.org/docs/latest/group__buttons.html">mouse button</a> that was pressed or released.
     * @param action One of {@code PRESS} or {@code RELEASE}. Future releases may add more actions.
     * @param mods   Bit field describing which <a href="https://www.glfw.org/docs/latest/group__mods.html">modifier keys</a> were held down.
     */
    void invoke(MemorySegment window, int button, int action, int mods);

    @Override
    default FunctionDescriptor descriptor() {
        return DESC;
    }

    @Override
    default MethodHandle handle(MethodHandles.Lookup lookup) throws NoSuchMethodException, IllegalAccessException {
        return lookup.findVirtual(IGLFWMouseButtonFun.class, "invoke", MTYPE);
    }
}
