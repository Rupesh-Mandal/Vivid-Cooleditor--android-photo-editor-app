package com.kali_corporation.vividcooleditor.ui.PeterJackson.JennyKee;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.kali_corporation.vividcooleditor.ui.LocalBaseActivity;
import com.kali_corporation.vividcooleditor.ui.PeterJackson.AnthonyPittorino.NevilleQuist;
import com.kali_corporation.vividcooleditor.R;

public class Bentesta extends LocalBaseActivity {


    public static AppCompatActivity activity;

    public static void startWithUri(Context context, Uri _uri) {
        Log.e("xxxx", String.valueOf(_uri));
        Intent intent = new Intent(context, Bentesta.class);
        intent.setData(_uri);
        context.startActivity(intent);
//        activity.overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    @Override
    public void onBackPressed() {

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.MainContainer);
//        super.onBackPressed();
        if (fragment instanceof NevilleQuist) {
            NevilleQuist.ManageBackpraced();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_second_activity);

        activity = Bentesta.this;

        FragmentManager fragmentManager = getSupportFragmentManager();
        NevilleQuist blankFragment = new NevilleQuist();
        fragmentManager.beginTransaction().replace(R.id.MainContainer, blankFragment).addToBackStack(null).commit();

    }
}
