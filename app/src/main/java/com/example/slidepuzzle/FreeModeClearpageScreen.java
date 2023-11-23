package com.example.slidepuzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FreeModeClearpageScreen extends AppCompatActivity {
    ImageView imgv;
    ImageButton btnhome;
    TextView timev,movev;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_clearpage_screen);
        imgv =(ImageView)findViewById(R.id.selected_img_free_mode);
        btnhome =(ImageButton)findViewById(R.id.btn_home);
        timev =(TextView) findViewById(R.id.Time);
        movev = (TextView) findViewById(R.id.Moves);

        Intent intent = getIntent();
        int time = intent.getIntExtra("time",0);  //시간
        int imgId = intent.getIntExtra("selected_image",0); //이미지
        int moveCount = intent.getIntExtra("move_count",0); //이동 횟수

        imgv.setImageResource(imgId);
        timev.setText(String.valueOf(time));
        movev.setText(String.valueOf(moveCount));


        //home 버튼 구현
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnHome.goHome(FreeModeClearpageScreen.this);
            }
        });


    }
}
