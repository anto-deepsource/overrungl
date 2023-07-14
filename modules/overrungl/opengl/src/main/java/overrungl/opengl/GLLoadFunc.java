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

package overrungl.opengl;

import org.jetbrains.annotations.Nullable;
import overrungl.FunctionDescriptors;
import overrungl.RuntimeHelper;

import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;

/**
 * The OpenGL loading function.
 *
 * <h2>Example</h2>
 * <pre>{@code
 * // loads OpenGL compatibility profile
 * if (GLLoader.loadConfined(true, GLFW::ngetProcAddress) == 0)
 *     throw new IllegalStateException("Failed to load OpenGL");
 * }</pre>
 *
 * @author squid233
 * @since 0.1.0
 */
public interface GLLoadFunc {
    /**
     * Creates a load function with given segment allocator.
     *
     * @param allocator the segment allocator.
     * @param function  the function pointer getter
     * @return the load function
     */
    static GLLoadFunc of(SegmentAllocator allocator, Getter function) {
        return new GLLoadFunc.Delegate(allocator, function);
    }

    /**
     * Gets the function pointer of the given GL function.
     *
     * @param string the address of the string.
     * @return the function pointer.
     */
    MemorySegment invoke(MemorySegment string);

    /**
     * Load a function by the given name and creates a downcall handle or {@code null}.
     *
     * @param procName the function name
     * @param function the function descriptor of the target function.
     * @param options  the linker options associated with this linkage request.
     * @return a downcall method handle,  or {@code null} if the symbol is {@link MemorySegment#NULL}
     */
    @Nullable
    MethodHandle invoke(String procName, FunctionDescriptors function, Linker.Option... options);

    /**
     * Load a trivial function by the given name and creates a downcall handle or {@code null}.
     *
     * @param procName the function name
     * @param function the function descriptor of the target function.
     * @return a downcall method handle,  or {@code null} if the symbol is {@link MemorySegment#NULL}
     */
    default MethodHandle trivialHandle(String procName, FunctionDescriptors function) {
        return invoke(procName, function, Linker.Option.isTrivial());
    }

    /**
     * The GL function pointer getter.
     *
     * @author squid233
     * @since 0.1.0
     */
    @FunctionalInterface
    interface Getter {
        /**
         * Gets the function pointer of the given GL function.
         *
         * @param string the address of the string.
         * @return the function pointer.
         */
        MemorySegment get(MemorySegment string);
    }

    /**
     * The delegate contained a segment allocator and the callback.
     *
     * @param allocator the segment allocator
     * @param func      the loading function
     * @author squid233
     * @since 0.1.0
     */
    record Delegate(SegmentAllocator allocator, Getter func) implements GLLoadFunc {
        @Override
        public MemorySegment invoke(MemorySegment string) {
            return func.get(string);
        }

        @Override
        public @Nullable MethodHandle invoke(String procName, FunctionDescriptors function, Linker.Option... options) {
            return RuntimeHelper.downcallSafe(invoke(allocator.allocateUtf8String(procName)), function, options);
        }
    }
}
