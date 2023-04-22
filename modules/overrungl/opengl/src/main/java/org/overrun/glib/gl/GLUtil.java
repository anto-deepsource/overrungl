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

package org.overrun.glib.gl;

import org.jetbrains.annotations.Nullable;
import org.overrun.glib.RuntimeHelper;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Locale;
import java.util.function.Consumer;

import static org.overrun.glib.RuntimeHelper.*;
import static org.overrun.glib.gl.ext.amd.GLAMDDebugOutput.*;
import static org.overrun.glib.gl.ext.arb.GLARBDebugOutput.*;

/**
 * OpenGL utilities.
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GLUtil {
    private GLUtil() {
    }

    /**
     * Detects the best debug output functionality to use and creates a callback that prints information to
     * {@link RuntimeHelper#apiLogger() API Logger}.
     * <p>
     * The callback function is returned as an {@link Arena},
     * that should reset to NULL and be {@link Arena#close() freed} when no longer needed, which is often after
     * destroy GL context.
     *
     * @return the arena.
     */
    @Nullable
    public static Arena setupDebugMessageCallback() {
        return setupDebugMessageCallback(apiLogger());
    }

    /**
     * Detects the best debug output functionality to use and creates a callback that prints information to the specified
     * logger.
     * <p>
     * The callback function is returned as a {@link Arena}, that should reset to NULL and be
     * {@link Arena#close() freed} when no longer needed, which is often after destroy GL context.
     *
     * @param logger the output logger.
     * @return the arena.
     */
    @Nullable
    public static Arena setupDebugMessageCallback(Consumer<String> logger) {
        var caps = GLLoader.getCapabilities();

        if (caps.Ver43 || caps.ext.GL_KHR_debug) {
            if (caps.Ver43) {
                apiLog("[GL] Using OpenGL 4.3 for error logging.");
            } else {
                apiLog("[GL] Using KHR_debug for error logging.");
            }
            var arena = Arena.openConfined();
            GL.debugMessageCallback(arena, (source, type, id, severity, message, userParam) -> {
                var sb = new StringBuilder(768);
                sb.append("[OverrunGL] OpenGL debug message\n");
                printDetail(sb, "ID", "0x" + Integer.toHexString(id).toUpperCase(Locale.ROOT));
                printDetail(sb, "Source", getDebugSource(source));
                printDetail(sb, "Type", getDebugType(type));
                printDetail(sb, "Severity", getDebugSeverity(severity));
                printDetail(sb, "Message", message);
                var stack = Thread.currentThread().getStackTrace();
                for (int i = 3; i < stack.length; i++) {
                    sb.append("    at ")
                        .append(stack[i])
                        .append("\n");
                }
                logger.accept(sb.toString());
            }, MemorySegment.NULL);
            // no need GL_KHR_debug
            if ((caps.Ver43 || caps.Ver30) &&
                (GL.getInteger(GL.CONTEXT_FLAGS) & GL.CONTEXT_FLAG_DEBUG_BIT) == 0) {
                apiLog("[GL] Warning: A non-debug context may not produce any debug output.");
                GL.enable(GL.DEBUG_OUTPUT);
            }
            return arena;
        }

        if (caps.ext.GL_ARB_debug_output) {
            apiLog("[GL] Using ARB_debug_output for error logging.");
            var arena = Arena.openConfined();
            glDebugMessageCallbackARB(arena, (source, type, id, severity, message, userParam) -> {
                var sb = new StringBuilder(768);
                sb.append("[OverrunGL] ARB_debug_output message\n");
                printDetail(sb, "ID", "0x" + Integer.toHexString(id).toUpperCase(Locale.ROOT));
                printDetail(sb, "Source", getSourceARB(source));
                printDetail(sb, "Type", getTypeARB(type));
                printDetail(sb, "Severity", getSeverityARB(severity));
                printDetail(sb, "Message", message);
                var stack = Thread.currentThread().getStackTrace();
                for (int i = 3; i < stack.length; i++) {
                    sb.append("    at ")
                        .append(stack[i])
                        .append("\n");
                }
                logger.accept(sb.toString());
            }, MemorySegment.NULL);
            return arena;
        }

        if (caps.ext.GL_AMD_debug_output) {
            apiLog("[GL] Using AMD_debug_output for error logging.");
            var arena = Arena.openConfined();
            glDebugMessageCallbackAMD(arena, (id, category, severity, message, userParam) -> {
                var sb = new StringBuilder(768);
                sb.append("[OverrunGL] AMD_debug_output message\n");
                printDetail(sb, "ID", "0x" + Integer.toHexString(id).toUpperCase(Locale.ROOT));
                printDetail(sb, "Category", getCategoryAMD(category));
                printDetail(sb, "Severity", getSeverityAMD(severity));
                printDetail(sb, "Message", message);
                var stack = Thread.currentThread().getStackTrace();
                for (int i = 3; i < stack.length; i++) {
                    sb.append("    at ")
                        .append(stack[i])
                        .append("\n");
                }
                logger.accept(sb.toString());
            }, MemorySegment.NULL);
            return arena;
        }

        apiLog("[GL] No debug output implementation is available.");
        return null;
    }

    private static void printDetail(StringBuilder sb, String type, String message) {
        sb.append("    ")
            .append(type)
            .append(": ")
            .append(message)
            .append("\n");
    }

    private static String getDebugSource(int source) {
        return switch (source) {
            case GL.DEBUG_SOURCE_API -> "API";
            case GL.DEBUG_SOURCE_WINDOW_SYSTEM -> "WINDOW SYSTEM";
            case GL.DEBUG_SOURCE_SHADER_COMPILER -> "SHADER COMPILER";
            case GL.DEBUG_SOURCE_THIRD_PARTY -> "THIRD PARTY";
            case GL.DEBUG_SOURCE_APPLICATION -> "APPLICATION";
            case GL.DEBUG_SOURCE_OTHER -> "OTHER";
            default -> unknownToken(source);
        };
    }

    private static String getDebugType(int type) {
        return switch (type) {
            case GL.DEBUG_TYPE_ERROR -> "ERROR";
            case GL.DEBUG_TYPE_DEPRECATED_BEHAVIOR -> "DEPRECATED BEHAVIOR";
            case GL.DEBUG_TYPE_UNDEFINED_BEHAVIOR -> "UNDEFINED BEHAVIOR";
            case GL.DEBUG_TYPE_PORTABILITY -> "PORTABILITY";
            case GL.DEBUG_TYPE_PERFORMANCE -> "PERFORMANCE";
            case GL.DEBUG_TYPE_OTHER -> "OTHER";
            case GL.DEBUG_TYPE_MARKER -> "MARKER";
            default -> unknownToken(type);
        };
    }

    private static String getDebugSeverity(int severity) {
        return switch (severity) {
            case GL.DEBUG_SEVERITY_HIGH -> "HIGH";
            case GL.DEBUG_SEVERITY_MEDIUM -> "MEDIUM";
            case GL.DEBUG_SEVERITY_LOW -> "LOW";
            case GL.DEBUG_SEVERITY_NOTIFICATION -> "NOTIFICATION";
            default -> unknownToken(severity);
        };
    }

    private static String getSourceARB(int source) {
        return switch (source) {
            case GL_DEBUG_SOURCE_API_ARB -> "API";
            case GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB -> "WINDOW SYSTEM";
            case GL_DEBUG_SOURCE_SHADER_COMPILER_ARB -> "SHADER COMPILER";
            case GL_DEBUG_SOURCE_THIRD_PARTY_ARB -> "THIRD PARTY";
            case GL_DEBUG_SOURCE_APPLICATION_ARB -> "APPLICATION";
            case GL_DEBUG_SOURCE_OTHER_ARB -> "OTHER";
            default -> unknownToken(source);
        };
    }

    private static String getTypeARB(int type) {
        return switch (type) {
            case GL_DEBUG_TYPE_ERROR_ARB -> "ERROR";
            case GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB -> "DEPRECATED BEHAVIOR";
            case GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB -> "UNDEFINED BEHAVIOR";
            case GL_DEBUG_TYPE_PORTABILITY_ARB -> "PORTABILITY";
            case GL_DEBUG_TYPE_PERFORMANCE_ARB -> "PERFORMANCE";
            case GL_DEBUG_TYPE_OTHER_ARB -> "OTHER";
            default -> unknownToken(type);
        };
    }

    private static String getSeverityARB(int severity) {
        return switch (severity) {
            case GL_DEBUG_SEVERITY_HIGH_ARB -> "HIGH";
            case GL_DEBUG_SEVERITY_MEDIUM_ARB -> "MEDIUM";
            case GL_DEBUG_SEVERITY_LOW_ARB -> "LOW";
            default -> unknownToken(severity);
        };
    }

    private static String getCategoryAMD(int category) {
        return switch (category) {
            case GL_DEBUG_CATEGORY_API_ERROR_AMD -> "API ERROR";
            case GL_DEBUG_CATEGORY_WINDOW_SYSTEM_AMD -> "WINDOW SYSTEM";
            case GL_DEBUG_CATEGORY_DEPRECATION_AMD -> "DEPRECATION";
            case GL_DEBUG_CATEGORY_UNDEFINED_BEHAVIOR_AMD -> "UNDEFINED BEHAVIOR";
            case GL_DEBUG_CATEGORY_PERFORMANCE_AMD -> "PERFORMANCE";
            case GL_DEBUG_CATEGORY_SHADER_COMPILER_AMD -> "SHADER COMPILER";
            case GL_DEBUG_CATEGORY_APPLICATION_AMD -> "APPLICATION";
            case GL_DEBUG_CATEGORY_OTHER_AMD -> "OTHER";
            default -> unknownToken(category);
        };
    }

    private static String getSeverityAMD(int severity) {
        return switch (severity) {
            case GL_DEBUG_SEVERITY_HIGH_AMD -> "HIGH";
            case GL_DEBUG_SEVERITY_MEDIUM_AMD -> "MEDIUM";
            case GL_DEBUG_SEVERITY_LOW_AMD -> "LOW";
            default -> unknownToken(severity);
        };
    }
}
