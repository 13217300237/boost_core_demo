package com.kbz_b.flutter

import android.widget.Toast
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostDelegate
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode

/**
 *
 */
internal class MyFlutterBoostDelegate : FlutterBoostDelegate {

    /**
     * 如果 flutter需要跳转到native，那么需要重写这一段
     */
    override fun pushNativeRoute(options: FlutterBoostRouteOptions) {

        // 这里需要对flutter过来的 跳转请求进行分发
        // 暂且注释掉
//        val intent = Intent(
//            FlutterBoost.instance().currentActivity(),
//            NativePageActivity::class.java
//        )
//        FlutterBoost.instance().currentActivity()
//            .startActivityForResult(intent, options.requestCode())

    }

    /**
     * native跳转到flutter页面时
     */
    override fun pushFlutterRoute(options: FlutterBoostRouteOptions) {

        val activityClass: Class<out FlutterBoostActivity?> =
            if (options.opaque())
                FlutterBoostActivity::class.java
            else
                TransparencyPageActivity::class.java


        val intent = FlutterBoostActivity.CachedEngineIntentBuilder(activityClass)
            .destroyEngineWithActivity(false)
            // 注意：这里需要回传dart带过来的uniqueId，否则页面退出时传参可能失败。
            // 但，如果是从Native打开Flutter页面，请不要给uniqueId赋*任何值*！！！
            .uniqueId(options.uniqueId())
            .backgroundMode(
                if (options.opaque()) BackgroundMode.opaque else BackgroundMode.transparent
            )
            .url(options.pageName())
            .urlParams(options.arguments())
            .build(FlutterBoost.instance().currentActivity())

        FlutterBoost.instance().currentActivity().startActivity(intent)
    }

    /**
     * 当从Flutter退回native时的处理方式
     */
    override fun popRoute(options: FlutterBoostRouteOptions): Boolean {
        //自定义popRoute处理逻辑,如果不想走默认处理逻辑返回true进行拦截
        Toast.makeText(
            FlutterBoost.instance().currentActivity().applicationContext,
            "Add customized popRoute handler here",
            Toast.LENGTH_SHORT
        ).show()
        return false
    }
}