package com.example.slidepuzzle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FreeModePlayScreen extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_play_screen);
        Intent intent = getIntent();
        if (intent != null) {
            String uriString = intent.getStringExtra("selected_image");
            if (uriString != null && !uriString.isEmpty()) {
                Uri selectedImageUri = Uri.parse(uriString);

                // 이미지뷰에 Uri 설정하여 이미지 출력
                ImageView imageView = findViewById(R.id.free_mode_play_placehold);
                imageView.setImageURI(selectedImageUri);
            }
        }

    }

}
