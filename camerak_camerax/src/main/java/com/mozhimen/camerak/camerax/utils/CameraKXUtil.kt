package com.mozhimen.camerak.camerax.utils

import android.annotation.SuppressLint
import android.util.Size
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk
import androidx.camera.camera2.interop.Camera2CameraInfo
import androidx.camera.core.AspectRatio
import androidx.camera.core.Camera
import com.mozhimen.camerak.camerax.annors.AAspectRatio
import com.mozhimen.camerak.camerax.cons.CAspectRatio
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * @ClassName CameraKXUtil
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Version 1.0
 */
object CameraKXUtil {
    /**
     *  检测当前尺寸的最合适的长宽比
     */
    @JvmStatic
    fun getFitAspectRatio(@AAspectRatio ratio: Int, width: Int, height: Int): Int {
        if (ratio == AAspectRatio.RATIO_DEFAULT) {
            val previewRatio = max(width, height).toDouble() / min(width, height)
            if (abs(previewRatio - CAspectRatio.RATIO_VAL_4_3) <= abs(previewRatio - CAspectRatio.RATIO_VAL_16_9))
                return AAspectRatio.RATIO_4_3
            return AAspectRatio.RATIO_16_9
        } else return ratio
    }

    @androidx.annotation.OptIn(androidx.camera.camera2.interop.ExperimentalCamera2Interop::class)
    @SuppressLint("RestrictedApi", "VisibleForTests")
    @JvmStatic
    fun getSupportedResolutions(camera: Camera): List<Size> {
        val characteristics = CameraCharacteristicsCompat.toCameraCharacteristicsCompat(Camera2CameraInfo.extractCameraCharacteristics(camera.cameraInfo))
        return CamcorderProfileResolutionQuirk(characteristics).supportedResolutions
    }
}