package com.kali_corporation.vividcooleditor.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.kali_corporation.vividcooleditor.ui.ClaudiaChanShaw.LindaBritten;
import com.kali_corporation.vividcooleditor.ui.DionLee.BerilJents;
import com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.julesFrancoisCrahay.Dabdea;
import com.kali_corporation.vividcooleditor.ui.DovCharney.DeanandDanCaten;
import com.kali_corporation.vividcooleditor.ui.DovCharney.PatrickCox;
import com.kali_corporation.vividcooleditor.ui.LocalBaseActivity;
import com.kali_corporation.vividcooleditor.ui.Pentagon.AmberRenae.Tempoll;
import com.kali_corporation.vividcooleditor.ui.PeterJackson.JennyKee.Bentesta;
import com.kali_corporation.vividcooleditor.R;
import com.kali_corporation.vividcooleditor.ui.RuthTarvydas.RichardTyler.Pnanterist;
//import com.yalantis.ucrop.UCrop;
//import com.yalantis.ucrop.model.AspectRatio;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class MainActivity extends LocalBaseActivity {

    public static String currentPhotoPath;
    public static AppCompatActivity activity;
    private String TAG = "MainActivity";
    DeanandDanCaten objPref;

    public static int Cat = 0;
    public static int counter = 0;
    float finalratings = 5;
    public static boolean isCamera=false;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    boolean flag = false;
    private LindaBritten objDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        objDb = new LindaBritten(getActivity());

        verifyStoragePermissions(MainActivity.this);

        activity = MainActivity.this;
        objPref = new DeanandDanCaten(this);
        PatrickCox.FinalBitmap = null;

        BerilJents mainFragment = new BerilJents();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.MainContainer, mainFragment).commit();

    }


    @Override
    public void onBackPressed() {
        Fragment frag = getSupportFragmentManager().findFragmentById(R.id.MainContainer);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            if (frag instanceof BerilJents) {

                if (BerilJents.Counter != 0) {
                    BerilJents.Counter = 0;
                } else {
                    finish();
                }
            } else {
                BerilJents MainFragment = new BerilJents();
                fragmentManager.beginTransaction().replace(R.id.MainContainer, MainFragment).commit();
            }
        } catch (Exception e) {

        }
    }

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (isCamera==true){
            Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath);
            Uri uri =getImageUri(MainActivity.this,bitmap);
            handleCropResult(uri);

        }



        if(resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 110:
                    Log.e("xxxx",currentPhotoPath);
                    if (resultCode == RESULT_OK && data != null) {

                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        handleCropResult(Uri.parse(currentPhotoPath));
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage =  data.getData();
                        if (selectedImage != null) {
                            handleCropResult(selectedImage);
                        }

                    }
                    break;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage";
    private static final int REQUEST_SELECT_PICTURE = 0x01;

    public static void pickFromGallery() {
        isCamera=false;
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(pickPhoto , 1);

    }
    public static void pickFromCamera(){
        isCamera=true;
        String fileName="photo";
        File storageDirectory=activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        try {
            File imageFile=File.createTempFile(fileName,".jpg",storageDirectory);
            currentPhotoPath=imageFile.getAbsolutePath();
            Uri imageUri= FileProvider.getUriForFile(activity,"com.kali_corporation.vividcooleditor.fileprovider",imageFile);
            Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
            activity.startActivityForResult(intent,110);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void handleCropResult(Uri result) {
        final Uri resultUri = result;
        if (resultUri != null) {

            try {
                PatrickCox.bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), resultUri);
                PatrickCox.BlurBitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, PatrickCox.bitmap.getWidth() * 10 / 100, PatrickCox.bitmap.getHeight() * 10 / 100, false);

                Display display = getWindowManager().getDefaultDisplay();
                int w = display.getWidth();
                int h = display.getHeight();

                if (PatrickCox.bitmap.getHeight() > PatrickCox.bitmap.getWidth()) {
                    if (PatrickCox.bitmap.getHeight() > h)
                        PatrickCox.bitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, ((PatrickCox.bitmap.getWidth() * h) / PatrickCox.bitmap.getHeight()), h, false);

                    if (PatrickCox.bitmap.getWidth() > w) {
                        PatrickCox.bitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, w, ((PatrickCox.bitmap.getHeight() * w) / PatrickCox.bitmap.getWidth()), false);
                    }
                } else {
                    if (PatrickCox.bitmap.getWidth() > w) {
                        PatrickCox.bitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, w, ((PatrickCox.bitmap.getHeight() * w) / PatrickCox.bitmap.getWidth()), false);
                    }

                    if (PatrickCox.bitmap.getHeight() > h)
                        PatrickCox.bitmap = Bitmap.createScaledBitmap(PatrickCox.bitmap, ((PatrickCox.bitmap.getWidth() * h) / PatrickCox.bitmap.getHeight()), h, false);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (Cat == 1) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Dabdea.startWithUri(MainActivity.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

            if (Cat == 2) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Tempoll.startWithUri(MainActivity.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
            if (Cat == 3) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Pnanterist.startWithUri(MainActivity.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
            if (Cat == 4) {
                PatrickCox.Orizanal = PatrickCox.bitmap;
                Bentesta.startWithUri(MainActivity.this, resultUri);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }


            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        } else {
            Toast.makeText(MainActivity.this, "Cannot retrieve cropped image", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}

