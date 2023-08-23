import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_module/test2_widget.dart';
import 'package:flutter_module/test_widget.dart';

class BoostCore {
  static void init() {
    PageVisibilityBinding.instance
        .addGlobalObserver(AppGlobalPageVisibilityObserver());
    CustomFlutterBinding();
  }

  static Map<String, FlutterBoostRouteFactory> routerMap = {
    'test1': (RouteSettings settings, String? uniqueId) {
      return PageRouteBuilder<dynamic>(
          settings: settings,
          pageBuilder: (_, __, ___) {
            return const TestWidget();
          });
    },
    'test2': (RouteSettings settings, String? uniqueId) {
      return PageRouteBuilder<dynamic>(
          settings: settings,
          pageBuilder: (_, __, ___) {
            return const Test2Widget();
          });
    },
  };

  static Route<dynamic>? routeFactory(
      RouteSettings settings, String? uniqueId) {
    FlutterBoostRouteFactory? func = routerMap[settings.name!];
    if (func == null) {
      return PageRouteBuilder<dynamic>(
          settings: settings,
          pageBuilder: (_, __, ___) {
            return const TestWidget();
          });
    }
    return func(settings, uniqueId);
  }
}

class CustomFlutterBinding extends WidgetsFlutterBinding
    with BoostFlutterBinding {}

class AppGlobalPageVisibilityObserver extends GlobalPageVisibilityObserver {
  @override
  void onPagePush(Route<dynamic> route) {
    Logger.log(
        'boost_lifecycle: AppGlobalPageVisibilityObserver.onPageCreate route:${route.settings.name}');
  }

  @override
  void onPageShow(Route<dynamic> route) {
    Logger.log(
        'boost_lifecycle: AppGlobalPageVisibilityObserver.onPageShow route:${route.settings.name}');
  }

  @override
  void onPageHide(Route<dynamic> route) {
    Logger.log(
        'boost_lifecycle: AppGlobalPageVisibilityObserver.onPageHide route:${route.settings.name}');
  }

  @override
  void onPagePop(Route<dynamic> route) {
    Logger.log(
        'boost_lifecycle: AppGlobalPageVisibilityObserver.onPageDestroy route:${route.settings.name}');
  }

  @override
  void onForeground(Route route) {
    Logger.log(
        'boost_lifecycle: AppGlobalPageVisibilityObserver.onForeground route:${route.settings.name}');
  }

  @override
  void onBackground(Route<dynamic> route) {
    Logger.log(
        'boost_lifecycle: AppGlobalPageVisibilityObserver.onBackground route:${route.settings.name}');
  }
}

class CustomInterceptor1 extends BoostInterceptor {
  @override
  void onPrePush(
      BoostInterceptorOption option, PushInterceptorHandler handler) {
    Logger.log('CustomInterceptor#onPrePush1~~~, $option');
    // Add extra arguments
    option.arguments!['CustomInterceptor1'] = "拦截测试参数";
    super.onPrePush(option, handler);
  }

  @override
  void onPostPush(
      BoostInterceptorOption option, PushInterceptorHandler handler) {
    Logger.log('CustomInterceptor#onPostPush1~~~, $option');
    handler.next(option);
  }
}
