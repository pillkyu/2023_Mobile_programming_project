package com.example.slidepuzzle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class pauseFragment extends Fragment{
    //Fragment 관련 코드 작성
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // fragment_hinte_screen.xml 레이아웃을 인플레이트하여 Fragment의 UI로 설정
        View view = inflater.inflate(R.layout.fragment_pause_screen, container, false);


        //resume 구현
        ImageButton btnresume = view.findViewById(R.id.btn_game_start);
        btnresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getParentFragmentManager() != null) {
                    // FreeModePlayScreen의 인스턴스에 접근하여 메서드 호출
                    ((FreeModePlayScreen) getActivity()).resumeTimerFromFragment();
                    getParentFragmentManager().beginTransaction().remove(pauseFragment.this).commit();
                }
            }
        });

        return view;
    }
}