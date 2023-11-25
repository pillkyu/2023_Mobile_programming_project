package com.example.slidepuzzle;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class HintFragment extends Fragment{
    //Fragment 관련 코드 작성
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // fragment_hinte_screen.xml 레이아웃을 인플레이트하여 Fragment의 UI로 설정
        View view = inflater.inflate(R.layout.fragment_hint_screen, container, false);

        ImageView imageView = view.findViewById(R.id.img_hint);
        // Bundle에서 이미지 URI 받기
        Bundle bundle = getArguments();
        if (bundle != null) {
            String imageUriString = bundle.getString("imageUri");
            Uri imageUri = Uri.parse(imageUriString); // String을 Uri로 변환
            imageView.setImageURI(imageUri); // ImageView에 이미지 설정
        }

        //btn_back 구현
        ImageButton btnBack = view.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getParentFragmentManager() != null) {
                    getParentFragmentManager().beginTransaction().remove(HintFragment.this).commit();
                }
            }
        });

        return view;
    }
}