package com.lcq.android_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import io.flutter.embedding.android.FlutterActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnFlutter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testFlutterActivity();
            }
        });
    }

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // FlutterActivity

    void testFlutterActivity() {
        if (App.ENABLE_CACHE_ENGINE) {
            byCachedEngine();;
        } else {
            byNewEngine();
        }
    }

    void byNewEngine() {
        Intent intent = FlutterActivity.withNewEngine().build(MainActivity.this);
        MainActivity.this.startActivity(intent);
    }

    /**
     * Flutter开启速度明显比较快！
     */
    void byCachedEngine() {
        Intent intent = FlutterActivity.withCachedEngine(App.ENGINE_ID).build(MainActivity.this);
        MainActivity.this.startActivity(intent);
    }

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // FlutterFragment

    void testFlutterFragment() {

    }

}