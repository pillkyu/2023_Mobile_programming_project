package com.example.slidepuzzle;

import android.app.Activity;

public class BtnBack {
    public static void goBack(Activity activity){
        if (activity != null) {
            activity.finish();
        }
    }
}
