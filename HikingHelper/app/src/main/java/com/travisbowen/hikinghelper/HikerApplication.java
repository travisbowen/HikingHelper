package com.travisbowen.hikinghelper;

import android.app.Application;
import com.firebase.client.Firebase;


public class HikerApplication extends Application {

    private static String firebaseRootRef = "https://fiery-inferno-9656.firebaseio.com/hikers";

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

    public static String getFirebaseRootRef() {
        return firebaseRootRef;
    }
}
