import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_module/boost_core.dart';


Future<void> main() async {
  BoostCore.init();

  // 实际上这里就是在启动引擎
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      builder: (context, child) {
        return MediaQuery(
            data: MediaQuery.of(context).copyWith(textScaleFactor: 1.0),
            child: child!);
      },
      home: FlutterBoostApp(BoostCore.routeFactory, interceptors: [
        CustomInterceptor1()
      ]),
    );
  }
}
