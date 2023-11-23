package com.example.slidepuzzle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;



public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        ImageButton Challenge = findViewById(R.id.btn_challengeMode);
        ImageButton Free = findViewById(R.id.btn_freeMode);

        Challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다른 액티비티로 이동하는 인텐트 생성
                Intent intent = new Intent(StartScreen.this, ChallengeModeScreen.class);

                // 다른 액티비티로 이동
                startActivity(intent);
            }

        });
        Free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다른 액티비티로 이동하는 인텐트 생성
                Intent intent = new Intent(StartScreen.this, FreeModeScreen.class);

                // 다른 액티비티로 이동
                startActivity(intent);
            }


    });
}
}