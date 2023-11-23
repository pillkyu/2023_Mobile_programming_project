package com.example.slidepuzzle;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;

public class ChallengeModePlayScreen extends AppCompatActivity {
    public int hintCount = 3; // 초기 힌트 개수
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_mode_play_screen);

        ImageButton hintButton = findViewById(R.id.btn_hint_counted);

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hintCount > 0) {
                    hintCount--; // 힌트 사용
                    updateHintButtonImage(hintButton, hintCount);
                } else {
                    // 힌트를 모두 사용한 상태 (0/3)
                    // 추가적인 동작이 필요하면 여기에 구현
                }
            }
        });

        // 초기 이미지 설정
        updateHintButtonImage(hintButton, hintCount);
    }

    public void updateHintButtonImage(ImageButton hintButton, int count) {
        switch (count) {
            case 3:
                hintButton.setImageResource(R.drawable.btn_hint_3_selector);
                break;
            case 2:
                hintButton.setImageResource(R.drawable.btn_hint_2_selector);
                break;
            case 1:
                hintButton.setImageResource(R.drawable.btn_hint_1_selector);
                break;
            case 0:
                hintButton.setImageResource(R.drawable.btn_hint_0_selector);
                break;
        }
    }
}
