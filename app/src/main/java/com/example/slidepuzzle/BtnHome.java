package com.example.slidepuzzle;

import android.app.Activity;
import android.content.Intent;

public class BtnHome {
    public static void goHome(Activity activity){
        if (activity != null) {
            Intent intent = new Intent(activity, StartScreen.class);
            activity.startActivity(intent);
        }
    }
}
