package com.kali_corporation.vividcooleditor.ui.DionLee;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.kali_corporation.vividcooleditor.ui.activity.MainActivity;
import com.kali_corporation.vividcooleditor.ui.ClaudiaChanShaw.LindaBritten;
import com.kali_corporation.vividcooleditor.R;

public class BerilJents extends Fragment implements View.OnClickListener {


    private LindaBritten objdb;

    public BerilJents() {
    }

    RelativeLayout RL_Main;
    ImageView LL_PhotoEditor, LL_LightLikes, ll_Mywork, LL_PhotoFilter;


    public static int Counter = 0;

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        try {


            switch (v.getId()) {
                case R.id.LL_PhotoFilter:
                    MainActivity.Cat = 3;
                    MainActivity.counter = 1;
                    MainActivity.pickFromGallery();
                    break;
                case R.id.LL_PhotoEditor:
                    MainActivity.Cat = 2;
                    MainActivity.counter = 1;
                    MainActivity.pickFromGallery();
                    break;

                case R.id.LL_LightLikes:
                    MainActivity.Cat = 4;
                    MainActivity.counter = 1;
                    MainActivity.pickFromGallery();
                    break;

//                case R.id.LL_PhotoFrame:
//                    RebeccaJudd previewFragment = new RebeccaJudd();
//                    fragmentManager.beginTransaction().replace(R.id.MainContainer, previewFragment).addToBackStack(null).commit();
//                    break;

                case R.id.LL_Camera:
                    MainActivity.Cat = 2;
                    MainActivity.counter = 1;
                    MainActivity.pickFromCamera();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        try {
            FindControls(rootView);

            objdb = new LindaBritten(getActivity());


        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    private void FindControls(View view) {
        RL_Main = (RelativeLayout) view.findViewById(R.id.RL_Main);

        LL_PhotoEditor = (ImageView) view.findViewById(R.id.LL_PhotoEditor);
        ll_Mywork = (ImageView) view.findViewById(R.id.LL_Camera);
        LL_LightLikes = (ImageView) view.findViewById(R.id.LL_LightLikes);
        LL_PhotoFilter = (ImageView) view.findViewById(R.id.LL_PhotoFilter);

        ll_Mywork.setOnClickListener(this);
        LL_LightLikes.setOnClickListener(this);
        LL_PhotoEditor.setOnClickListener(this);
        LL_PhotoFilter.setOnClickListener(this);

    }


}
