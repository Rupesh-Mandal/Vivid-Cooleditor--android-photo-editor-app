package com.kali_corporation.vividcooleditor.ui.Pentagon.AmberRenae;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.kali_corporation.vividcooleditor.ui.LocalBaseActivity;
import com.kali_corporation.vividcooleditor.ui.Pentagon.SophiaTolli.AndyTruong;
import com.kali_corporation.vividcooleditor.R;

public class Tempoll extends LocalBaseActivity {

    public static AppCompatActivity activity;
    public static Bitmap bmpBlend = null;

    public static void startWithUri(Context context, Uri _uri) {
        Log.e("xxxx", String.valueOf(_uri));
        Intent intent = new Intent(context, Tempoll.class);
        intent.setData(_uri);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_photoeditor_activity);

        activity = Tempoll.this;

        AndyTruong mainFragment = new AndyTruong();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();

    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.Container);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragment instanceof AndyTruong) {
            AndyTruong.ManageBackPrace();
        } else {
            super.onBackPressed();
        }
    }

}
