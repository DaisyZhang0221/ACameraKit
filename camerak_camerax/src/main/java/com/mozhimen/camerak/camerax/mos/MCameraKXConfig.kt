package com.mozhimen.componentk.camerak.camerax.mos

import com.mozhimen.camerak.camerax.annors.ACameraKXCaptureMode
import com.mozhimen.camerak.camerax.annors.ACameraKXFacing
import com.mozhimen.camerak.camerax.annors.ACameraKXFormat
import com.mozhimen.camerak.camerax.annors.ACameraKXRotation

/**
 * @ClassName CameraXKConfig
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/12/15 11:28
 * @Version 1.0
 */
data class MCameraKXConfig(
    @ACameraKXFormat val format: Int = ACameraKXFormat.YUV_420_888,
    @ACameraKXFacing val facing: Int = ACameraKXFacing.BACK,
    @ACameraKXRotation val rotation: Int = ACameraKXRotation.ROTATION_90,
    @ACameraKXCaptureMode val captureMode: Int = ACameraKXCaptureMode.MAXIMIZE_QUALITY
)