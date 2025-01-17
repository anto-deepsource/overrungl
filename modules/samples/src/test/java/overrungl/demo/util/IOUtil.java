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

package overrungl.demo.util;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * IO utilities
 *
 * @author squid233
 * @since 0.1.0
 */
public final class IOUtil {
    private IOUtil() {
    }

    private static MemorySegment resizeSegment(Arena arena, MemorySegment segment, long newCapacity) {
        return arena.allocate(newCapacity).copyFrom(segment);
    }

    /**
     * Reads the specified resource and returns the raw data as a {@link MemorySegment}.
     *
     * @param arena       the arena. must be {@link MemorySegment.Scope#isAlive() alive} until the data is no longer used.
     * @param resource    the resource to read.
     * @param segmentSize the initial segment size.
     * @param bufferSize  the buffer size for reading file.
     * @return the resource data.
     * @throws IOException if an IO error occurs.
     */
    public static MemorySegment ioResourceToSegment(Arena arena, String resource, long segmentSize, int bufferSize) throws IOException {
        final boolean isHttp = resource.startsWith("http");
        final Path path = isHttp ? null : Path.of(resource);

        // Check whether on local
        if (path != null && Files.isReadable(path)) {
            try (var fc = FileChannel.open(path)) {
                return fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size(), arena);
            }
        }

        // On classpath
        try (
            var is = isHttp ?
                new URI(resource).toURL().openStream() :
                Objects.requireNonNull(IOUtil.class.getClassLoader().getResourceAsStream(resource),
                    STR."Failed to load resource '\{resource}'!")
        ) {
            MemorySegment segment = arena.allocate(segmentSize);

            // Creates a byte array to avoid creating it each loop
            final byte[] bytes = new byte[bufferSize];
            long pos = 0;
            int count;
            while ((count = is.read(bytes)) > 0) {
                if (pos + count >= segment.byteSize()) {
                    segment = resizeSegment(arena, segment, Math.ceilDiv(segment.byteSize() * 3, 2)); // 50%
                }
                MemorySegment.copy(bytes, 0, segment, ValueLayout.JAVA_BYTE, pos, count);
                pos += count;
            }

            return segment.asSlice(0, pos);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(STR."Illegal URI: \{resource}", e);
        }
    }

    /**
     * Reads the specified resource and returns the raw data as a {@link MemorySegment}.
     *
     * @param arena       the arena. must be {@link MemorySegment.Scope#isAlive() alive} until the data is no longer used.
     * @param resource    the resource to read.
     * @param segmentSize the initial segment size.
     * @return the resource data.
     * @throws IOException if an IO error occurs.
     */
    public static MemorySegment ioResourceToSegment(Arena arena, String resource, long segmentSize) throws IOException {
        return ioResourceToSegment(arena, resource, segmentSize, 8192);
    }
}
