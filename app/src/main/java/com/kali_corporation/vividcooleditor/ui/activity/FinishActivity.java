package com.kali_corporation.vividcooleditor.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kali_corporation.vividcooleditor.ui.ClaudiaChanShaw.LindaBritten;
import com.kali_corporation.vividcooleditor.ui.DovCharney.PatrickCox;
import com.kali_corporation.vividcooleditor.ui.LocalBaseActivity;
import com.kali_corporation.vividcooleditor.R;

public class FinishActivity extends LocalBaseActivity {





    ImageView BackImage;
    Bundle bundle;

    private static Context mContext;

    RelativeLayout scrollView;
    private LindaBritten objDb;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    public void SetLayout() {
        Display display = getWindowManager().getDefaultDisplay();
        int w = display.getWidth();

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, (w * 45) / 100, 0, 0);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_image_activity);

        objDb = new LindaBritten(getActivity());

        scrollView = (RelativeLayout) findViewById(R.id.scrollView);

        Button done=findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FinishActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView imgButtonImage = (ImageView) findViewById(R.id.imgButtonImage);
        imgButtonImage.setVisibility(View.VISIBLE);
        imgButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FinishActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView txtHeaderName = (TextView) findViewById(R.id.txtHeaderName);
        bundle = getIntent().getExtras();
        BackImage = (ImageView) findViewById(R.id.BackImage);


        mContext = FinishActivity.this;

        try {
            BackImage.setImageBitmap(PatrickCox.FinalBitmap);
            SetLayout();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Animation animation;

    public static void SingleIn(final View view) {

        animation = AnimationUtils.loadAnimation(mContext, R.anim.bottom_fast_holder);
        view.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                animation.setAnimationListener(null);
                view.clearAnimation();
                view.setVisibility(View.VISIBLE);
            }

        });
    }

}
