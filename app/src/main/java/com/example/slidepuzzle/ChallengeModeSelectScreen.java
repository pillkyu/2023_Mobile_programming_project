package com.example.slidepuzzle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ChallengeModeSelectScreen extends AppCompatActivity {
    private int selectedImageResource; // URI를 저장할 변수 선언
    private int selected_num;
    private Uri selectedImageUri;
    StartScreen.myDBHelper myHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        myHelper = new StartScreen.myDBHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_mode_select_screen);


        selectedImageResource = getIntent().getIntExtra("Resource_Id", 0);
        selectedImageUri = Uri.parse("android.resource://" + getPackageName() + "/" + selectedImageResource);



        ImageView imageView = findViewById(R.id.free_mode_play_placehold);
        imageView.setImageURI(selectedImageUri);

        //nBy n button 구현
        RadioButton btn3by3 = findViewById(R.id.btn_3by3);
        RadioButton btn4by4 = findViewById(R.id.btn_4by4);
        RadioButton btn5by5 = findViewById(R.id.btn_5by5);
        ImageButton btnstart = findViewById(R.id.btn_game_start);

        btn3by3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3x3 버튼을 클릭했을 때 수행할 작업
                selected_num = 3; // 선택한 그리드 크기에 해당하는 값

            }
        });
        btn4by4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3x3 버튼을 클릭했을 때 수행할 작업
                selected_num = 4; // 선택한 그리드 크기에 해당하는 값
            }
        });
        btn5by5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3x3 버튼을 클릭했을 때 수행할 작업
                selected_num = 5; // 선택한 그리드 크기에 해당하는 값
            }
        });

        //btnstart 구현
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChallengeModeSelectScreen.this, ChallengeModePlayScreen.class);
                if(selected_num==0) {
                    Toast.makeText(ChallengeModeSelectScreen.this, "난이도를 선택해주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra("selected_num", selected_num); // 그리드 크기 전달
                    intent.putExtra("selected_image", selectedImageUri.toString()); // 이미지 Uri 전달
                    //intent.putExtra("Resource_Id",selectedImageResource);
                    startActivity(intent);
                }
            }
        });
        //btn_back 구현
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnBack.goBack(ChallengeModeSelectScreen.this);
            }
        });





        //데이터 베이스 초기화 버튼
        ImageView init;
        init = (ImageView)findViewById(R.id.challenge_mode_title);
        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHelper.onUpgrade(myHelper.getReadableDatabase(),1,2);
            }
        });

    }
}
