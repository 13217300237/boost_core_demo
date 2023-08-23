import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Test2Widget extends StatelessWidget {
  const Test2Widget({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        color: Colors.red,
        child: const Center(child: Text("这是Flutter页面2")),
      ),
    );
  }
}
