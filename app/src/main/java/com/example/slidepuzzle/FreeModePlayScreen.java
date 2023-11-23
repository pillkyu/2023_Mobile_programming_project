package com.example.slidepuzzle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

public class FreeModePlayScreen extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_play_screen);

        ImageButton btnHint = findViewById(R.id.btn_hint);
        FragmentContainerView fragmentContainerView = findViewById(R.id.fragment_container);

        //hint버튼 눌렷을 때의 동작 구현
        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment표시
                fragmentContainerView.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new HintFragment())
                        .commit();
            }
        });

        //홈버튼 구현
        ImageButton btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //BtnHome클래스의 goHome 메서드 호출
                BtnHome.goHome(FreeModePlayScreen.this);
            }
        });

    }
}


