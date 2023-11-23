package com.example.slidepuzzle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;



public class StartScreen extends AppCompatActivity {

    myDBHelper myHelper; //데이터베이스 변수 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        myHelper = new myDBHelper(this); //데이터 베이스 생성

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
    //데이터 베이스 생성 클래스
    public static class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "imageRecord", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE image_records (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, imageId INTEGER, time INTEGER, movement INTEGER, num INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS image_records;");

            onCreate(db);
        }
    }


}