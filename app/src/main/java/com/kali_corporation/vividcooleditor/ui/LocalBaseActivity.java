package com.kali_corporation.vividcooleditor.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.kali_corporation.vividcooleditor.R;


public class LocalBaseActivity extends AppCompatActivity {


    private static final int REQUEST_PLAY_STORE = 0x99;
    private final String TAG = getClass().getName();
    private OnRateListner onRateListner;

    public FragmentActivity getActivity() {
        return this;
    }

    public interface OnRateListner {
        void onReminderLater();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_PLAY_STORE) {
            if (onRateListner != null) {
                onRateListner.onReminderLater();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void showResetDialog(Context context, final OnResetListner onResetListner) {

        final Dialog alertDialogBuilder = new Dialog(getActivity());
//        alertDialogBuilder.setTitle("Select Language");
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialogBuilder.getWindow().setBackgroundDrawableResource(R.drawable.round_corner_bg);
        alertDialogBuilder.setContentView(R.layout.dialog_reset);

        final TextView btnNo = (TextView) alertDialogBuilder.findViewById(R.id.btnNo);
        final TextView btnYes = (TextView) alertDialogBuilder.findViewById(R.id.btnYes);



        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialogBuilder.dismiss();
                alertDialogBuilder.cancel();
//                objPref.setisRatingDialog("true");
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogBuilder.dismiss();
                onResetListner.onReset();
            }
        });

        alertDialogBuilder.setCancelable(false);

        // create alert dialog

        // show com.it
        alertDialogBuilder.show();
    }

    public interface OnResetListner {
        void onReset();
    }
}
