package com.kali_corporation.vividcooleditor.ui.RuthTarvydas.RichardTyler;

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
import com.kali_corporation.vividcooleditor.R;
import com.kali_corporation.vividcooleditor.ui.RuthTarvydas.AhedZanetti.VeroniqueBranquinho;

public class Pnanterist extends LocalBaseActivity {

    public static AppCompatActivity activity;
    public static Bitmap bmpBlend = null;

    public static void startWithUri(Context context, Uri _uri) {
        Log.e("xxxx", String.valueOf(_uri));
        Intent intent = new Intent(context, Pnanterist.class);
        intent.setData(_uri);
        context.startActivity(intent);
//        activity.overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.Container);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragment instanceof VeroniqueBranquinho) {
            VeroniqueBranquinho.ManageBackPresd();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_photoeditor_activity);

        activity = Pnanterist.this;

        VeroniqueBranquinho mainFragment = new VeroniqueBranquinho();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();

    }

}
