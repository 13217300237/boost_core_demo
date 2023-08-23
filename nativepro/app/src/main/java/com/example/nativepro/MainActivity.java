package com.example.nativepro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kbz_b.BoostCore;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.tv1).setOnClickListener(v -> {
            BoostCore.INSTANCE.openFlutterPage("test1", 0, new HashMap<>());
        });
        findViewById(R.id.tv2).setOnClickListener(v -> {
            BoostCore.INSTANCE.openFlutterPage("test2", 0, new HashMap<>());
        });
    }


}