package com.kali_corporation.vividcooleditor.ui.activity;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.kali_corporation.vividcooleditor.ui.ClaudiaChanShaw.LindaBritten;
import com.kali_corporation.vividcooleditor.ui.DovCharney.DeanandDanCaten;
import com.kali_corporation.vividcooleditor.ui.DovCharney.PatrickCox;
import com.kali_corporation.vividcooleditor.ui.DovCharney.SimonChang;
import com.kali_corporation.vividcooleditor.ui.JuliGrbac.FrederickFox.AlannahHill;
import com.kali_corporation.vividcooleditor.R;


public class SplashScreen extends Activity {

    AlannahHill cd;

    public static String name = "";
    LindaBritten objDb;
    private boolean isFirstTime = true;

    ProgressBar splashProgress;
    int SPLASH_TIME = 1000; //This is 3 seconds





    private static final int PERMISSION_CALLBACK_CONSTANT = 100;
    private static final int REQUEST_PERMISSION_SETTING = 101;
    String[] permissionsRequired = new String[]{Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    private SharedPreferences permissionStatus;
    private boolean sentToSettings = false;

    DeanandDanCaten objPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        splashProgress = findViewById(R.id.splashProgress);
        objPref = new DeanandDanCaten(this);

        if (android.os.Build.VERSION.SDK_INT > 22) {
            permissionStatus = getSharedPreferences("permissionStatus", MODE_PRIVATE);

            if (ActivityCompat.checkSelfPermission(SplashScreen.this, permissionsRequired[0]) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(SplashScreen.this, permissionsRequired[1]) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(SplashScreen.this, permissionsRequired[2]) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this, permissionsRequired[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this, permissionsRequired[1])
                        || ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this, permissionsRequired[2])) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SplashScreen.this);
                    builder.setTitle("Need Multiple Permissions");
                    builder.setMessage("This app needs Camera and Location permissions.");
                    builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            ActivityCompat.requestPermissions(SplashScreen.this, permissionsRequired, PERMISSION_CALLBACK_CONSTANT);
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                } else if (permissionStatus.getBoolean(permissionsRequired[0], false)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SplashScreen.this);
                    builder.setTitle("Need Multiple Permissions");
                    builder.setMessage("This app needs Camera and Location permissions.");
                    builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            sentToSettings = true;
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getPackageName(), null);
                            intent.setData(uri);
                            startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                            Toast.makeText(getBaseContext(), "Go to Permissions to Grant  Camera and Location", Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                } else {
                    ActivityCompat.requestPermissions(SplashScreen.this, permissionsRequired, PERMISSION_CALLBACK_CONSTANT);
                }


                SharedPreferences.Editor editor = permissionStatus.edit();
                editor.putBoolean(permissionsRequired[0], true);
                editor.commit();
            } else {
                proceedAfterPermission();
            }
        } else {
            Log.e("Lower Version","Lower Version");
//            this.finish();
//            startActivity(new Intent(Lantesta.this, Lajavab.class));
//            overridePendingTransition(R.anim.right_in, R.anim.left_out);
            allDone();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CALLBACK_CONSTANT) {
            boolean allgranted = false;
            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    allgranted = true;
                } else {
                    allgranted = false;
                    break;
                }
            }

            if (allgranted) {
                proceedAfterPermission();
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this, permissionsRequired[0])
                    || ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this, permissionsRequired[1])
                    || ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this, permissionsRequired[2])) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SplashScreen.this);
                builder.setTitle("Need Multiple Permissions");
                builder.setMessage("This app needs Camera and Location permissions.");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(SplashScreen.this, permissionsRequired, PERMISSION_CALLBACK_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            } else {
                Toast.makeText(getBaseContext(), "Unable to get Permission", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            if (ActivityCompat.checkSelfPermission(SplashScreen.this, permissionsRequired[0]) == PackageManager.PERMISSION_GRANTED) {
                proceedAfterPermission();
            }
        }
    }

    private void proceedAfterPermission() {
//        this.finish();
//        startActivity(new Intent(Lantesta.this, Lajavab.class));
//        overridePendingTransition(R.anim.right_in, R.anim.left_out);
        allDone();


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (sentToSettings) {
            if (ActivityCompat.checkSelfPermission(SplashScreen.this, permissionsRequired[0]) == PackageManager.PERMISSION_GRANTED) {
                proceedAfterPermission();
            }
        }
    }


    private void allDone() {
        PatrickCox.SDCardPath = objPref.getSaveDirURL();
        cd = new AlannahHill(this);
        objDb = new LindaBritten(SplashScreen.this);


        new BASE_AGREEMENT_CIPHER().execute();
        try {
            if (cd.isConnectingToInternet()) {
                Log.e("Service", "Started from splash");
            } else {

            }
            callHome();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public class BASE_AGREEMENT_CIPHER extends AsyncTask<Void, Integer, String> {

        @Override
        protected String doInBackground(Void... params) {
            try {
                SimonChang.CIPHER_TO_DHKEY_AGREEMENT_256BIT_KEYGENERATOR("oauthentication_base64_hash64", "MODE_BASE_24_PRIVATE", getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }


    public void callHome() {
        playProgress();

        //Code to start timer and take action after the timer ends
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstTime) {
                    isFirstTime = false;
                    Intent localIntent = new Intent(SplashScreen.this, MainActivity.class);
                    SplashScreen.this.startActivity(localIntent);
                    finish();
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        }, SPLASH_TIME);
    }
    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                .setDuration(2000)
                .start();
    }


}
