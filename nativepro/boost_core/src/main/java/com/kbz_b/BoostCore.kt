package com.kbz_b

import android.app.Application
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.kbz_b.flutter.MyFlutterBoostDelegate
import io.flutter.FlutterInjector


object BoostCore {

    private var initTag: Boolean = false

    const val ROUTE_KEY = "flutterRoute"
    const val ROUTE_PARAMS = "flutterParams"


    /**
     * 初始化FlutterBoost，
     * 需要在这里注册 Native路由
     */
    fun init(app: Application) {
        if (initTag) {
            return
        }

        initTag = true

        FlutterInjector.instance().flutterLoader().startInitialization(app)

        FlutterBoost.instance().setup(app, MyFlutterBoostDelegate()) {
        }
    }

    /**
     * 跳转到Flutter页面
     *
     * @param pageName
     * @param requestCode
     * @param arguments
     */
    fun openFlutterPage(pageName: String, requestCode: Int, arguments: Map<String, Any?>) {
        val options = FlutterBoostRouteOptions.Builder()
            .pageName(pageName)
            .arguments(arguments)
            .requestCode(requestCode)
            .build()
        FlutterBoost.instance().open(options)
    }

    /**
     * 根据唯一标志关闭页面
     */
    fun closeFlutterPage(uniqueId: String) {
        FlutterBoost.instance().close(uniqueId);
    }
}