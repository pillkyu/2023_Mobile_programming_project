package com.example.slidepuzzle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


    public class FreeModeScreen extends AppCompatActivity {

        private int selected_num;
        private Uri selectedImageUri;
        private Uri squareUri;
        File imageFile; // 이 부분을 클래스 레벨로 옮김

        private ActivityResultLauncher<Intent> activityResultLauncher;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_free_mode_screen);

            imageFile = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "square_image.jpg"); // 이 부분을 onCreate 내부로 이동


            activityResultLauncher = registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK) {
                                Intent intent = result.getData();
                                selectedImageUri = intent.getData();
                                displayImage(selectedImageUri);
                            }
                        }
                    }
            );




            Button btnbringimage = findViewById(R.id.btn_bring_image);
            btnbringimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    intent.setAction(Intent.ACTION_PICK);
                    activityResultLauncher.launch(intent);

                    btnbringimage.setVisibility(View.GONE);
                    View viewforimage = findViewById(R.id.view_for_image);
                    viewforimage.setVisibility(View.VISIBLE);

                }
            });
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
                    if (selected_num == 0 && selectedImageUri == null) {
                        // 둘 다 선택되지 않은 경우
                        Toast.makeText(FreeModeScreen.this, "이미지와 난이도를 선택해주세요!", Toast.LENGTH_SHORT).show();
                    } else if (selected_num == 0) {
                        // 난이도를 선택하지 않은 경우
                        Toast.makeText(FreeModeScreen.this, "난이도를 선택해주세요!", Toast.LENGTH_SHORT).show();
                    } else if (selectedImageUri == null) {
                        // 이미지를 선택하지 않은 경우
                        Toast.makeText(FreeModeScreen.this, "이미지를 선택해주세요!", Toast.LENGTH_SHORT).show();
                    } else {
                        // nbyn 버튼과 이미지 가져오기 버튼을 모두 선택한 경우
                        Intent intent = new Intent(FreeModeScreen.this, FreeModePlayScreen.class);
                        intent.putExtra("selected_num", selected_num); // 그리드 크기 전달
                        intent.putExtra("selected_image", squareUri.toString()); // 이미지 byte 전달
                        startActivity(intent);
                    }
                }
            });





            //btn_back 구현
            ImageButton btnBack = findViewById(R.id.btn_back);
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BtnBack.goBack(FreeModeScreen.this);
                }
            });
        }


        private void displayImage(Uri imageUri) {
            // 이미지 뷰에서 이미지 표시하는 코드
            // Your logic for displaying the image in the ImageView
            try {
                // 이미지를 정사각형으로 자르는 로직
                Bitmap originalBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                // 정사각형 이미지로 설정
                int width = originalBitmap.getWidth();
                int height = originalBitmap.getHeight();
                int squareSize = Math.min(width, height);
                int x = (width - squareSize) / 2;
                int y = (height - squareSize) / 2;
                Bitmap squareBitmap = Bitmap.createBitmap(originalBitmap, x, y, squareSize, squareSize);
                ImageView imageView = findViewById(R.id.view_for_image);
                imageView.setImageBitmap(squareBitmap);
                try {
                    FileOutputStream fos = new FileOutputStream(imageFile);
                    squareBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                    squareUri = FileProvider.getUriForFile(this, "com.example.slidepuzzle.provider", imageFile);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }










