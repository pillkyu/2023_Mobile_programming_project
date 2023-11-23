package com.example.slidepuzzle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChallengeModeScreen extends AppCompatActivity {

    private ImageView[] imageViews;
    private int[] imageViewIds = { R.id.image1, R.id.image2, R.id.image3, R.id.image4, R.id.image5, R.id.image6, R.id.image7, R.id.image8 };
    private int[] imageResources = { R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8 };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_mode_screen);

        imageViews = new ImageView[imageViewIds.length]; // 이미지뷰 배열 초기화

        // 이미지뷰들에 클릭 리스너 할당
        for (int i = 0; i < imageViewIds.length; i++) {
            imageViews[i] = findViewById(imageViewIds[i]);
            imageViews[i].setOnClickListener(imageClickListener);
        }

        // btn_back 구현
        ImageButton btnBack = findViewById(R.id.back_button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnBack.goBack(ChallengeModeScreen.this);
            }
        });
    }

    // 이미지뷰에 대한 클릭 리스너
    View.OnClickListener imageClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int selectedIndex = -1;

            // 클릭된 이미지뷰의 인덱스 찾기
            for (int i = 0; i < imageViews.length; i++) {
                if (v.getId() == imageViewIds[i]) {
                    selectedIndex = i;
                    break;
                }
            }

            if (selectedIndex != -1) {
                // 선택된 이미지 리소스 ID 가져오기
                int selectedImageResource = imageResources[selectedIndex];


                // 다른 액티비티로 이동하는 인텐트 생성
                Intent intent = new Intent(ChallengeModeScreen.this, ChallengeModeSelectScreen.class);

                // 선택된 이미지의 리소스 ID를 다른 액티비티로 전달
                intent.putExtra("Resource_Id", selectedImageResource);

                // 다른 액티비티로 이동
                startActivity(intent);
            }
        }
    };
}


