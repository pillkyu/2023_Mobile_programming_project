package com.example.slidepuzzle;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.widget.ImageButton;

public class ChallengeModePlayScreen extends AppCompatActivity {
    public int hintCount = 3; // 초기 힌트 개수
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_play_screen);
        ImageButton hintButton = findViewById(R.id.btn_hint);
        updateHintButtonImage(hintButton, hintCount); // 초기 이미지 설정


        //////////////////////////////////////////////////////////////
        FragmentContainerView fragmentContainerView = findViewById(R.id.fragment_container);

        //hint버튼 눌렷을 때의 동작 구현
        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*

                if (hintCount > 0) {
                    hintCount--; // 힌트 사용
                    updateHintButtonImage(hintButton, hintCount);
                    Uri selectedImageUri = Uri.parse(selectedImageUriString);
                    // 프래그먼트 생성 및 Bundle을 통해 이미지 URI 전달
                    HintFragment hintFragment = new HintFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("imageUri", selectedImageUri.toString()); // URI를 String으로 변환
                    hintFragment.setArguments(bundle);
                    // 프래그먼트 트랜잭션 수행
                    fragmentContainerView.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, hintFragment)
                            .addToBackStack(null)
                            .commit();

                } else {
                    // 힌트를 모두 사용한 상태 (0/3)
                    // 추가적인 동작이 필요하면 여기에 구현
                }
                */
            }

        });

//////////////////////////////////////////////////


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
        hintButton.setEnabled(count > 0);
    }
}
