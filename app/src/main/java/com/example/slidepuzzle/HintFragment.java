package com.example.slidepuzzle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class HintFragment extends Fragment{
    //Fragment 관련 코드 작성
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // fragment_hinte_screen.xml 레이아웃을 인플레이트하여 Fragment의 UI로 설정
        View view = inflater.inflate(R.layout.fragment_hint_screen, container, false);

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
