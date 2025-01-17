/*
 * MIT License
 *
 * Copyright (c) 2023 Overrun Organization
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

package overrungl.nfd;

import overrungl.ArrayPointer;
import overrungl.Struct;
import overrungl.util.value.Pair;

import java.lang.foreign.*;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.VarHandle;

/**
 * <h2>Layout</h2>
 * <pre><code>
 * struct nfdnfilteritem_t {
 *     const nfdnchar_t* {@link #name() name};
 *     const nfdnchar_t* {@link #spec() spec};
 * }</code></pre>
 *
 * @author squid233
 * @since 0.1.0
 */
public sealed class NFDNFilterItem extends Struct {
    /**
     * The struct layout.
     */
    public static final StructLayout LAYOUT = MemoryLayout.structLayout(
        ValueLayout.ADDRESS.withName("name"),
        ValueLayout.ADDRESS.withName("spec")
    );
    private static final VarHandle
        pName = LAYOUT.varHandle(PathElement.groupElement("name")),
        pSpec = LAYOUT.varHandle(PathElement.groupElement("spec"));

    /**
     * Create a {@code NFDNFilterItem} instance.
     *
     * @param address the address.
     */
    public NFDNFilterItem(MemorySegment address) {
        super(address, LAYOUT);
    }

    /**
     * Creates a struct instance with the given memory layout.
     *
     * @param address the address.
     * @param layout  the memory layout of this struct.
     */
    protected NFDNFilterItem(MemorySegment address, MemoryLayout layout) {
        super(address, layout);
    }

    /**
     * {@return the elements size of this struct in bytes}
     */
    public static long sizeof() {
        return LAYOUT.byteSize();
    }

    /**
     * Creates a {@code NFDNFilterItem} instance with the given allocator.
     *
     * @param allocator the allocator
     * @param name      the name of the filter
     * @param spec      the specification of the filter
     * @return the instance
     */
    public static NFDNFilterItem create(SegmentAllocator allocator, String name, String spec) {
        final NFDNFilterItem item = new NFDNFilterItem(allocator.allocate(LAYOUT));
        pName.set(item.segment(), NFD.allocateString(name));
        pSpec.set(item.segment(), NFD.allocateString(spec));
        return item;
    }

    /**
     * Creates a {@code NFDNFilterItem.Buffer} instance with the given allocator and items.
     *
     * @param allocator the allocator
     * @param items     the items
     * @return the instance
     */
    @SafeVarargs
    public static Buffer create(SegmentAllocator allocator, Pair<String>... items) {
        final Buffer buffer = new Buffer(allocator.allocateArray(LAYOUT, items.length), items.length);
        for (int i = 0, len = items.length; i < len; i++) {
            Pair<String> item = items[i];
            buffer.pName.set(buffer.segment(), (long) i, NFD.allocateString(item.key()));
            buffer.pSpec.set(buffer.segment(), (long) i, NFD.allocateString(item.value()));
        }
        return buffer;
    }

    /**
     * {@return the name of the filter}
     */
    public MemorySegment nname() {
        return (MemorySegment) pName.get(segment());
    }

    /**
     * {@return the name of the filter}
     *
     * @see #nname()
     */
    public String name() {
        return NFD.getString(nname(), 0);
    }

    /**
     * {@return the spec of the filter}
     */
    public MemorySegment nspec() {
        return (MemorySegment) pSpec.get(segment());
    }

    /**
     * {@return the spec of the filter}
     *
     * @see #nspec()
     */
    public String spec() {
        return NFD.getString(nspec(), 0);
    }

    /**
     * @author squid233
     * @since 0.1.0
     */
    public static final class Buffer extends NFDNFilterItem implements ArrayPointer {
        private final VarHandle pName, pSpec;

        /**
         * Create a {@code NFDNFilterItem.Buffer} instance.
         *
         * @param address      the address.
         * @param elementCount the element count
         */
        public Buffer(MemorySegment address, long elementCount) {
            super(address, MemoryLayout.sequenceLayout(elementCount, LAYOUT));
            pName = layout().varHandle(PathElement.sequenceElement(), PathElement.groupElement("name"));
            pSpec = layout().varHandle(PathElement.sequenceElement(), PathElement.groupElement("spec"));
        }

        /**
         * {@return the name at the given index}
         *
         * @param index the index
         */
        public MemorySegment nnameAt(long index) {
            return (MemorySegment) pName.get(segment(), index);
        }

        /**
         * {@return the name at the given index}
         *
         * @param index the index
         */
        public String nameAt(long index) {
            return NFD.getString(nnameAt(index), 0);
        }

        /**
         * {@return the spec at the given index}
         *
         * @param index the index
         */
        public MemorySegment nspecAt(long index) {
            return (MemorySegment) pSpec.get(segment(), index);
        }

        /**
         * {@return the spec at the given index}
         *
         * @param index the index
         */
        public String specAt(long index) {
            return NFD.getString(nspecAt(index), 0);
        }

        @Override
        public MemorySegment nname() {
            return nnameAt(0);
        }

        @Override
        public String name() {
            return nameAt(0);
        }

        @Override
        public MemorySegment nspec() {
            return nspecAt(0);
        }

        @Override
        public String spec() {
            return specAt(0);
        }
    }
}
