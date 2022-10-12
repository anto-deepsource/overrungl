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

import org.overrun.glib.gl.ext.*;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;

/**
 * The OpenGL extension loader.
 *
 * @author squid233
 * @since 0.1.0
 */
public class GLExtCaps {
    public static boolean
        GL_3DFX_multisample, GL_3DFX_tbuffer, GL_3DFX_texture_compression_FXT1, GL_AMD_blend_minmax_factor,
        GL_AMD_conservative_depth, GL_AMD_debug_output, GL_AMD_depth_clamp_separate, GL_AMD_draw_buffers_blend,
        GL_AMD_framebuffer_multisample_advanced, GL_AMD_framebuffer_sample_positions, GL_AMD_gcn_shader,
        GL_AMD_gpu_shader_half_float, GL_AMD_gpu_shader_int16, GL_AMD_gpu_shader_int64, GL_AMD_interleaved_elements,
        GL_AMD_multi_draw_indirect, GL_AMD_name_gen_delete, GL_AMD_occlusion_query_event, GL_AMD_performance_monitor,
        GL_AMD_pinned_memory, GL_AMD_query_buffer_object, GL_AMD_sample_positions, GL_AMD_seamless_cubemap_per_texture,
        GL_AMD_shader_atomic_counter_ops, GL_AMD_shader_ballot, GL_AMD_shader_explicit_vertex_parameter,
        GL_AMD_shader_gpu_shader_half_float_fetch, GL_AMD_shader_image_load_store_lod, GL_AMD_shader_stencil_export,
        GL_AMD_shader_trinary_minmax, GL_AMD_sparse_texture, GL_AMD_stencil_operation_extended,
        GL_AMD_texture_gather_bias_lod, GL_AMD_texture_texture4, GL_AMD_transform_feedback3_lines_triangles,
        GL_AMD_transform_feedback4, GL_AMD_vertex_shader_layer, GL_AMD_vertex_shader_tessellator,
        GL_AMD_vertex_shader_viewport_index, GL_APPLE_aux_depth_stencil, GL_APPLE_client_storage, GL_APPLE_element_array,
        GL_APPLE_fence, GL_APPLE_float_pixels, GL_APPLE_flush_buffer_range, GL_APPLE_object_purgeable, GL_APPLE_rgb_422,
        GL_APPLE_row_bytes, GL_APPLE_specular_vector, GL_APPLE_texture_range, GL_APPLE_transform_hint,
        GL_APPLE_vertex_array_object, GL_APPLE_vertex_array_range, GL_APPLE_vertex_program_evaluators, GL_APPLE_ycbcr_422,
        GL_ARB_ES2_compatibility, GL_ARB_ES3_1_compatibility, GL_ARB_ES3_2_compatibility, GL_ARB_ES3_compatibility,
        GL_ARB_arrays_of_arrays, GL_ARB_base_instance, GL_ARB_bindless_texture, GL_ARB_blend_func_extended,
        GL_ARB_buffer_storage, GL_ARB_cl_event, GL_ARB_clear_buffer_object, GL_ARB_clear_texture, GL_ARB_clip_control,
        GL_ARB_color_buffer_float, GL_ARB_compatibility, GL_ARB_compressed_texture_pixel_storage, GL_ARB_compute_shader,
        GL_ARB_compute_variable_group_size, GL_ARB_conditional_render_inverted, GL_ARB_conservative_depth, GL_ARB_copy_buffer,
        GL_ARB_copy_image, GL_ARB_cull_distance, GL_ARB_debug_output, GL_ARB_depth_buffer_float, GL_ARB_depth_clamp,
        GL_ARB_depth_texture, GL_ARB_derivative_control, GL_ARB_direct_state_access, GL_ARB_draw_buffers,
        GL_ARB_draw_buffers_blend, GL_ARB_draw_elements_base_vertex, GL_ARB_draw_indirect, GL_ARB_draw_instanced,
        GL_ARB_enhanced_layouts, GL_ARB_explicit_attrib_location, GL_ARB_explicit_uniform_location,
        GL_ARB_fragment_coord_conventions, GL_ARB_fragment_layer_viewport, GL_ARB_fragment_program,
        GL_ARB_fragment_program_shadow, GL_ARB_fragment_shader, GL_ARB_fragment_shader_interlock,
        GL_ARB_framebuffer_no_attachments, GL_ARB_framebuffer_object, GL_ARB_framebuffer_sRGB, GL_ARB_geometry_shader4,
        GL_ARB_get_program_binary, GL_ARB_get_texture_sub_image, GL_ARB_gl_spirv, GL_ARB_gpu_shader5, GL_ARB_gpu_shader_fp64,
        GL_ARB_gpu_shader_int64, GL_ARB_half_float_pixel, GL_ARB_half_float_vertex, GL_ARB_imaging, GL_ARB_indirect_parameters,
        GL_ARB_instanced_arrays, GL_ARB_internalformat_query, GL_ARB_internalformat_query2, GL_ARB_invalidate_subdata,
        GL_ARB_map_buffer_alignment, GL_ARB_map_buffer_range, GL_ARB_matrix_palette, GL_ARB_multi_bind,
        GL_ARB_multi_draw_indirect, GL_ARB_multisample, GL_ARB_multitexture, GL_ARB_occlusion_query, GL_ARB_occlusion_query2,
        GL_ARB_parallel_shader_compile, GL_ARB_pipeline_statistics_query, GL_ARB_pixel_buffer_object, GL_ARB_point_parameters,
        GL_ARB_point_sprite, GL_ARB_polygon_offset_clamp, GL_ARB_post_depth_coverage, GL_ARB_program_interface_query,
        GL_ARB_provoking_vertex, GL_ARB_query_buffer_object, GL_ARB_robust_buffer_access_behavior, GL_ARB_robustness,
        GL_ARB_robustness_isolation, GL_ARB_sample_locations, GL_ARB_sample_shading, GL_ARB_sampler_objects,
        GL_ARB_seamless_cube_map, GL_ARB_seamless_cubemap_per_texture, GL_ARB_separate_shader_objects,
        GL_ARB_shader_atomic_counter_ops, GL_ARB_shader_atomic_counters, GL_ARB_shader_ballot, GL_ARB_shader_bit_encoding,
        GL_ARB_shader_clock, GL_ARB_shader_draw_parameters, GL_ARB_shader_group_vote, GL_ARB_shader_image_load_store,
        GL_ARB_shader_image_size, GL_ARB_shader_objects, GL_ARB_shader_precision, GL_ARB_shader_stencil_export,
        GL_ARB_shader_storage_buffer_object, GL_ARB_shader_subroutine, GL_ARB_shader_texture_image_samples,
        GL_ARB_shader_texture_lod, GL_ARB_shader_viewport_layer_array, GL_ARB_shading_language_100,
        GL_ARB_shading_language_420pack, GL_ARB_shading_language_include, GL_ARB_shading_language_packing, GL_ARB_shadow,
        GL_ARB_shadow_ambient, GL_ARB_sparse_buffer, GL_ARB_sparse_texture, GL_ARB_sparse_texture2, GL_ARB_sparse_texture_clamp,
        GL_ARB_spirv_extensions, GL_ARB_stencil_texturing, GL_ARB_sync, GL_ARB_tessellation_shader, GL_ARB_texture_barrier,
        GL_ARB_texture_border_clamp, GL_ARB_texture_buffer_object, GL_ARB_texture_buffer_object_rgb32, GL_ARB_texture_buffer_range,
        GL_ARB_texture_compression, GL_ARB_texture_compression_bptc, GL_ARB_texture_compression_rgtc,
        GL_ARB_texture_cube_map, GL_ARB_texture_cube_map_array, GL_ARB_texture_env_add, GL_ARB_texture_env_combine,
        GL_ARB_texture_env_crossbar, GL_ARB_texture_env_dot3, GL_ARB_texture_filter_anisotropic, GL_ARB_texture_filter_minmax,
        GL_ARB_texture_float, GL_ARB_texture_gather, GL_ARB_texture_mirror_clamp_to_edge, GL_ARB_texture_mirrored_repeat,
        GL_ARB_texture_multisample, GL_ARB_texture_non_power_of_two, GL_ARB_texture_query_levels, GL_ARB_texture_query_lod,
        GL_ARB_texture_rectangle, GL_ARB_texture_rg, GL_ARB_texture_rgb10_a2ui, GL_ARB_texture_stencil8, GL_ARB_texture_storage,
        GL_ARB_texture_storage_multisample, GL_ARB_texture_swizzle, GL_ARB_texture_view, GL_ARB_timer_query,
        GL_ARB_transform_feedback2, GL_ARB_transform_feedback3, GL_ARB_transform_feedback_instanced,
        GL_ARB_transform_feedback_overflow_query, GL_ARB_transpose_matrix, GL_ARB_uniform_buffer_object, GL_ARB_vertex_array_bgra,
        GL_ARB_vertex_array_object, GL_ARB_vertex_attrib_64bit, GL_ARB_vertex_attrib_binding, GL_ARB_vertex_blend,
        GL_ARB_vertex_buffer_object, GL_ARB_vertex_program, GL_ARB_vertex_shader, GL_ARB_vertex_type_10f_11f_11f_rev,
        GL_ARB_vertex_type_2_10_10_10_rev, GL_ARB_viewport_array, GL_ARB_window_pos, GL_ATI_draw_buffers, GL_ATI_element_array,
        GL_ATI_envmap_bumpmap, GL_ATI_fragment_shader, GL_ATI_map_object_buffer, GL_ATI_meminfo, GL_ATI_pixel_format_float,
        GL_ATI_pn_triangles, GL_ATI_separate_stencil, GL_ATI_text_fragment_shader, GL_ATI_texture_env_combine3, GL_ATI_texture_float,
        GL_ATI_texture_mirror_once, GL_ATI_vertex_array_object, GL_ATI_vertex_attrib_array_object, GL_ATI_vertex_streams,
        GL_EXT_422_pixels, GL_EXT_EGL_image_storage, GL_EXT_EGL_sync, GL_EXT_abgr, GL_EXT_bgra, GL_EXT_bindable_uniform,
        GL_EXT_blend_color, GL_EXT_blend_equation_separate, GL_EXT_blend_func_separate, GL_EXT_blend_logic_op, GL_EXT_blend_minmax,
        GL_EXT_blend_subtract, GL_EXT_clip_volume_hint, GL_EXT_cmyka, GL_EXT_color_subtable, GL_EXT_compiled_vertex_array,
        GL_EXT_convolution, GL_EXT_coordinate_frame, GL_EXT_copy_texture, GL_EXT_cull_vertex, GL_EXT_debug_label, GL_EXT_debug_marker,
        GL_EXT_depth_bounds_test, GL_EXT_direct_state_access, GL_EXT_draw_buffers2, GL_EXT_draw_instanced, GL_EXT_draw_range_elements,
        GL_EXT_external_buffer, GL_EXT_fog_coord, GL_EXT_framebuffer_blit, GL_EXT_framebuffer_multisample,
        GL_EXT_framebuffer_multisample_blit_scaled, GL_EXT_framebuffer_object, GL_EXT_framebuffer_sRGB, GL_EXT_geometry_shader4,
        GL_EXT_gpu_program_parameters, GL_EXT_gpu_shader4, GL_EXT_histogram, GL_EXT_index_array_formats, GL_EXT_index_func,
        GL_EXT_index_material, GL_EXT_index_texture, GL_EXT_light_texture, GL_EXT_memory_object, GL_EXT_memory_object_fd,
        GL_EXT_memory_object_win32, GL_EXT_misc_attribute, GL_EXT_multi_draw_arrays, GL_EXT_multisample,
        GL_EXT_multiview_tessellation_geometry_shader, GL_EXT_multiview_texture_multisample, GL_EXT_multiview_timer_query,
        GL_EXT_packed_depth_stencil, GL_EXT_packed_float, GL_EXT_packed_pixels, GL_EXT_paletted_texture,
        GL_EXT_pixel_buffer_object, GL_EXT_pixel_transform, GL_EXT_pixel_transform_color_table, GL_EXT_point_parameters,
        GL_EXT_polygon_offset, GL_EXT_polygon_offset_clamp, GL_EXT_post_depth_coverage, GL_EXT_provoking_vertex,
        GL_EXT_raster_multisample, GL_EXT_rescale_normal, GL_EXT_secondary_color, GL_EXT_semaphore, GL_EXT_semaphore_fd,
        GL_EXT_semaphore_win32, GL_EXT_separate_shader_objects, GL_EXT_separate_specular_color, GL_EXT_shader_framebuffer_fetch,
        GL_EXT_shader_framebuffer_fetch_non_coherent, GL_EXT_shader_image_load_formatted, GL_EXT_shader_image_load_store,
        GL_EXT_shader_integer_mix, GL_EXT_shadow_funcs, GL_EXT_shared_texture_palette, GL_EXT_sparse_texture2,
        GL_EXT_stencil_clear_tag, GL_EXT_stencil_two_side, GL_EXT_stencil_wrap, GL_EXT_subtexture, GL_EXT_texture,
        GL_EXT_texture3D, GL_EXT_texture_array, GL_EXT_texture_buffer_object, GL_EXT_texture_compression_latc,
        GL_EXT_texture_compression_rgtc, GL_EXT_texture_compression_s3tc, GL_EXT_texture_cube_map, GL_EXT_texture_env_add,
        GL_EXT_texture_env_combine, GL_EXT_texture_env_dot3, GL_EXT_texture_filter_anisotropic, GL_EXT_texture_filter_minmax,
        GL_EXT_texture_integer, GL_EXT_texture_lod_bias, GL_EXT_texture_mirror_clamp, GL_EXT_texture_object,
        GL_EXT_texture_perturb_normal, GL_EXT_texture_sRGB, GL_EXT_texture_sRGB_R8, GL_EXT_texture_sRGB_RG8,
        GL_EXT_texture_sRGB_decode, GL_EXT_texture_shadow_lod, GL_EXT_texture_shared_exponent, GL_EXT_texture_snorm,
        GL_EXT_texture_storage, GL_EXT_texture_swizzle, GL_EXT_timer_query, GL_EXT_transform_feedback, GL_EXT_vertex_array,
        GL_EXT_vertex_array_bgra, GL_EXT_vertex_attrib_64bit, GL_EXT_vertex_shader, GL_EXT_vertex_weighting,
        GL_EXT_win32_keyed_mutex, GL_EXT_window_rectangles, GL_EXT_x11_sync_object, GL_GREMEDY_frame_terminator,
        GL_GREMEDY_string_marker, GL_HP_convolution_border_modes, GL_HP_image_transform, GL_HP_occlusion_test,
        GL_HP_texture_lighting, GL_IBM_cull_vertex, GL_IBM_multimode_draw_arrays, GL_IBM_rasterpos_clip, GL_IBM_static_data,
        GL_IBM_texture_mirrored_repeat, GL_IBM_vertex_array_lists, GL_INGR_blend_func_separate, GL_INGR_color_clamp,
        GL_INGR_interlace_read, GL_INTEL_blackhole_render, GL_INTEL_conservative_rasterization, GL_INTEL_fragment_shader_ordering,
        GL_INTEL_framebuffer_CMAA, GL_INTEL_map_texture, GL_INTEL_parallel_arrays, GL_INTEL_performance_query,
        GL_KHR_blend_equation_advanced, GL_KHR_blend_equation_advanced_coherent, GL_KHR_context_flush_control, GL_KHR_debug,
        GL_KHR_no_error, GL_KHR_parallel_shader_compile, GL_KHR_robust_buffer_access_behavior, GL_KHR_robustness,
        GL_KHR_shader_subgroup, GL_KHR_texture_compression_astc_hdr, GL_KHR_texture_compression_astc_ldr,
        GL_KHR_texture_compression_astc_sliced_3d, GL_MESAX_texture_stack, GL_MESA_framebuffer_flip_x, GL_MESA_framebuffer_flip_y,
        GL_MESA_framebuffer_swap_xy, GL_MESA_pack_invert, GL_MESA_program_binary_formats, GL_MESA_resize_buffers,
        GL_MESA_shader_integer_functions, GL_MESA_tile_raster_order, GL_MESA_window_pos, GL_MESA_ycbcr_texture,
        GL_NVX_blend_equation_advanced_multi_draw_buffers, GL_NVX_conditional_render, GL_NVX_gpu_memory_info,
        GL_NVX_gpu_multicast2, GL_NVX_linked_gpu_multicast, GL_NVX_progress_fence, GL_NV_alpha_to_coverage_dither_control,
        GL_NV_bindless_multi_draw_indirect, GL_NV_bindless_multi_draw_indirect_count, GL_NV_bindless_texture,
        GL_NV_blend_equation_advanced, GL_NV_blend_equation_advanced_coherent, GL_NV_blend_minmax_factor, GL_NV_blend_square,
        GL_NV_clip_space_w_scaling, GL_NV_command_list, GL_NV_compute_program5, GL_NV_compute_shader_derivatives,
        GL_NV_conditional_render, GL_NV_conservative_raster, GL_NV_conservative_raster_dilate, GL_NV_conservative_raster_pre_snap,
        GL_NV_conservative_raster_pre_snap_triangles, GL_NV_conservative_raster_underestimation, GL_NV_copy_depth_to_color,
        GL_NV_copy_image, GL_NV_deep_texture3D, GL_NV_depth_buffer_float, GL_NV_depth_clamp, GL_NV_draw_texture,
        GL_NV_draw_vulkan_image, GL_NV_evaluators, GL_NV_explicit_multisample, GL_NV_fence, GL_NV_fill_rectangle,
        GL_NV_float_buffer, GL_NV_fog_distance, GL_NV_fragment_coverage_to_color, GL_NV_fragment_program, GL_NV_fragment_program2,
        GL_NV_fragment_program4, GL_NV_fragment_program_option, GL_NV_fragment_shader_barycentric, GL_NV_fragment_shader_interlock,
        GL_NV_framebuffer_mixed_samples, GL_NV_framebuffer_multisample_coverage, GL_NV_geometry_program4, GL_NV_geometry_shader4,
        GL_NV_geometry_shader_passthrough, GL_NV_gpu_multicast, GL_NV_gpu_program4, GL_NV_gpu_program5,
        GL_NV_gpu_program5_mem_extended, GL_NV_gpu_shader5, GL_NV_half_float, GL_NV_internalformat_sample_query,
        GL_NV_light_max_exponent, GL_NV_memory_attachment, GL_NV_memory_object_sparse, GL_NV_mesh_shader,
        GL_NV_multisample_coverage, GL_NV_multisample_filter_hint, GL_NV_occlusion_query, GL_NV_packed_depth_stencil,
        GL_NV_parameter_buffer_object, GL_NV_parameter_buffer_object2, GL_NV_path_rendering, GL_NV_path_rendering_shared_edge,
        GL_NV_pixel_data_range, GL_NV_point_sprite, GL_NV_present_video, GL_NV_primitive_restart, GL_NV_primitive_shading_rate,
        GL_NV_query_resource, GL_NV_query_resource_tag, GL_NV_register_combiners, GL_NV_register_combiners2,
        GL_NV_representative_fragment_test, GL_NV_robustness_video_memory_purge, GL_NV_sample_locations,
        GL_NV_sample_mask_override_coverage, GL_NV_scissor_exclusive, GL_NV_shader_atomic_counters, GL_NV_shader_atomic_float,
        GL_NV_shader_atomic_float64, GL_NV_shader_atomic_fp16_vector, GL_NV_shader_atomic_int64, GL_NV_shader_buffer_load,
        GL_NV_shader_buffer_store, GL_NV_shader_storage_buffer_object, GL_NV_shader_subgroup_partitioned,
        GL_NV_shader_texture_footprint, GL_NV_shader_thread_group, GL_NV_shader_thread_shuffle, GL_NV_shading_rate_image,
        GL_NV_stereo_view_rendering, GL_NV_tessellation_program5, GL_NV_texgen_emboss, GL_NV_texgen_reflection,
        GL_NV_texture_barrier, GL_NV_texture_compression_vtc, GL_NV_texture_env_combine4, GL_NV_texture_expand_normal,
        GL_NV_texture_multisample, GL_NV_texture_rectangle, GL_NV_texture_rectangle_compressed, GL_NV_texture_shader,
        GL_NV_texture_shader2, GL_NV_texture_shader3, GL_NV_timeline_semaphore, GL_NV_transform_feedback,
        GL_NV_transform_feedback2, GL_NV_uniform_buffer_unified_memory, GL_NV_vdpau_interop, GL_NV_vdpau_interop2,
        GL_NV_vertex_array_range, GL_NV_vertex_array_range2, GL_NV_vertex_attrib_integer_64bit, GL_NV_vertex_buffer_unified_memory,
        GL_NV_vertex_program, GL_NV_vertex_program1_1, GL_NV_vertex_program2, GL_NV_vertex_program2_option, GL_NV_vertex_program3,
        GL_NV_vertex_program4, GL_NV_video_capture, GL_NV_viewport_array2, GL_NV_viewport_swizzle, GL_OES_byte_coordinates,
        GL_OES_compressed_paletted_texture, GL_OES_fixed_point, GL_OES_query_matrix, GL_OES_read_format, GL_OES_single_precision,
        GL_OML_interlace, GL_OML_resample, GL_OML_subsample, GL_OVR_multiview, GL_OVR_multiview2, GL_PGI_misc_hints,
        GL_PGI_vertex_hints, GL_REND_screen_coordinates, GL_S3_s3tc, GL_SGIS_detail_texture, GL_SGIS_fog_function,
        GL_SGIS_generate_mipmap, GL_SGIS_multisample, GL_SGIS_pixel_texture, GL_SGIS_point_line_texgen, GL_SGIS_point_parameters,
        GL_SGIS_sharpen_texture, GL_SGIS_texture4D, GL_SGIS_texture_border_clamp, GL_SGIS_texture_color_mask,
        GL_SGIS_texture_edge_clamp, GL_SGIS_texture_filter4, GL_SGIS_texture_lod, GL_SGIS_texture_select, GL_SGIX_async,
        GL_SGIX_async_histogram, GL_SGIX_async_pixel, GL_SGIX_blend_alpha_minmax, GL_SGIX_calligraphic_fragment, GL_SGIX_clipmap,
        GL_SGIX_convolution_accuracy, GL_SGIX_depth_pass_instrument, GL_SGIX_depth_texture, GL_SGIX_flush_raster,
        GL_SGIX_fog_offset, GL_SGIX_fragment_lighting, GL_SGIX_framezoom, GL_SGIX_igloo_interface, GL_SGIX_instruments,
        GL_SGIX_interlace, GL_SGIX_ir_instrument1, GL_SGIX_list_priority, GL_SGIX_pixel_texture, GL_SGIX_pixel_tiles,
        GL_SGIX_polynomial_ffd, GL_SGIX_reference_plane, GL_SGIX_resample, GL_SGIX_scalebias_hint, GL_SGIX_shadow,
        GL_SGIX_shadow_ambient, GL_SGIX_sprite, GL_SGIX_subsample, GL_SGIX_tag_sample_buffer, GL_SGIX_texture_add_env,
        GL_SGIX_texture_coordinate_clamp, GL_SGIX_texture_lod_bias, GL_SGIX_texture_multi_buffer, GL_SGIX_texture_scale_bias,
        GL_SGIX_vertex_preclip, GL_SGIX_ycrcb, GL_SGIX_ycrcb_subsample, GL_SGIX_ycrcba, GL_SGI_color_matrix, GL_SGI_color_table,
        GL_SGI_texture_color_table, GL_SUNX_constant_data, GL_SUN_convolution_border_modes, GL_SUN_global_alpha, GL_SUN_mesh_array,
        GL_SUN_slice_accum, GL_SUN_triangle_list, GL_SUN_vertex, GL_WIN_phong_shading, GL_WIN_specular_fog;

    private static boolean getExtensions(MemorySession session,
                                         int version,
                                         MemorySegment outExts,
                                         MemorySegment outNumExtsI,
                                         MemorySegment[] outExtsI) {
        if (GLCaps.versionMajor(version) < 3) {
            if (GL10C.glGetString == null) {
                return false;
            }
            outExts.set(ADDRESS, 0, GL10C.ngetString(GLConstC.GL_EXTENSIONS));
        } else {
            if (GL30C.glGetStringi == null || GL10C.glGetIntegerv == null) {
                return false;
            }
            int numExtsI = GL10C.getInteger(GLConstC.GL_NUM_EXTENSIONS);
            Addressable extsI = MemoryAddress.NULL;
            if (numExtsI > 0) {
                extsI = session.allocateArray(ADDRESS, numExtsI);
            }
            if (extsI == MemoryAddress.NULL) {
                return false;
            }
            for (int index = 0; index < numExtsI; index++) {
                var glStrTmp = GL30C.getStringi(GLConstC.GL_EXTENSIONS, index);
                ((MemorySegment) extsI).setAtIndex(ADDRESS, index, session.allocateUtf8String(glStrTmp));
            }
            outNumExtsI.set(JAVA_INT, 0, numExtsI);
            outExtsI[0] = (MemorySegment) extsI;
        }

        return true;
    }

    private static boolean hasExtension(int version, String exts, int numExtsI, String[] extsI, String ext) {
        if (GLCaps.versionMajor(version) < 3) {
            if (exts == null || ext == null) {
                return false;
            }
            return exts.contains(ext);
        } else {
            for (int index = 0; index < numExtsI; index++) {
                if (extsI[index].equals(ext)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean findExtensionsGL(int version, MemorySession session) {
        var pExts = session.allocate(ADDRESS);
        var pNumExtsI = session.allocate(JAVA_INT);
        var pExtsI = new MemorySegment[1];
        if (!getExtensions(session, version, pExts, pNumExtsI, pExtsI)) return false;

        String exts = pExts.getUtf8String(0);
        int numExtsI = pNumExtsI.get(JAVA_INT, 0);
        String[] extsI = new String[numExtsI];
        var arr = pExtsI[0];
        for (int i = 0; i < numExtsI; i++) {
            extsI[i] = arr.getAtIndex(ADDRESS, i).getUtf8String(0);
        }

        GL_3DFX_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_3DFX_multisample");
        GL_3DFX_tbuffer = hasExtension(version, exts, numExtsI, extsI, "GL_3DFX_tbuffer");
        GL_3DFX_texture_compression_FXT1 = hasExtension(version, exts, numExtsI, extsI, "GL_3DFX_texture_compression_FXT1");
        GL_AMD_blend_minmax_factor = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_blend_minmax_factor");
        GL_AMD_conservative_depth = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_conservative_depth");
        GL_AMD_debug_output = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_debug_output");
        GL_AMD_depth_clamp_separate = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_depth_clamp_separate");
        GL_AMD_draw_buffers_blend = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_draw_buffers_blend");
        GL_AMD_framebuffer_multisample_advanced = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_framebuffer_multisample_advanced");
        GL_AMD_framebuffer_sample_positions = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_framebuffer_sample_positions");
        GL_AMD_gcn_shader = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_gcn_shader");
        GL_AMD_gpu_shader_half_float = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_gpu_shader_half_float");
        GL_AMD_gpu_shader_int16 = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_gpu_shader_int16");
        GL_AMD_gpu_shader_int64 = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_gpu_shader_int64");
        GL_AMD_interleaved_elements = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_interleaved_elements");
        GL_AMD_multi_draw_indirect = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_multi_draw_indirect");
        GL_AMD_name_gen_delete = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_name_gen_delete");
        GL_AMD_occlusion_query_event = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_occlusion_query_event");
        GL_AMD_performance_monitor = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_performance_monitor");
        GL_AMD_pinned_memory = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_pinned_memory");
        GL_AMD_query_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_query_buffer_object");
        GL_AMD_sample_positions = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_sample_positions");
        GL_AMD_seamless_cubemap_per_texture = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_seamless_cubemap_per_texture");
        GL_AMD_shader_atomic_counter_ops = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_atomic_counter_ops");
        GL_AMD_shader_ballot = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_ballot");
        GL_AMD_shader_explicit_vertex_parameter = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_explicit_vertex_parameter");
        GL_AMD_shader_gpu_shader_half_float_fetch = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_gpu_shader_half_float_fetch");
        GL_AMD_shader_image_load_store_lod = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_image_load_store_lod");
        GL_AMD_shader_stencil_export = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_stencil_export");
        GL_AMD_shader_trinary_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_trinary_minmax");
        GL_AMD_sparse_texture = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_sparse_texture");
        GL_AMD_stencil_operation_extended = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_stencil_operation_extended");
        GL_AMD_texture_gather_bias_lod = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_texture_gather_bias_lod");
        GL_AMD_texture_texture4 = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_texture_texture4");
        GL_AMD_transform_feedback3_lines_triangles = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_transform_feedback3_lines_triangles");
        GL_AMD_transform_feedback4 = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_transform_feedback4");
        GL_AMD_vertex_shader_layer = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_vertex_shader_layer");
        GL_AMD_vertex_shader_tessellator = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_vertex_shader_tessellator");
        GL_AMD_vertex_shader_viewport_index = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_vertex_shader_viewport_index");
        GL_APPLE_aux_depth_stencil = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_aux_depth_stencil");
        GL_APPLE_client_storage = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_client_storage");
        GL_APPLE_element_array = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_element_array");
        GL_APPLE_fence = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_fence");
        GL_APPLE_float_pixels = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_float_pixels");
        GL_APPLE_flush_buffer_range = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_flush_buffer_range");
        GL_APPLE_object_purgeable = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_object_purgeable");
        GL_APPLE_rgb_422 = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_rgb_422");
        GL_APPLE_row_bytes = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_row_bytes");
        GL_APPLE_specular_vector = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_specular_vector");
        GL_APPLE_texture_range = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_texture_range");
        GL_APPLE_transform_hint = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_transform_hint");
        GL_APPLE_vertex_array_object = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_vertex_array_object");
        GL_APPLE_vertex_array_range = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_vertex_array_range");
        GL_APPLE_vertex_program_evaluators = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_vertex_program_evaluators");
        GL_APPLE_ycbcr_422 = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_ycbcr_422");
        GL_ARB_ES2_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_ES2_compatibility");
        GL_ARB_ES3_1_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_ES3_1_compatibility");
        GL_ARB_ES3_2_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_ES3_2_compatibility");
        GL_ARB_ES3_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_ES3_compatibility");
        GL_ARB_arrays_of_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_arrays_of_arrays");
        GL_ARB_base_instance = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_base_instance");
        GL_ARB_bindless_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_bindless_texture");
        GL_ARB_blend_func_extended = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_blend_func_extended");
        GL_ARB_buffer_storage = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_buffer_storage");
        GL_ARB_cl_event = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_cl_event");
        GL_ARB_clear_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_clear_buffer_object");
        GL_ARB_clear_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_clear_texture");
        GL_ARB_clip_control = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_clip_control");
        GL_ARB_color_buffer_float = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_color_buffer_float");
        GL_ARB_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_compatibility");
        GL_ARB_compressed_texture_pixel_storage = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_compressed_texture_pixel_storage");
        GL_ARB_compute_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_compute_shader");
        GL_ARB_compute_variable_group_size = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_compute_variable_group_size");
        GL_ARB_conditional_render_inverted = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_conditional_render_inverted");
        GL_ARB_conservative_depth = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_conservative_depth");
        GL_ARB_copy_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_copy_buffer");
        GL_ARB_copy_image = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_copy_image");
        GL_ARB_cull_distance = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_cull_distance");
        GL_ARB_debug_output = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_debug_output");
        GL_ARB_depth_buffer_float = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_depth_buffer_float");
        GL_ARB_depth_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_depth_clamp");
        GL_ARB_depth_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_depth_texture");
        GL_ARB_derivative_control = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_derivative_control");
        GL_ARB_direct_state_access = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_direct_state_access");
        GL_ARB_draw_buffers = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_buffers");
        GL_ARB_draw_buffers_blend = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_buffers_blend");
        GL_ARB_draw_elements_base_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_elements_base_vertex");
        GL_ARB_draw_indirect = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_indirect");
        GL_ARB_draw_instanced = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_instanced");
        GL_ARB_enhanced_layouts = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_enhanced_layouts");
        GL_ARB_explicit_attrib_location = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_explicit_attrib_location");
        GL_ARB_explicit_uniform_location = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_explicit_uniform_location");
        GL_ARB_fragment_coord_conventions = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_coord_conventions");
        GL_ARB_fragment_layer_viewport = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_layer_viewport");
        GL_ARB_fragment_program = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_program");
        GL_ARB_fragment_program_shadow = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_program_shadow");
        GL_ARB_fragment_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_shader");
        GL_ARB_fragment_shader_interlock = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_shader_interlock");
        GL_ARB_framebuffer_no_attachments = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_framebuffer_no_attachments");
        GL_ARB_framebuffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_framebuffer_object");
        GL_ARB_framebuffer_sRGB = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_framebuffer_sRGB");
        GL_ARB_geometry_shader4 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_geometry_shader4");
        GL_ARB_get_program_binary = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_get_program_binary");
        GL_ARB_get_texture_sub_image = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_get_texture_sub_image");
        GL_ARB_gl_spirv = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_gl_spirv");
        GL_ARB_gpu_shader5 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_gpu_shader5");
        GL_ARB_gpu_shader_fp64 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_gpu_shader_fp64");
        GL_ARB_gpu_shader_int64 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_gpu_shader_int64");
        GL_ARB_half_float_pixel = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_half_float_pixel");
        GL_ARB_half_float_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_half_float_vertex");
        GL_ARB_imaging = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_imaging");
        GL_ARB_indirect_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_indirect_parameters");
        GL_ARB_instanced_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_instanced_arrays");
        GL_ARB_internalformat_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_internalformat_query");
        GL_ARB_internalformat_query2 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_internalformat_query2");
        GL_ARB_invalidate_subdata = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_invalidate_subdata");
        GL_ARB_map_buffer_alignment = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_map_buffer_alignment");
        GL_ARB_map_buffer_range = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_map_buffer_range");
        GL_ARB_matrix_palette = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_matrix_palette");
        GL_ARB_multi_bind = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_multi_bind");
        GL_ARB_multi_draw_indirect = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_multi_draw_indirect");
        GL_ARB_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_multisample");
        GL_ARB_multitexture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_multitexture");
        GL_ARB_occlusion_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_occlusion_query");
        GL_ARB_occlusion_query2 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_occlusion_query2");
        GL_ARB_parallel_shader_compile = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_parallel_shader_compile");
        GL_ARB_pipeline_statistics_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_pipeline_statistics_query");
        GL_ARB_pixel_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_pixel_buffer_object");
        GL_ARB_point_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_point_parameters");
        GL_ARB_point_sprite = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_point_sprite");
        GL_ARB_polygon_offset_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_polygon_offset_clamp");
        GL_ARB_post_depth_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_post_depth_coverage");
        GL_ARB_program_interface_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_program_interface_query");
        GL_ARB_provoking_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_provoking_vertex");
        GL_ARB_query_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_query_buffer_object");
        GL_ARB_robust_buffer_access_behavior = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_robust_buffer_access_behavior");
        GL_ARB_robustness = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_robustness");
        GL_ARB_robustness_isolation = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_robustness_isolation");
        GL_ARB_sample_locations = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sample_locations");
        GL_ARB_sample_shading = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sample_shading");
        GL_ARB_sampler_objects = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sampler_objects");
        GL_ARB_seamless_cube_map = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_seamless_cube_map");
        GL_ARB_seamless_cubemap_per_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_seamless_cubemap_per_texture");
        GL_ARB_separate_shader_objects = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_separate_shader_objects");
        GL_ARB_shader_atomic_counter_ops = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_atomic_counter_ops");
        GL_ARB_shader_atomic_counters = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_atomic_counters");
        GL_ARB_shader_ballot = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_ballot");
        GL_ARB_shader_bit_encoding = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_bit_encoding");
        GL_ARB_shader_clock = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_clock");
        GL_ARB_shader_draw_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_draw_parameters");
        GL_ARB_shader_group_vote = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_group_vote");
        GL_ARB_shader_image_load_store = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_image_load_store");
        GL_ARB_shader_image_size = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_image_size");
        GL_ARB_shader_objects = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_objects");
        GL_ARB_shader_precision = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_precision");
        GL_ARB_shader_stencil_export = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_stencil_export");
        GL_ARB_shader_storage_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_storage_buffer_object");
        GL_ARB_shader_subroutine = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_subroutine");
        GL_ARB_shader_texture_image_samples = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_texture_image_samples");
        GL_ARB_shader_texture_lod = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_texture_lod");
        GL_ARB_shader_viewport_layer_array = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_viewport_layer_array");
        GL_ARB_shading_language_100 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shading_language_100");
        GL_ARB_shading_language_420pack = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shading_language_420pack");
        GL_ARB_shading_language_include = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shading_language_include");
        GL_ARB_shading_language_packing = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shading_language_packing");
        GL_ARB_shadow = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shadow");
        GL_ARB_shadow_ambient = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shadow_ambient");
        GL_ARB_sparse_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sparse_buffer");
        GL_ARB_sparse_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sparse_texture");
        GL_ARB_sparse_texture2 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sparse_texture2");
        GL_ARB_sparse_texture_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sparse_texture_clamp");
        GL_ARB_spirv_extensions = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_spirv_extensions");
        GL_ARB_stencil_texturing = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_stencil_texturing");
        GL_ARB_sync = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sync");
        GL_ARB_tessellation_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_tessellation_shader");
        GL_ARB_texture_barrier = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_barrier");
        GL_ARB_texture_border_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_border_clamp");
        GL_ARB_texture_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_buffer_object");
        GL_ARB_texture_buffer_object_rgb32 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_buffer_object_rgb32");
        GL_ARB_texture_buffer_range = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_buffer_range");
        GL_ARB_texture_compression = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_compression");
        GL_ARB_texture_compression_bptc = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_compression_bptc");
        GL_ARB_texture_compression_rgtc = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_compression_rgtc");
        GL_ARB_texture_cube_map = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_cube_map");
        GL_ARB_texture_cube_map_array = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_cube_map_array");
        GL_ARB_texture_env_add = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_env_add");
        GL_ARB_texture_env_combine = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_env_combine");
        GL_ARB_texture_env_crossbar = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_env_crossbar");
        GL_ARB_texture_env_dot3 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_env_dot3");
        GL_ARB_texture_filter_anisotropic = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_filter_anisotropic");
        GL_ARB_texture_filter_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_filter_minmax");
        GL_ARB_texture_float = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_float");
        GL_ARB_texture_gather = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_gather");
        GL_ARB_texture_mirror_clamp_to_edge = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_mirror_clamp_to_edge");
        GL_ARB_texture_mirrored_repeat = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_mirrored_repeat");
        GL_ARB_texture_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_multisample");
        GL_ARB_texture_non_power_of_two = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_non_power_of_two");
        GL_ARB_texture_query_levels = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_query_levels");
        GL_ARB_texture_query_lod = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_query_lod");
        GL_ARB_texture_rectangle = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_rectangle");
        GL_ARB_texture_rg = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_rg");
        GL_ARB_texture_rgb10_a2ui = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_rgb10_a2ui");
        GL_ARB_texture_stencil8 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_stencil8");
        GL_ARB_texture_storage = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_storage");
        GL_ARB_texture_storage_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_storage_multisample");
        GL_ARB_texture_swizzle = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_swizzle");
        GL_ARB_texture_view = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_view");
        GL_ARB_timer_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_timer_query");
        GL_ARB_transform_feedback2 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transform_feedback2");
        GL_ARB_transform_feedback3 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transform_feedback3");
        GL_ARB_transform_feedback_instanced = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transform_feedback_instanced");
        GL_ARB_transform_feedback_overflow_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transform_feedback_overflow_query");
        GL_ARB_transpose_matrix = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transpose_matrix");
        GL_ARB_uniform_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_uniform_buffer_object");
        GL_ARB_vertex_array_bgra = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_array_bgra");
        GL_ARB_vertex_array_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_array_object");
        GL_ARB_vertex_attrib_64bit = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_attrib_64bit");
        GL_ARB_vertex_attrib_binding = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_attrib_binding");
        GL_ARB_vertex_blend = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_blend");
        GL_ARB_vertex_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_buffer_object");
        GL_ARB_vertex_program = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_program");
        GL_ARB_vertex_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_shader");
        GL_ARB_vertex_type_10f_11f_11f_rev = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_type_10f_11f_11f_rev");
        GL_ARB_vertex_type_2_10_10_10_rev = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_type_2_10_10_10_rev");
        GL_ARB_viewport_array = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_viewport_array");
        GL_ARB_window_pos = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_window_pos");
        GL_ATI_draw_buffers = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_draw_buffers");
        GL_ATI_element_array = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_element_array");
        GL_ATI_envmap_bumpmap = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_envmap_bumpmap");
        GL_ATI_fragment_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_fragment_shader");
        GL_ATI_map_object_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_map_object_buffer");
        GL_ATI_meminfo = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_meminfo");
        GL_ATI_pixel_format_float = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_pixel_format_float");
        GL_ATI_pn_triangles = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_pn_triangles");
        GL_ATI_separate_stencil = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_separate_stencil");
        GL_ATI_text_fragment_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_text_fragment_shader");
        GL_ATI_texture_env_combine3 = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_texture_env_combine3");
        GL_ATI_texture_float = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_texture_float");
        GL_ATI_texture_mirror_once = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_texture_mirror_once");
        GL_ATI_vertex_array_object = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_vertex_array_object");
        GL_ATI_vertex_attrib_array_object = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_vertex_attrib_array_object");
        GL_ATI_vertex_streams = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_vertex_streams");
        GL_EXT_422_pixels = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_422_pixels");
        GL_EXT_EGL_image_storage = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_EGL_image_storage");
        GL_EXT_EGL_sync = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_EGL_sync");
        GL_EXT_abgr = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_abgr");
        GL_EXT_bgra = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_bgra");
        GL_EXT_bindable_uniform = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_bindable_uniform");
        GL_EXT_blend_color = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_color");
        GL_EXT_blend_equation_separate = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_equation_separate");
        GL_EXT_blend_func_separate = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_func_separate");
        GL_EXT_blend_logic_op = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_logic_op");
        GL_EXT_blend_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_minmax");
        GL_EXT_blend_subtract = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_subtract");
        GL_EXT_clip_volume_hint = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_clip_volume_hint");
        GL_EXT_cmyka = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_cmyka");
        GL_EXT_color_subtable = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_color_subtable");
        GL_EXT_compiled_vertex_array = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_compiled_vertex_array");
        GL_EXT_convolution = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_convolution");
        GL_EXT_coordinate_frame = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_coordinate_frame");
        GL_EXT_copy_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_copy_texture");
        GL_EXT_cull_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_cull_vertex");
        GL_EXT_debug_label = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_debug_label");
        GL_EXT_debug_marker = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_debug_marker");
        GL_EXT_depth_bounds_test = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_depth_bounds_test");
        GL_EXT_direct_state_access = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_direct_state_access");
        GL_EXT_draw_buffers2 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_draw_buffers2");
        GL_EXT_draw_instanced = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_draw_instanced");
        GL_EXT_draw_range_elements = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_draw_range_elements");
        GL_EXT_external_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_external_buffer");
        GL_EXT_fog_coord = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_fog_coord");
        GL_EXT_framebuffer_blit = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_blit");
        GL_EXT_framebuffer_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_multisample");
        GL_EXT_framebuffer_multisample_blit_scaled = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_multisample_blit_scaled");
        GL_EXT_framebuffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_object");
        GL_EXT_framebuffer_sRGB = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_sRGB");
        GL_EXT_geometry_shader4 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_geometry_shader4");
        GL_EXT_gpu_program_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_gpu_program_parameters");
        GL_EXT_gpu_shader4 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_gpu_shader4");
        GL_EXT_histogram = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_histogram");
        GL_EXT_index_array_formats = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_index_array_formats");
        GL_EXT_index_func = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_index_func");
        GL_EXT_index_material = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_index_material");
        GL_EXT_index_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_index_texture");
        GL_EXT_light_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_light_texture");
        GL_EXT_memory_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_memory_object");
        GL_EXT_memory_object_fd = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_memory_object_fd");
        GL_EXT_memory_object_win32 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_memory_object_win32");
        GL_EXT_misc_attribute = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_misc_attribute");
        GL_EXT_multi_draw_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multi_draw_arrays");
        GL_EXT_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multisample");
        GL_EXT_multiview_tessellation_geometry_shader = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multiview_tessellation_geometry_shader");
        GL_EXT_multiview_texture_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multiview_texture_multisample");
        GL_EXT_multiview_timer_query = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multiview_timer_query");
        GL_EXT_packed_depth_stencil = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_packed_depth_stencil");
        GL_EXT_packed_float = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_packed_float");
        GL_EXT_packed_pixels = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_packed_pixels");
        GL_EXT_paletted_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_paletted_texture");
        GL_EXT_pixel_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_pixel_buffer_object");
        GL_EXT_pixel_transform = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_pixel_transform");
        GL_EXT_pixel_transform_color_table = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_pixel_transform_color_table");
        GL_EXT_point_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_point_parameters");
        GL_EXT_polygon_offset = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_polygon_offset");
        GL_EXT_polygon_offset_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_polygon_offset_clamp");
        GL_EXT_post_depth_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_post_depth_coverage");
        GL_EXT_provoking_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_provoking_vertex");
        GL_EXT_raster_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_raster_multisample");
        GL_EXT_rescale_normal = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_rescale_normal");
        GL_EXT_secondary_color = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_secondary_color");
        GL_EXT_semaphore = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_semaphore");
        GL_EXT_semaphore_fd = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_semaphore_fd");
        GL_EXT_semaphore_win32 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_semaphore_win32");
        GL_EXT_separate_shader_objects = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_separate_shader_objects");
        GL_EXT_separate_specular_color = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_separate_specular_color");
        GL_EXT_shader_framebuffer_fetch = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_framebuffer_fetch");
        GL_EXT_shader_framebuffer_fetch_non_coherent = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_framebuffer_fetch_non_coherent");
        GL_EXT_shader_image_load_formatted = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_image_load_formatted");
        GL_EXT_shader_image_load_store = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_image_load_store");
        GL_EXT_shader_integer_mix = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_integer_mix");
        GL_EXT_shadow_funcs = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shadow_funcs");
        GL_EXT_shared_texture_palette = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shared_texture_palette");
        GL_EXT_sparse_texture2 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_sparse_texture2");
        GL_EXT_stencil_clear_tag = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_stencil_clear_tag");
        GL_EXT_stencil_two_side = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_stencil_two_side");
        GL_EXT_stencil_wrap = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_stencil_wrap");
        GL_EXT_subtexture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_subtexture");
        GL_EXT_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture");
        GL_EXT_texture3D = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture3D");
        GL_EXT_texture_array = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_array");
        GL_EXT_texture_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_buffer_object");
        GL_EXT_texture_compression_latc = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_compression_latc");
        GL_EXT_texture_compression_rgtc = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_compression_rgtc");
        GL_EXT_texture_compression_s3tc = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_compression_s3tc");
        GL_EXT_texture_cube_map = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_cube_map");
        GL_EXT_texture_env_add = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_env_add");
        GL_EXT_texture_env_combine = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_env_combine");
        GL_EXT_texture_env_dot3 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_env_dot3");
        GL_EXT_texture_filter_anisotropic = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_filter_anisotropic");
        GL_EXT_texture_filter_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_filter_minmax");
        GL_EXT_texture_integer = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_integer");
        GL_EXT_texture_lod_bias = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_lod_bias");
        GL_EXT_texture_mirror_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_mirror_clamp");
        GL_EXT_texture_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_object");
        GL_EXT_texture_perturb_normal = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_perturb_normal");
        GL_EXT_texture_sRGB = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_sRGB");
        GL_EXT_texture_sRGB_R8 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_sRGB_R8");
        GL_EXT_texture_sRGB_RG8 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_sRGB_RG8");
        GL_EXT_texture_sRGB_decode = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_sRGB_decode");
        GL_EXT_texture_shadow_lod = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_shadow_lod");
        GL_EXT_texture_shared_exponent = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_shared_exponent");
        GL_EXT_texture_snorm = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_snorm");
        GL_EXT_texture_storage = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_storage");
        GL_EXT_texture_swizzle = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_swizzle");
        GL_EXT_timer_query = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_timer_query");
        GL_EXT_transform_feedback = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_transform_feedback");
        GL_EXT_vertex_array = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_array");
        GL_EXT_vertex_array_bgra = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_array_bgra");
        GL_EXT_vertex_attrib_64bit = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_attrib_64bit");
        GL_EXT_vertex_shader = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_shader");
        GL_EXT_vertex_weighting = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_weighting");
        GL_EXT_win32_keyed_mutex = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_win32_keyed_mutex");
        GL_EXT_window_rectangles = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_window_rectangles");
        GL_EXT_x11_sync_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_x11_sync_object");
        GL_GREMEDY_frame_terminator = hasExtension(version, exts, numExtsI, extsI, "GL_GREMEDY_frame_terminator");
        GL_GREMEDY_string_marker = hasExtension(version, exts, numExtsI, extsI, "GL_GREMEDY_string_marker");
        GL_HP_convolution_border_modes = hasExtension(version, exts, numExtsI, extsI, "GL_HP_convolution_border_modes");
        GL_HP_image_transform = hasExtension(version, exts, numExtsI, extsI, "GL_HP_image_transform");
        GL_HP_occlusion_test = hasExtension(version, exts, numExtsI, extsI, "GL_HP_occlusion_test");
        GL_HP_texture_lighting = hasExtension(version, exts, numExtsI, extsI, "GL_HP_texture_lighting");
        GL_IBM_cull_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_cull_vertex");
        GL_IBM_multimode_draw_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_multimode_draw_arrays");
        GL_IBM_rasterpos_clip = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_rasterpos_clip");
        GL_IBM_static_data = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_static_data");
        GL_IBM_texture_mirrored_repeat = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_texture_mirrored_repeat");
        GL_IBM_vertex_array_lists = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_vertex_array_lists");
        GL_INGR_blend_func_separate = hasExtension(version, exts, numExtsI, extsI, "GL_INGR_blend_func_separate");
        GL_INGR_color_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_INGR_color_clamp");
        GL_INGR_interlace_read = hasExtension(version, exts, numExtsI, extsI, "GL_INGR_interlace_read");
        GL_INTEL_blackhole_render = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_blackhole_render");
        GL_INTEL_conservative_rasterization = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_conservative_rasterization");
        GL_INTEL_fragment_shader_ordering = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_fragment_shader_ordering");
        GL_INTEL_framebuffer_CMAA = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_framebuffer_CMAA");
        GL_INTEL_map_texture = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_map_texture");
        GL_INTEL_parallel_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_parallel_arrays");
        GL_INTEL_performance_query = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_performance_query");
        GL_KHR_blend_equation_advanced = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_blend_equation_advanced");
        GL_KHR_blend_equation_advanced_coherent = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_blend_equation_advanced_coherent");
        GL_KHR_context_flush_control = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_context_flush_control");
        GL_KHR_debug = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_debug");
        GL_KHR_no_error = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_no_error");
        GL_KHR_parallel_shader_compile = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_parallel_shader_compile");
        GL_KHR_robust_buffer_access_behavior = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_robust_buffer_access_behavior");
        GL_KHR_robustness = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_robustness");
        GL_KHR_shader_subgroup = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_shader_subgroup");
        GL_KHR_texture_compression_astc_hdr = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_texture_compression_astc_hdr");
        GL_KHR_texture_compression_astc_ldr = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_texture_compression_astc_ldr");
        GL_KHR_texture_compression_astc_sliced_3d = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_texture_compression_astc_sliced_3d");
        GL_MESAX_texture_stack = hasExtension(version, exts, numExtsI, extsI, "GL_MESAX_texture_stack");
        GL_MESA_framebuffer_flip_x = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_framebuffer_flip_x");
        GL_MESA_framebuffer_flip_y = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_framebuffer_flip_y");
        GL_MESA_framebuffer_swap_xy = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_framebuffer_swap_xy");
        GL_MESA_pack_invert = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_pack_invert");
        GL_MESA_program_binary_formats = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_program_binary_formats");
        GL_MESA_resize_buffers = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_resize_buffers");
        GL_MESA_shader_integer_functions = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_shader_integer_functions");
        GL_MESA_tile_raster_order = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_tile_raster_order");
        GL_MESA_window_pos = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_window_pos");
        GL_MESA_ycbcr_texture = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_ycbcr_texture");
        GL_NVX_blend_equation_advanced_multi_draw_buffers = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_blend_equation_advanced_multi_draw_buffers");
        GL_NVX_conditional_render = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_conditional_render");
        GL_NVX_gpu_memory_info = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_gpu_memory_info");
        GL_NVX_gpu_multicast2 = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_gpu_multicast2");
        GL_NVX_linked_gpu_multicast = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_linked_gpu_multicast");
        GL_NVX_progress_fence = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_progress_fence");
        GL_NV_alpha_to_coverage_dither_control = hasExtension(version, exts, numExtsI, extsI, "GL_NV_alpha_to_coverage_dither_control");
        GL_NV_bindless_multi_draw_indirect = hasExtension(version, exts, numExtsI, extsI, "GL_NV_bindless_multi_draw_indirect");
        GL_NV_bindless_multi_draw_indirect_count = hasExtension(version, exts, numExtsI, extsI, "GL_NV_bindless_multi_draw_indirect_count");
        GL_NV_bindless_texture = hasExtension(version, exts, numExtsI, extsI, "GL_NV_bindless_texture");
        GL_NV_blend_equation_advanced = hasExtension(version, exts, numExtsI, extsI, "GL_NV_blend_equation_advanced");
        GL_NV_blend_equation_advanced_coherent = hasExtension(version, exts, numExtsI, extsI, "GL_NV_blend_equation_advanced_coherent");
        GL_NV_blend_minmax_factor = hasExtension(version, exts, numExtsI, extsI, "GL_NV_blend_minmax_factor");
        GL_NV_blend_square = hasExtension(version, exts, numExtsI, extsI, "GL_NV_blend_square");
        GL_NV_clip_space_w_scaling = hasExtension(version, exts, numExtsI, extsI, "GL_NV_clip_space_w_scaling");
        GL_NV_command_list = hasExtension(version, exts, numExtsI, extsI, "GL_NV_command_list");
        GL_NV_compute_program5 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_compute_program5");
        GL_NV_compute_shader_derivatives = hasExtension(version, exts, numExtsI, extsI, "GL_NV_compute_shader_derivatives");
        GL_NV_conditional_render = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conditional_render");
        GL_NV_conservative_raster = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster");
        GL_NV_conservative_raster_dilate = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster_dilate");
        GL_NV_conservative_raster_pre_snap = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster_pre_snap");
        GL_NV_conservative_raster_pre_snap_triangles = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster_pre_snap_triangles");
        GL_NV_conservative_raster_underestimation = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster_underestimation");
        GL_NV_copy_depth_to_color = hasExtension(version, exts, numExtsI, extsI, "GL_NV_copy_depth_to_color");
        GL_NV_copy_image = hasExtension(version, exts, numExtsI, extsI, "GL_NV_copy_image");
        GL_NV_deep_texture3D = hasExtension(version, exts, numExtsI, extsI, "GL_NV_deep_texture3D");
        GL_NV_depth_buffer_float = hasExtension(version, exts, numExtsI, extsI, "GL_NV_depth_buffer_float");
        GL_NV_depth_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_NV_depth_clamp");
        GL_NV_draw_texture = hasExtension(version, exts, numExtsI, extsI, "GL_NV_draw_texture");
        GL_NV_draw_vulkan_image = hasExtension(version, exts, numExtsI, extsI, "GL_NV_draw_vulkan_image");
        GL_NV_evaluators = hasExtension(version, exts, numExtsI, extsI, "GL_NV_evaluators");
        GL_NV_explicit_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_NV_explicit_multisample");
        GL_NV_fence = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fence");
        GL_NV_fill_rectangle = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fill_rectangle");
        GL_NV_float_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_NV_float_buffer");
        GL_NV_fog_distance = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fog_distance");
        GL_NV_fragment_coverage_to_color = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_coverage_to_color");
        GL_NV_fragment_program = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_program");
        GL_NV_fragment_program2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_program2");
        GL_NV_fragment_program4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_program4");
        GL_NV_fragment_program_option = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_program_option");
        GL_NV_fragment_shader_barycentric = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_shader_barycentric");
        GL_NV_fragment_shader_interlock = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_shader_interlock");
        GL_NV_framebuffer_mixed_samples = hasExtension(version, exts, numExtsI, extsI, "GL_NV_framebuffer_mixed_samples");
        GL_NV_framebuffer_multisample_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_NV_framebuffer_multisample_coverage");
        GL_NV_geometry_program4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_geometry_program4");
        GL_NV_geometry_shader4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_geometry_shader4");
        GL_NV_geometry_shader_passthrough = hasExtension(version, exts, numExtsI, extsI, "GL_NV_geometry_shader_passthrough");
        GL_NV_gpu_multicast = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_multicast");
        GL_NV_gpu_program4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_program4");
        GL_NV_gpu_program5 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_program5");
        GL_NV_gpu_program5_mem_extended = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_program5_mem_extended");
        GL_NV_gpu_shader5 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_shader5");
        GL_NV_half_float = hasExtension(version, exts, numExtsI, extsI, "GL_NV_half_float");
        GL_NV_internalformat_sample_query = hasExtension(version, exts, numExtsI, extsI, "GL_NV_internalformat_sample_query");
        GL_NV_light_max_exponent = hasExtension(version, exts, numExtsI, extsI, "GL_NV_light_max_exponent");
        GL_NV_memory_attachment = hasExtension(version, exts, numExtsI, extsI, "GL_NV_memory_attachment");
        GL_NV_memory_object_sparse = hasExtension(version, exts, numExtsI, extsI, "GL_NV_memory_object_sparse");
        GL_NV_mesh_shader = hasExtension(version, exts, numExtsI, extsI, "GL_NV_mesh_shader");
        GL_NV_multisample_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_NV_multisample_coverage");
        GL_NV_multisample_filter_hint = hasExtension(version, exts, numExtsI, extsI, "GL_NV_multisample_filter_hint");
        GL_NV_occlusion_query = hasExtension(version, exts, numExtsI, extsI, "GL_NV_occlusion_query");
        GL_NV_packed_depth_stencil = hasExtension(version, exts, numExtsI, extsI, "GL_NV_packed_depth_stencil");
        GL_NV_parameter_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_NV_parameter_buffer_object");
        GL_NV_parameter_buffer_object2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_parameter_buffer_object2");
        GL_NV_path_rendering = hasExtension(version, exts, numExtsI, extsI, "GL_NV_path_rendering");
        GL_NV_path_rendering_shared_edge = hasExtension(version, exts, numExtsI, extsI, "GL_NV_path_rendering_shared_edge");
        GL_NV_pixel_data_range = hasExtension(version, exts, numExtsI, extsI, "GL_NV_pixel_data_range");
        GL_NV_point_sprite = hasExtension(version, exts, numExtsI, extsI, "GL_NV_point_sprite");
        GL_NV_present_video = hasExtension(version, exts, numExtsI, extsI, "GL_NV_present_video");
        GL_NV_primitive_restart = hasExtension(version, exts, numExtsI, extsI, "GL_NV_primitive_restart");
        GL_NV_primitive_shading_rate = hasExtension(version, exts, numExtsI, extsI, "GL_NV_primitive_shading_rate");
        GL_NV_query_resource = hasExtension(version, exts, numExtsI, extsI, "GL_NV_query_resource");
        GL_NV_query_resource_tag = hasExtension(version, exts, numExtsI, extsI, "GL_NV_query_resource_tag");
        GL_NV_register_combiners = hasExtension(version, exts, numExtsI, extsI, "GL_NV_register_combiners");
        GL_NV_register_combiners2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_register_combiners2");
        GL_NV_representative_fragment_test = hasExtension(version, exts, numExtsI, extsI, "GL_NV_representative_fragment_test");
        GL_NV_robustness_video_memory_purge = hasExtension(version, exts, numExtsI, extsI, "GL_NV_robustness_video_memory_purge");
        GL_NV_sample_locations = hasExtension(version, exts, numExtsI, extsI, "GL_NV_sample_locations");
        GL_NV_sample_mask_override_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_NV_sample_mask_override_coverage");
        GL_NV_scissor_exclusive = hasExtension(version, exts, numExtsI, extsI, "GL_NV_scissor_exclusive");
        GL_NV_shader_atomic_counters = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_counters");
        GL_NV_shader_atomic_float = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_float");
        GL_NV_shader_atomic_float64 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_float64");
        GL_NV_shader_atomic_fp16_vector = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_fp16_vector");
        GL_NV_shader_atomic_int64 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_int64");
        GL_NV_shader_buffer_load = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_buffer_load");
        GL_NV_shader_buffer_store = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_buffer_store");
        GL_NV_shader_storage_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_storage_buffer_object");
        GL_NV_shader_subgroup_partitioned = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_subgroup_partitioned");
        GL_NV_shader_texture_footprint = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_texture_footprint");
        GL_NV_shader_thread_group = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_thread_group");
        GL_NV_shader_thread_shuffle = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_thread_shuffle");
        GL_NV_shading_rate_image = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shading_rate_image");
        GL_NV_stereo_view_rendering = hasExtension(version, exts, numExtsI, extsI, "GL_NV_stereo_view_rendering");
        GL_NV_tessellation_program5 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_tessellation_program5");
        GL_NV_texgen_emboss = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texgen_emboss");
        GL_NV_texgen_reflection = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texgen_reflection");
        GL_NV_texture_barrier = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_barrier");
        GL_NV_texture_compression_vtc = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_compression_vtc");
        GL_NV_texture_env_combine4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_env_combine4");
        GL_NV_texture_expand_normal = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_expand_normal");
        GL_NV_texture_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_multisample");
        GL_NV_texture_rectangle = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_rectangle");
        GL_NV_texture_rectangle_compressed = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_rectangle_compressed");
        GL_NV_texture_shader = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_shader");
        GL_NV_texture_shader2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_shader2");
        GL_NV_texture_shader3 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_shader3");
        GL_NV_timeline_semaphore = hasExtension(version, exts, numExtsI, extsI, "GL_NV_timeline_semaphore");
        GL_NV_transform_feedback = hasExtension(version, exts, numExtsI, extsI, "GL_NV_transform_feedback");
        GL_NV_transform_feedback2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_transform_feedback2");
        GL_NV_uniform_buffer_unified_memory = hasExtension(version, exts, numExtsI, extsI, "GL_NV_uniform_buffer_unified_memory");
        GL_NV_vdpau_interop = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vdpau_interop");
        GL_NV_vdpau_interop2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vdpau_interop2");
        GL_NV_vertex_array_range = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_array_range");
        GL_NV_vertex_array_range2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_array_range2");
        GL_NV_vertex_attrib_integer_64bit = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_attrib_integer_64bit");
        GL_NV_vertex_buffer_unified_memory = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_buffer_unified_memory");
        GL_NV_vertex_program = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program");
        GL_NV_vertex_program1_1 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program1_1");
        GL_NV_vertex_program2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program2");
        GL_NV_vertex_program2_option = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program2_option");
        GL_NV_vertex_program3 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program3");
        GL_NV_vertex_program4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program4");
        GL_NV_video_capture = hasExtension(version, exts, numExtsI, extsI, "GL_NV_video_capture");
        GL_NV_viewport_array2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_viewport_array2");
        GL_NV_viewport_swizzle = hasExtension(version, exts, numExtsI, extsI, "GL_NV_viewport_swizzle");
        GL_OES_byte_coordinates = hasExtension(version, exts, numExtsI, extsI, "GL_OES_byte_coordinates");
        GL_OES_compressed_paletted_texture = hasExtension(version, exts, numExtsI, extsI, "GL_OES_compressed_paletted_texture");
        GL_OES_fixed_point = hasExtension(version, exts, numExtsI, extsI, "GL_OES_fixed_point");
        GL_OES_query_matrix = hasExtension(version, exts, numExtsI, extsI, "GL_OES_query_matrix");
        GL_OES_read_format = hasExtension(version, exts, numExtsI, extsI, "GL_OES_read_format");
        GL_OES_single_precision = hasExtension(version, exts, numExtsI, extsI, "GL_OES_single_precision");
        GL_OML_interlace = hasExtension(version, exts, numExtsI, extsI, "GL_OML_interlace");
        GL_OML_resample = hasExtension(version, exts, numExtsI, extsI, "GL_OML_resample");
        GL_OML_subsample = hasExtension(version, exts, numExtsI, extsI, "GL_OML_subsample");
        GL_OVR_multiview = hasExtension(version, exts, numExtsI, extsI, "GL_OVR_multiview");
        GL_OVR_multiview2 = hasExtension(version, exts, numExtsI, extsI, "GL_OVR_multiview2");
        GL_PGI_misc_hints = hasExtension(version, exts, numExtsI, extsI, "GL_PGI_misc_hints");
        GL_PGI_vertex_hints = hasExtension(version, exts, numExtsI, extsI, "GL_PGI_vertex_hints");
        GL_REND_screen_coordinates = hasExtension(version, exts, numExtsI, extsI, "GL_REND_screen_coordinates");
        GL_S3_s3tc = hasExtension(version, exts, numExtsI, extsI, "GL_S3_s3tc");
        GL_SGIS_detail_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_detail_texture");
        GL_SGIS_fog_function = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_fog_function");
        GL_SGIS_generate_mipmap = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_generate_mipmap");
        GL_SGIS_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_multisample");
        GL_SGIS_pixel_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_pixel_texture");
        GL_SGIS_point_line_texgen = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_point_line_texgen");
        GL_SGIS_point_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_point_parameters");
        GL_SGIS_sharpen_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_sharpen_texture");
        GL_SGIS_texture4D = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture4D");
        GL_SGIS_texture_border_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_border_clamp");
        GL_SGIS_texture_color_mask = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_color_mask");
        GL_SGIS_texture_edge_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_edge_clamp");
        GL_SGIS_texture_filter4 = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_filter4");
        GL_SGIS_texture_lod = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_lod");
        GL_SGIS_texture_select = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_select");
        GL_SGIX_async = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_async");
        GL_SGIX_async_histogram = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_async_histogram");
        GL_SGIX_async_pixel = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_async_pixel");
        GL_SGIX_blend_alpha_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_blend_alpha_minmax");
        GL_SGIX_calligraphic_fragment = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_calligraphic_fragment");
        GL_SGIX_clipmap = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_clipmap");
        GL_SGIX_convolution_accuracy = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_convolution_accuracy");
        GL_SGIX_depth_pass_instrument = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_depth_pass_instrument");
        GL_SGIX_depth_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_depth_texture");
        GL_SGIX_flush_raster = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_flush_raster");
        GL_SGIX_fog_offset = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_fog_offset");
        GL_SGIX_fragment_lighting = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_fragment_lighting");
        GL_SGIX_framezoom = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_framezoom");
        GL_SGIX_igloo_interface = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_igloo_interface");
        GL_SGIX_instruments = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_instruments");
        GL_SGIX_interlace = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_interlace");
        GL_SGIX_ir_instrument1 = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_ir_instrument1");
        GL_SGIX_list_priority = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_list_priority");
        GL_SGIX_pixel_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_pixel_texture");
        GL_SGIX_pixel_tiles = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_pixel_tiles");
        GL_SGIX_polynomial_ffd = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_polynomial_ffd");
        GL_SGIX_reference_plane = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_reference_plane");
        GL_SGIX_resample = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_resample");
        GL_SGIX_scalebias_hint = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_scalebias_hint");
        GL_SGIX_shadow = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_shadow");
        GL_SGIX_shadow_ambient = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_shadow_ambient");
        GL_SGIX_sprite = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_sprite");
        GL_SGIX_subsample = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_subsample");
        GL_SGIX_tag_sample_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_tag_sample_buffer");
        GL_SGIX_texture_add_env = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_add_env");
        GL_SGIX_texture_coordinate_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_coordinate_clamp");
        GL_SGIX_texture_lod_bias = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_lod_bias");
        GL_SGIX_texture_multi_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_multi_buffer");
        GL_SGIX_texture_scale_bias = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_scale_bias");
        GL_SGIX_vertex_preclip = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_vertex_preclip");
        GL_SGIX_ycrcb = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_ycrcb");
        GL_SGIX_ycrcb_subsample = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_ycrcb_subsample");
        GL_SGIX_ycrcba = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_ycrcba");
        GL_SGI_color_matrix = hasExtension(version, exts, numExtsI, extsI, "GL_SGI_color_matrix");
        GL_SGI_color_table = hasExtension(version, exts, numExtsI, extsI, "GL_SGI_color_table");
        GL_SGI_texture_color_table = hasExtension(version, exts, numExtsI, extsI, "GL_SGI_texture_color_table");
        GL_SUNX_constant_data = hasExtension(version, exts, numExtsI, extsI, "GL_SUNX_constant_data");
        GL_SUN_convolution_border_modes = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_convolution_border_modes");
        GL_SUN_global_alpha = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_global_alpha");
        GL_SUN_mesh_array = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_mesh_array");
        GL_SUN_slice_accum = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_slice_accum");
        GL_SUN_triangle_list = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_triangle_list");
        GL_SUN_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_vertex");
        GL_WIN_phong_shading = hasExtension(version, exts, numExtsI, extsI, "GL_WIN_phong_shading");
        GL_WIN_specular_fog = hasExtension(version, exts, numExtsI, extsI, "GL_WIN_specular_fog");

        return true;
    }

    static void load(GLLoadFunc load) {
        // TODO: 8/307 extensions
        GL3DFXTbuffer.load(load);
        GLAMDDebugOutput.load(load);
        GLAMDDrawBuffersBlend.load(load);
        GLAMDFramebufferMultisampleAdvanced.load(load);
        GLAMDFramebufferSamplePositions.load(load);
        // TODO: GLAMDGpuShaderInt64.load(load);
        GLAMDInterleavedElements.load(load);
        GLAMDMultiDrawIndirect.load(load);
        GLAMDNameGenDelete.load(load);
    }
}
