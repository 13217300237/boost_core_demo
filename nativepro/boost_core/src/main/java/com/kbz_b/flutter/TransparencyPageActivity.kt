package com.kbz_b.flutter

import com.idlefish.flutterboost.containers.FlutterBoostActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode

/**
 * 透明模式的FlutterActivity
 */
internal class TransparencyPageActivity : FlutterBoostActivity() {
    override fun getBackgroundMode(): BackgroundMode {
        if (super.getBackgroundMode() != BackgroundMode.transparent) {
            throw AssertionError("You *MUST* set FlutterActivity#backgroundMode correctly.")
        }
        return super.getBackgroundMode()
    }
}