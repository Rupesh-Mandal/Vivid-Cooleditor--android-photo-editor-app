package com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.julesFrancoisCrahay;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.dd.processbutton.iml.ActionProcessButton;
//import com.dd.processbutton.iml.ActionProcessButton;
import com.kali_corporation.vividcooleditor.ui.activity.MainActivity;
import com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.RafSimons.OlivierStrelli;
import com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.RafSimons.OlivierTheyskens;
import com.kali_corporation.vividcooleditor.ui.DovCharney.DeanandDanCaten;
import com.kali_corporation.vividcooleditor.ui.DovCharney.PatrickCox;
import com.kali_corporation.vividcooleditor.ui.KayCohen.SusienChong;
import com.kali_corporation.vividcooleditor.ui.LocalBaseActivity;
import com.kali_corporation.vividcooleditor.R;
//import com.dd.processbutton.iml.ActionProcessButton;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Dabdea extends LocalBaseActivity {

    public static AppCompatActivity activity;
    public  static RecyclerView recycler_view;
    CarlaZampatti adapter;
    ArrayList<SusienChong> arrayList;
    public void getPosterData() {

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setStackFromEnd(true);
        recycler_view.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();
        try {
            AssetManager assetManager = getResources().getAssets();
            String files[] = assetManager.list("effect");
            if (files != null) {
                for (String file : files) {
                    arrayList.add(new SusienChong("effect/" + file));
                }

                adapter = new CarlaZampatti(this);
                recycler_view.setAdapter(adapter);
                adapter.notifyItemInserted(arrayList.size() - 1);
                linearLayoutManager.scrollToPosition(PatrickCox.Pos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second_fragment);

        activity = Dabdea.this;
        appPrefs = new DeanandDanCaten(getActivity());
        handler = new Handler();
        getDownloadCompleted = new GetDownloadCompleted();

        getPosterData();
        OlivierTheyskens mainFragment = new OlivierTheyskens();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();


    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.Container);
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragment instanceof OlivierTheyskens) {

            showResetDialog(getActivity(), new OnResetListner() {
                @Override
                public void onReset() {
                    startActivity(new Intent(Dabdea.this, MainActivity.class));
                    finish();
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            });

        } else if (fragment instanceof OlivierStrelli) {
            try {
                if (OlivierStrelli.Counter != 0) {
                    OlivierStrelli.imgButtonImage.setImageResource(R.drawable.ic_next);
                    switch (OlivierStrelli.Counter) {

                        case 1:
                            OlivierStrelli.flyOut((View) OlivierStrelli.curveList, (View) OlivierStrelli.MainMenu);
                            OlivierStrelli.Counter = 0;
                            break;

                        case 2:
                            OlivierStrelli.flyOut((View) OlivierStrelli.fragment_Blur, (View) OlivierStrelli.LL_MainMenu);
                            OlivierStrelli.Counter = 0;
                            break;

                        case 3:
                            OlivierStrelli.flyOut((View) OlivierStrelli.Sticker_recycler_view, (View) OlivierStrelli.LL_MainMenu);
                            OlivierStrelli.Counter = 0;
                            break;
                        case 4:
                            OlivierStrelli.flyOut((View) OlivierStrelli.Abc_recycler_view, (View) OlivierStrelli.LL_MainMenu);
                            OlivierStrelli.Counter = 0;
                            break;

                        case 5:
                            OlivierStrelli.flyOut((View) OlivierStrelli.LL_TextMainLayout, (View) OlivierStrelli.LL_MainMenu);
                            OlivierStrelli.Counter = 0;
                            break;

                        case 7:
                            OlivierStrelli.imgButtonImage.setImageResource(R.drawable.ic_true);
                            OlivierStrelli.flyOut((View) OlivierStrelli.fragment_Blur, (View) OlivierStrelli.LL_TextMainLayout);
                            OlivierStrelli.Counter = 5;
                            break;
                        case 8:
                            OlivierStrelli.imgButtonImage.setImageResource(R.drawable.ic_true);
                            OlivierStrelli.flyOut((View) OlivierStrelli.ABCFont, (View) OlivierStrelli.LL_TextMainLayout);
                            OlivierStrelli.Counter = 5;
                            break;

                    }
                } else {

                    showResetDialog(getActivity(), new OnResetListner() {
                        @Override
                        public void onReset() {
                            startActivity(new Intent(Dabdea.this, MainActivity.class));
                            finish();
                            overridePendingTransition(R.anim.right_in, R.anim.left_out);
                        }
                    });
                }
            } catch (Exception e) {

            }
        }
    }

    public static void startWithUri(Context context, Uri _uri) {
        Log.e("xxxx", String.valueOf(_uri));
        Intent intent = new Intent(context, Dabdea.class);
        intent.setData(_uri);
        context.startActivity(intent);
//        activity.overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    GetDownloadCompleted getDownloadCompleted;
    private Handler handler;
    private boolean FrameDownload = false;
    private int Ads = -1;
    Button btnDownload;

    DeanandDanCaten appPrefs;
    ArrayList<SusienChong> arrayListprev;
    String effectName[] = {"Adonias", "Bacchus", "Blackflower", "Boxingstar", "Browndown", "Dacey", "Ealasaid", "Earleen", "Flyingman", "fotospot",
            "Gotulost", "haddley", "Heriwarm", "jumpket", "kulamt", "librotus", "potruzone", "purpcore", "viscotta", "albormentio"};

    class CarlaZampatti extends RecyclerView.Adapter<CarlaZampatti.MyViewHolder> {

        Context mContext;

        public CarlaZampatti(Context mcContext) {

            this.mContext = mcContext;

            try {
                arrayListprev = new ArrayList<>();
                AssetManager assetManager = this.mContext.getResources().getAssets();
                String files[] = assetManager.list("prev");
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        arrayListprev.add(new SusienChong("prev/" + files[i], effectName[i]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sticker_card, parent, false);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            Bitmap bitmapFrame = null;
            try {
                holder.imageViewIcon.setImageBitmap(getBitmapFromAsset(arrayListprev.get(position).getDirName()));

                holder.down_icon.setVisibility(View.VISIBLE);

                if (appPrefs.getDownloadArrayList() != null) {

                    ArrayList<String> stringArrayList = appPrefs.getDownloadArrayList();

                    for (int i = 0; i < stringArrayList.size(); i++) {

                        if (stringArrayList.get(i).equals(arrayListprev.get(position).getDirName())) {
                            holder.down_icon.setVisibility(View.GONE);
                        }
                    }
                }

                holder.imageViewIcon.setTag("" + position);
                holder.imageViewIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        try {

                            ArrayList<String> stringArrayList = appPrefs.getDownloadArrayList();
                            if (stringArrayList == null) {
                                stringArrayList = new ArrayList<>();
                            }


                            if (holder.down_icon.getVisibility() == View.VISIBLE) {
                                stringArrayList.add(arrayListprev.get(position).getDirName());
                                appPrefs.setDownloadArrayList(stringArrayList);
                                OpenDownloadDialog(Integer.parseInt((String) v.getTag()));
                            } else {
                                adapter.notifyDataSetChanged();

                                adapter.notifyItemChanged(position);

                                appPrefs.setPipId("" + position);
                                appPrefs.setPipName(arrayList.get(position).getDirName());

                                Log.e("Name : ", "" + appPrefs.getPipName());

                                try {
                                    OlivierTheyskens.RL_MagicEffect.removeAllViews();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
//                                        startDecodingLatestCurveData();
                                            FragmentManager fragmentManager = ((Dabdea) getActivity()).getSupportFragmentManager();
                                            OlivierTheyskens mainFragment = new OlivierTheyskens();
                                            fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }, 500);
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        private Bitmap getBitmapFromAsset(String strName) {
            AssetManager assetManager = mContext.getAssets();
            InputStream istr = null;
            try {
                istr = assetManager.open(strName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(istr);
            return bitmap;
        }

        @Override
        public int getItemCount() {

            return arrayList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageViewIcon, down_icon;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imgStickerIcon);
                this.down_icon = (ImageView) itemView.findViewById(R.id.down_icon);

            }
        }

    }

    Dialog alertDialogBuilder;

    private void OpenDownloadDialog(final int listPosition) {
        alertDialogBuilder = new Dialog(getActivity());
//        alertDialogBuilder.setTitle("Select Language");
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialogBuilder.setContentView(R.layout.download_dialog_fragment);

        final RelativeLayout nativeAdsLayout = (RelativeLayout) alertDialogBuilder.findViewById(R.id.nativeAdsLayout);
        //btnDownload = (ActionProcessButton) alertDialogBuilder.findViewById(R.id.btnDownload);

        handler.postDelayed(getDownloadCompleted, 2000);

//        btnDownload.setMode(ActionProcessButton.Mode.ENDLESS);
//
//        btnDownload.setProgress(10);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    adapter.notifyDataSetChanged();

                    adapter.notifyItemChanged(listPosition);

                    alertDialogBuilder.dismiss();
                    appPrefs.setPipId("" + listPosition);
                    appPrefs.setPipName(arrayList.get(listPosition).getDirName());

                    Log.e("Name : ", "" + appPrefs.getPipName());

                    try {
                        OlivierTheyskens.RL_MagicEffect.removeAllViews();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
//                                        startDecodingLatestCurveData();
                                FragmentManager fragmentManager = ((Dabdea) getActivity()).getSupportFragmentManager();
                                OlivierTheyskens mainFragment = new OlivierTheyskens();
                                fragmentManager.beginTransaction().replace(R.id.Container, mainFragment).commit();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.show();
    }

    class GetDownloadCompleted implements Runnable {
        GetDownloadCompleted() {
        }

        public void run() {

            if (FrameDownload && (Ads == 0 || Ads == 1)) {
                Log.e("GetDownloadCompleted", "FrameDownload " + FrameDownload + " Ads " + Ads);
                //btnDownload.setProgress(100);
                btnDownload.setEnabled(true);
                adapter.notifyDataSetChanged();
                handler.removeCallbacks(getDownloadCompleted);
            } else {
                Log.e("GetDownloadCompleted", "FrameDownload " + FrameDownload + " Ads " + Ads);
                handler.removeCallbacks(getDownloadCompleted);
                FrameDownload = true;
                handler.postDelayed(getDownloadCompleted, 3000);
            }
        }
    }
}

