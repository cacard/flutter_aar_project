package com.lcq.android_app;

import android.app.Application;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class App extends Application {

    public FlutterEngine flutterEngine;
    public static String ENGINE_ID = "my_engine";

    @Override
    public void onCreate() {
        super.onCreate();


    }

    public void startFlutterEngineCache() {
        // Cache flutter engine
        flutterEngine = new FlutterEngine(this);

        flutterEngine.getNavigationChannel().setInitialRoute("/");

        // pre-warm
        flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());

        // cache
        FlutterEngineCache.getInstance().put(ENGINE_ID, flutterEngine);
    }
}
