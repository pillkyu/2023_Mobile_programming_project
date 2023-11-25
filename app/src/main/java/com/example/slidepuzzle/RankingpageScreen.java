package com.example.slidepuzzle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RankingpageScreen extends AppCompatActivity {
    SQLiteDatabase sqlDB;
    StartScreen.myDBHelper myHelper;
    TextView rankv,timev,movev;
    RadioButton btn3,btn4,btn5;       //이미지 버튼으로 대체 될 지도 모름
    ImageButton btnhome;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankingpage_screen);

        myHelper = new StartScreen.myDBHelper(this); //db불러옴

        rankv  =(TextView) findViewById(R.id.Rank);
        timev  =(TextView) findViewById(R.id.Time);
        movev  =(TextView) findViewById(R.id.Moves);

        btn3 =(RadioButton) findViewById(R.id.btn_3by3); //3*3 랭킹만 출력
        btn4 =(RadioButton) findViewById(R.id.btn_4by4); //4*4 랭킹만 출력
        btn5 =(RadioButton) findViewById(R.id.btn_5by5); //5*5 랭킹만 출력

        btnhome =(ImageButton)findViewById(R.id.btn_home);


        Intent intent = getIntent();
        int imgId = intent.getIntExtra("selected_image",0);

        // 처음에 전체 랭킹 뿌림
        sqlDB = myHelper.getReadableDatabase(); // DB 읽기 모드로 읽어옴
        Cursor cursor = sqlDB.rawQuery("SELECT time,movement FROM image_records WHERE imageId = " + imgId + " ORDER BY time ASC, movement ASC LIMIT 20", null);
        String timetext = "";
        String movetext = "";
        String ranktext ="";
        int number = 1;  //Rank에 표시될 숫자
        while (cursor.moveToNext()) {

            timetext +=String.valueOf(cursor.getString(0)) +"\n";
            movetext +=String.valueOf(cursor.getString(1))+"\n";
            ranktext +=String.valueOf(number)+"\n";
            number ++;
        }
        timev.setText(timetext);
        movev.setText(movetext);
        rankv.setText(ranktext);
        cursor.close();
        sqlDB.close();

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase(); // DB 읽기 모드로 읽어옴
                Cursor cursor = sqlDB.rawQuery("SELECT time,movement FROM image_records WHERE imageId = " + imgId + " AND num = 3 ORDER BY time ASC, movement ASC LIMIT 20", null);
                String timetext = "";
                String movetext = "";
                String ranktext ="";
                int number = 1;  //Rank에 표시될 숫자
                while (cursor.moveToNext()) {
                    timetext +=String.valueOf(cursor.getString(0)) +"\n";
                    movetext +=String.valueOf(cursor.getString(1))+"\n";
                    ranktext +=String.valueOf(number)+"\n";
                    number ++;
                }
                timev.setText(timetext);
                movev.setText(movetext);
                rankv.setText(ranktext);
                cursor.close();
                sqlDB.close();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase(); // DB 읽기 모드로 읽어옴
                Cursor cursor = sqlDB.rawQuery("SELECT time,movement FROM image_records WHERE imageId = " + imgId + " AND num = 4 ORDER BY time ASC, movement ASC LIMIT 20", null);
                String timetext = "";
                String movetext = "";
                String ranktext ="";
                int number = 1;  //Rank에 표시될 숫자
                while (cursor.moveToNext()) {
                    timetext +=String.valueOf(cursor.getString(0)) +"\n";
                    movetext +=String.valueOf(cursor.getString(1))+"\n";
                    ranktext +=String.valueOf(number)+"\n";
                    number ++;
                }
                timev.setText(timetext);
                movev.setText(movetext);
                rankv.setText(ranktext);
                cursor.close();
                sqlDB.close();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase(); // DB 읽기 모드로 읽어옴
                Cursor cursor = sqlDB.rawQuery("SELECT time,movement FROM image_records WHERE imageId = " + imgId + " AND num = 5 ORDER BY time ASC, movement ASC LIMIT 20", null);
                String timetext = "";
                String movetext = "";
                String ranktext ="";
                int number = 1;  //Rank에 표시될 숫자
                while (cursor.moveToNext()) {
                    timetext +=String.valueOf(cursor.getString(0)) +"\n";
                    movetext +=String.valueOf(cursor.getString(1))+"\n";
                    ranktext +=String.valueOf(number)+"\n";
                    number ++;
                }
                timev.setText(timetext);
                movev.setText(movetext);
                rankv.setText(ranktext);
                cursor.close();
                sqlDB.close();
            }
        });

        //home 버튼 구현
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnHome.goHome(RankingpageScreen.this);
            }
        });
    }
}
