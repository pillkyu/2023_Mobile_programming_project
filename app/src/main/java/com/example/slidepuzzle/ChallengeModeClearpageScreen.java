package com.example.slidepuzzle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ChallengeModeClearpageScreen extends AppCompatActivity {
    TextView mytimev,mymovev,times,moves;
    ImageView imgv;
    ImageButton btnmore,btnhome;

    SQLiteDatabase sqlDB;
    StartScreen.myDBHelper myHelper;


    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_mode_clearpage_screen);

        myHelper = new StartScreen.myDBHelper(this);

        imgv =(ImageView)findViewById(R.id.selected_img_challenge_mode);
        mytimev =(TextView) findViewById(R.id.MyTime);
        mymovev =(TextView)findViewById(R.id.MyMoves);

        times =(TextView)findViewById(R.id.Time);
        moves =(TextView)findViewById(R.id.Moves);

        btnmore = (ImageButton)findViewById(R.id.btn_more_ranking);
        btnhome =(ImageButton)findViewById(R.id.btn_home);

        Intent intent = getIntent();
        int imgId = intent.getIntExtra("selected_image",0);
        int num = intent.getIntExtra("selected_num",0);
        int moveCount = intent.getIntExtra("move_count",0);
        int time = intent.getIntExtra("time",0);

        //데이터 삽입
        sqlDB = myHelper.getWritableDatabase(); // DB 쓰기 모드로 읽어옴
        String Sql = "INSERT INTO image_records VALUES (NULL," + imgId + ", " + time + "," + moveCount + ", " + num + ");";
        sqlDB.execSQL(Sql);
        sqlDB.close();

        //my결과 띄우기
        imgv.setImageResource(imgId);
        mytimev.setText(String.valueOf(time));
        mymovev.setText(String.valueOf(moveCount));

        //데이터 검색 및 출력
        sqlDB = myHelper.getReadableDatabase(); // DB 읽기 모드로 읽어옴 //테이블에서 imgId와 num인 투플의 time과 movement 뽑음
        Cursor cursor = sqlDB.rawQuery("SELECT time,movement FROM image_records WHERE imageId = " + imgId + " AND num ="+num+" ORDER BY time ASC, movement ASC LIMIT 3", null);
        String timetext = "";
        String movetext = "";
        while (cursor.moveToNext()) {
            timetext +=String.valueOf(cursor.getString(0))+"\n";
            movetext +=String.valueOf(cursor.getString(1))+"\n";
        }
        times.setText(timetext);
        moves.setText(movetext);
        cursor.close();
        sqlDB.close();


        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RankingpageScreen.class);
                intent.putExtra("selected_image",imgId);
                startActivity(intent);
            }
        });

        //home 버튼 구현
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnHome.goHome(ChallengeModeClearpageScreen.this);
            }
        });

    }
}
