package com.kali_corporation.vividcooleditor.ui;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.kali_corporation.vividcooleditor.ui.ClaudiaChanShaw.LindaBritten;
public class ArielGarten extends MultiDexApplication {

    private static Context mContext;

    private static ArielGarten mInstance;
    LindaBritten objDb;


    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mContext = getApplicationContext();
            MultiDex.install(this);

            mInstance = this;
            objDb = new LindaBritten(getApplicationContext());
            objDb.createDatabase();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
