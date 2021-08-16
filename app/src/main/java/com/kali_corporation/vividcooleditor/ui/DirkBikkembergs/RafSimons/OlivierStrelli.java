package com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.RafSimons;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kali_corporation.vividcooleditor.ui.activity.FinishActivity;
import com.kali_corporation.vividcooleditor.ui.ChristopherEssex.JohnCrittle;
import com.kali_corporation.vividcooleditor.ui.ChristopherEssex.LizDavenport;
import com.kali_corporation.vividcooleditor.ui.ChristopherEssex.WayneCooper;
import com.kali_corporation.vividcooleditor.ui.DianaVonGrüning;
import com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.AnnDemeulemeester.BrunoPieters;
import com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.AnnDemeulemeester.CathyPill;
import com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.AnnDemeulemeester.MartinMargiela;
import com.kali_corporation.vividcooleditor.ui.DirkBikkembergs.julesFrancoisCrahay.Dabdea;
import com.kali_corporation.vividcooleditor.ui.DovCharney.PatrickCox;
import com.kali_corporation.vividcooleditor.ui.KayCohen.SusienChong;
import com.kali_corporation.vividcooleditor.ui.LocalBaseActivity;
import com.kali_corporation.vividcooleditor.R;
import com.kali_corporation.vividcooleditor.ui.multiTouchLib.MultiTouchListener;
import com.kali_corporation.vividcooleditor.ui.stickerView.StickerView;
import com.kali_corporation.vividcooleditor.ui.textviewBubble.BubbleInputDialog;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.kali_corporation.vividcooleditor.tool.component.widget.AdapterView;
import com.kali_corporation.vividcooleditor.tool.component.widget.HListView;
import com.kali_corporation.vividcooleditor.tool.gui.GPUImageBrightnessFilter;
import com.kali_corporation.vividcooleditor.tool.gui.GPUImageContrastFilter;
import com.kali_corporation.vividcooleditor.tool.gui.GPUImageFilterGroup;
import com.kali_corporation.vividcooleditor.tool.gui.GPUImageSaturationFilter;
import com.kali_corporation.vividcooleditor.tool.gui.GPUImageSharpenFilter;
import com.kali_corporation.vividcooleditor.tool.gui.GPUImageToneCurveFilter;
import com.kali_corporation.vividcooleditor.tool.gui.GPUImageView;
import com.kali_corporation.vividcooleditor.tool.gui.GPUImageVignetteFilter;


public class OlivierStrelli extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, BubbleInputDialog.CompleteCallBack {


    private String FinalURI;

    public OlivierStrelli() {
        // Required empty public constructor
    }

    GPUImageView MainGPUImageView;
    public static StickerView sticker_view;

    public static HListView curveList;
    LinearLayout MainMenuContainer;
    RelativeLayout drawing_view_container;

    String flag = "";

    private static int DisplayWidth, DisplayHeight;
    //    text Area Controls
    FrameLayout FrameLayoutText;

    int PrevCurvePosition = 0, PrevBrightness = 50, PrevContrast = 50, PrevSaturation = 50, PrevVignette = 75, PrevSharpness = 50, PrevOpacity = 255;
    ImageView imgTextClose;
    //    Bottom Menu Layout Controls
    LinearLayout LL_Brightness, LL_Contrast, LL_Saturation, LL_Vignette, LL_Sharpness, LL_Text, LL_Curve, LL_AddText, LL_FontStyle, LL_TextColor, LL_TextOpacity;
    public static TextView textbubble;

    public static View MainMenu;
    Boolean textflag = true;
    public static RecyclerView Sticker_recycler_view, Abc_recycler_view, ABCFont;
    SeekBar seekbar;
    public static LinearLayout LL_MainMenu, fragment_Blur, LL_Sticker, LL_Abc, LL_TextMainLayout;
    public static int Counter = 0, AddCounter = 0;
    ImageView ic_clear;
    BubbleInputDialog mBubbleInputDialog;
    List<LizDavenport> filters;

    public static ImageView imgButtonImage, imgReset;

    private Bitmap smallImageBackgroud;


    TextView txtProgressValue;

    // Filter Contols
    GPUImageBrightnessFilter brightnessFilter;
    private DianaVonGrüning.FilterAdjuster mVignetteFilterAdjuster;
    GPUImageContrastFilter contrastFilter;
    GPUImageVignetteFilter vignetteFilter;
    private DianaVonGrüning.FilterAdjuster mBrightnessFilterAdjuster;

    GPUImageSaturationFilter saturationFilter;
    GPUImageToneCurveFilter curveFilter;
    GPUImageFilterGroup filterGroup;
    GPUImageSharpenFilter sharpnessFilter;
    private DianaVonGrüning.FilterAdjuster mContrastFilterAdjuster;
    private DianaVonGrüning.FilterAdjuster mSaturationFilterAdjuster;

    private DianaVonGrüning.FilterAdjuster mSharpnessFilterAdjuster;
    private static RelativeLayout adViewContainer;


    public static RelativeLayout MainContainer;


    private void viewColorPicker() {

        ColorPickerDialogBuilder
                .with(getActivity())
                .setTitle("Border Color")
                .initialColor(Color.parseColor("#ffffff"))
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                        AddTextColor(selectedColor);
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        AddTextColor(selectedColor);
                        if (allColors != null) {
                            StringBuilder sb = null;

                            for (Integer color : allColors) {
                                if (color == null)
                                    continue;
                                if (sb == null)
                                    sb = new StringBuilder("Color List:");
                                sb.append("\r\n#" + Integer.toHexString(color).toUpperCase());
                            }
                        }
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .showColorEdit(true)
                .setColorEditTextColor(ContextCompat.getColor(getActivity(), android.R.color.holo_blue_bright))
                .build()
                .show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (flag) {
            case "Brightness":
                PrevBrightness = progress;
                txtProgressValue.setText("" + PrevBrightness);

                if (mBrightnessFilterAdjuster != null) {
                    mBrightnessFilterAdjuster.adjust(PrevBrightness);
                }
                MainGPUImageView.requestRender();

                break;

            case "Contrast":
                PrevContrast = progress;
                txtProgressValue.setText("" + progress);

                if (mContrastFilterAdjuster != null) {
                    mContrastFilterAdjuster.adjust(PrevContrast);
                }
                MainGPUImageView.requestRender();
                break;

            case "Saturation":
                PrevSaturation = progress;
                txtProgressValue.setText("" + PrevSaturation);

                if (mSaturationFilterAdjuster != null) {
                    mSaturationFilterAdjuster.adjust(PrevSaturation);
                }

                MainGPUImageView.requestRender();

                break;

            case "Vignette":
                PrevVignette = progress;
                txtProgressValue.setText("" + PrevVignette);

                if (mVignetteFilterAdjuster != null) {
                    mVignetteFilterAdjuster.adjust(PrevVignette);
                }

                MainGPUImageView.requestRender();

                break;

            case "Sharpness":
                PrevSharpness = progress;
                txtProgressValue.setText("" + PrevSharpness);

                if (mSharpnessFilterAdjuster != null) {
                    mSharpnessFilterAdjuster.adjust(PrevSharpness);
                }

                MainGPUImageView.requestRender();

                break;

            case "Opacity":
                PrevOpacity = progress;
                txtProgressValue.setText("" + ((PrevOpacity * 100)) / seekBar.getMax() + "%");
                textbubble.setAlpha((float) (seekbar.getProgress()) / (float) (seekBar.getMax()));

                break;
        }
    }


    public void CurveImage() {

        smallImageBackgroud = PatrickCox.BlurBitmap;

        initCurveFilterToolBar();

    }

    public void HeaderControl(View view) {
        imgButtonImage = (ImageView) view.findViewById(R.id.imgButtonImage);
        imgReset = (ImageView) view.findViewById(R.id.imgReset);
        imgReset.setVisibility(View.VISIBLE);
        imgButtonImage.setImageResource(R.drawable.ic_next);
        imgButtonImage.setOnClickListener(this);
        imgReset.setOnClickListener(this);
        TextView txtHeaderName = (TextView) view.findViewById(R.id.txtHeaderName);
//        txtHeaderName.setText("");

        MainContainer = (RelativeLayout) view.findViewById(R.id.MainContainer);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.filters_fragment_shimmer, container, false);


//        End Of FB ADD

        try {
            mContext = getActivity();

            filters = WayneCooper.getInst().getLocalFilters();

            getActivity().setTitle("Filters");

            FindControls(rootView);
            HeaderControl(rootView);

            Display display = getActivity().getWindowManager().getDefaultDisplay();
            DisplayWidth = display.getWidth();
            DisplayHeight = display.getHeight();
            Dabdea.recycler_view.setVisibility(View.GONE);
            RelativeLayout.LayoutParams rparams = new RelativeLayout.LayoutParams(DisplayWidth, DisplayWidth);
            drawing_view_container.setLayoutParams(rparams);

            MainGPUImageView.setImage(PatrickCox.BlurBitmap);

            drawing_view_container.setDrawingCacheEnabled(true);
            drawing_view_container.buildDrawingCache();

            InflateBottomMenuLayout();

            CurveImage();

            setFilters();

        } catch (Exception e) {
            e.printStackTrace();
        }

        adViewContainer = (RelativeLayout) rootView.findViewById(R.id.adViewContainer);

// END OF BANNER

        return rootView;
    }

    //    Initialize the Curve filter
    private void initCurveFilterToolBar() {

        final JohnCrittle adapter = new JohnCrittle(getActivity(), filters, smallImageBackgroud);
        curveList.setAdapter(adapter);
        curveList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (adapter.getSelectFilter() != arg2) {


                    adapter.setSelectFilter(arg2);
                    PrevCurvePosition = arg2;
                    curveFilter.setFromCurveFileInputStream(getResources().openRawResource(filters.get(arg2).getFilterfileRaw()));

                    MainGPUImageView.setFilter(filterGroup);
                    OlivierStrelli.displayAds();
                }
            }
        });
    }

    //    Set Default Filter Values
    private void setFilters() {
        curveFilter = new GPUImageToneCurveFilter();
        curveFilter.setFromCurveFileInputStream(getResources().openRawResource(filters.get(0).getFilterfileRaw()));

        contrastFilter = new GPUImageContrastFilter(1.0f);// Contrast Filter
        mContrastFilterAdjuster = new DianaVonGrüning.FilterAdjuster(contrastFilter);

        brightnessFilter = new GPUImageBrightnessFilter(0f);// Brightness Filter
        mBrightnessFilterAdjuster = new DianaVonGrüning.FilterAdjuster(brightnessFilter);

        saturationFilter = new GPUImageSaturationFilter(1.0f);// Saturation Filter
        mSaturationFilterAdjuster = new DianaVonGrüning.FilterAdjuster(saturationFilter);

        PointF centerPoint = new PointF();
        centerPoint.x = 0.5f;
        centerPoint.y = 0.5f;
        vignetteFilter = new GPUImageVignetteFilter(centerPoint, new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 1.0f);
        mVignetteFilterAdjuster = new DianaVonGrüning.FilterAdjuster(vignetteFilter);

        sharpnessFilter = new GPUImageSharpenFilter(0.0f);// Sharpness Filter
        mSharpnessFilterAdjuster = new DianaVonGrüning.FilterAdjuster(sharpnessFilter);

        filterGroup = new GPUImageFilterGroup();
        filterGroup.addFilter(curveFilter);
        filterGroup.addFilter(contrastFilter);
        filterGroup.addFilter(brightnessFilter);
        filterGroup.addFilter(saturationFilter);
        filterGroup.addFilter(vignetteFilter);
        filterGroup.addFilter(sharpnessFilter);
        MainGPUImageView.setFilter(filterGroup);

    }

    public void InflateBottomMenuLayout() {
        try {

            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            MainMenu = inflater.inflate(R.layout.menu_image_final_shimmer, MainMenuContainer, false);
            MainMenuContainer.addView(MainMenu);

            LL_MainMenu = (LinearLayout) MainMenu.findViewById(R.id.LL_MainMenu);
            fragment_Blur = (LinearLayout) MainMenu.findViewById(R.id.fragment_Blur);

            LL_Brightness = (LinearLayout) MainMenu.findViewById(R.id.LL_Brightness);
            LL_Contrast = (LinearLayout) MainMenu.findViewById(R.id.LL_Contrast);
            LL_Saturation = (LinearLayout) MainMenu.findViewById(R.id.LL_Saturation);
            LL_Vignette = (LinearLayout) MainMenu.findViewById(R.id.LL_Vignette);
            LL_Sharpness = (LinearLayout) MainMenu.findViewById(R.id.LL_Sharpness);
            LL_Text = (LinearLayout) MainMenu.findViewById(R.id.LL_Text);
            LL_Curve = (LinearLayout) MainMenu.findViewById(R.id.LL_Curve);
            LL_Sticker = (LinearLayout) MainMenu.findViewById(R.id.LL_Sticker);
            LL_Abc = (LinearLayout) MainMenu.findViewById(R.id.LL_Abc);
            Sticker_recycler_view = (RecyclerView) MainMenu.findViewById(R.id.Sticker_recycler_view);
            Abc_recycler_view = (RecyclerView) MainMenu.findViewById(R.id.Abc_recycler_view);

            ic_clear = (ImageView) MainMenu.findViewById(R.id.ic_clear);
            seekbar = (SeekBar) MainMenu.findViewById(R.id.seekbar);
            txtProgressValue = (TextView) MainMenu.findViewById(R.id.txtProgressValue);

//            Find TextFragment Controls

            LL_TextMainLayout = (LinearLayout) MainMenu.findViewById(R.id.LL_TextMainLayout);
            LL_AddText = (LinearLayout) MainMenu.findViewById(R.id.LL_AddText);
            LL_FontStyle = (LinearLayout) MainMenu.findViewById(R.id.LL_FontStyle);
            LL_TextColor = (LinearLayout) MainMenu.findViewById(R.id.LL_TextColor);
            LL_TextOpacity = (LinearLayout) MainMenu.findViewById(R.id.LL_TextOpacity);
            ABCFont = (RecyclerView) MainMenu.findViewById(R.id.ABCFont);

            mBubbleInputDialog = new BubbleInputDialog(getActivity());

            AddFontsRecycler();

            LL_Curve.setOnClickListener(this);
            LL_Brightness.setOnClickListener(this);
            LL_Contrast.setOnClickListener(this);
            LL_Saturation.setOnClickListener(this);
            LL_Vignette.setOnClickListener(this);
            LL_Text.setOnClickListener(this);
            ic_clear.setOnClickListener(this);
            LL_Sticker.setOnClickListener(this);
            LL_Abc.setOnClickListener(this);
            LL_AddText.setOnClickListener(this);
            LL_FontStyle.setOnClickListener(this);
            LL_TextColor.setOnClickListener(this);
            LL_TextOpacity.setOnClickListener(this);
            LL_Sharpness.setOnClickListener(this);

            seekbar.setOnSeekBarChangeListener(this);

            mBubbleInputDialog.setCompleteCallBack(this);
            stickerData();
            ABCsData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String saveImageToSD(Bitmap bmp, String filename, Bitmap.CompressFormat format) {
        File file2 = null;
        try {
            String path1 = Environment.getExternalStorageDirectory()
                    .toString();
            FileOutputStream fos = null;
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bmp.compress(format, 100, bytes);
            File file1 = new File(path1 + "/RPMovieFXPhoto/Gallery/");
            if (!file1.exists()) {
                file1.mkdirs();
            }
            file2 = new File(file1, filename);
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos = new FileOutputStream(file2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                fos.write(bytes.toByteArray());
                fos.close();
                Log.e("Success", "Final Image Saved - " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (dia.isShowing()) {
                dia.dismiss();
            }
            PatrickCox.FinalBitmap = bmp;
            FinalURI = "" + path1 + "/RPMovieFXPhoto/Gallery/" + filename;


            ContentValues image = new ContentValues();
            String dateStr = "04/05/2010";

            SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
            Date dateObj = curFormater.parse(dateStr);
            SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");

            String newDateStr = postFormater.format(dateObj);
            image.put(MediaStore.Images.Media.TITLE, filename);
            image.put(MediaStore.Images.Media.DISPLAY_NAME, filename);
            image.put(MediaStore.Images.Media.DESCRIPTION, filename);
            image.put(MediaStore.Images.Media.DATE_ADDED, newDateStr);
            image.put(MediaStore.Images.Media.DATE_TAKEN, "");
            image.put(MediaStore.Images.Media.DATE_MODIFIED, "");
            image.put(MediaStore.Images.Media.MIME_TYPE, "image/*");
            image.put(MediaStore.Images.Media.ORIENTATION, 0);

            File parent = file2.getParentFile();
            String path = parent.toString().toLowerCase();
            String name = parent.getName().toLowerCase();
            image.put(MediaStore.Images.ImageColumns.BUCKET_ID, path.hashCode());
            image.put(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME, name);
            image.put(MediaStore.Images.Media.SIZE, file2.length());

            image.put(MediaStore.Images.Media.DATA, file2.getAbsolutePath());

            Uri result = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, image);


            return file2.getPath().toString();
        } catch (NullPointerException e) {
            // TODO: handle exception
            Log.e("error", "SAve to disk");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return "";
    }

    @Override
    public void onClick(View v) {

        displayAds();
        AddCounter++;
        imgButtonImage.setImageResource(R.drawable.ic_true);
        switch (v.getId()) {

            case R.id.LL_Curve:

                flyOut((View) MainMenu, (View) curveList);
                if (mContrastFilterAdjuster != null) {
                    mContrastFilterAdjuster.adjust(PrevContrast);
                }

                if (mSaturationFilterAdjuster != null) {
                    mSaturationFilterAdjuster.adjust(PrevSaturation);
                }

                if (mVignetteFilterAdjuster != null) {
                    mVignetteFilterAdjuster.adjust(PrevVignette);
                }

                if (mBrightnessFilterAdjuster != null) {
                    mBrightnessFilterAdjuster.adjust(PrevBrightness);
                }
                if (mSharpnessFilterAdjuster != null) {
                    mSharpnessFilterAdjuster.adjust(PrevSharpness);
                }
                MainGPUImageView.requestRender();

                Counter = 1;
                break;

            case R.id.LL_Brightness:

                flyOut((View) LL_MainMenu, (View) fragment_Blur);
                flag = "Brightness";

                seekbar.setProgress(PrevBrightness);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevBrightness);

                Counter = 2;
                break;
            case R.id.LL_Contrast:

                flyOut((View) LL_MainMenu, (View) fragment_Blur);
                flag = "Contrast";

                seekbar.setProgress(PrevContrast);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevContrast);

                Counter = 2;
                break;

            case R.id.LL_Saturation:

                flyOut((View) LL_MainMenu, (View) fragment_Blur);
                flag = "Saturation";

                seekbar.setProgress(PrevSaturation);
                seekbar.setMax(100);
                txtProgressValue.setText("" + PrevSaturation);

                Counter = 2;
                break;

            case R.id.LL_Vignette:

                flyOut((View) LL_MainMenu, (View) fragment_Blur);
                flag = "Vignette";

                seekbar.setProgress(PrevVignette);
                seekbar.setMax(75);
                txtProgressValue.setText("" + PrevVignette);

                Counter = 2;
                break;

            case R.id.LL_Sharpness:

                flyOut((View) LL_MainMenu, (View) fragment_Blur);
                flag = "Sharpness";

                seekbar.setProgress(PrevSharpness);
                seekbar.setMax(50);
                txtProgressValue.setText("" + PrevSharpness);

                Counter = 2;
                break;

//            Bubble text Code
            case R.id.LL_Text:

                flyOut((View) LL_MainMenu, (View) LL_TextMainLayout);
                Counter = 5;

                if (!textbubble.getText().toString().equals("")) {
                    imgTextClose.setVisibility(View.VISIBLE);
                }

                break;

            case R.id.LL_AddText:
                if (!textflag) {
                    FrameLayoutText.setVisibility(View.VISIBLE);
                    textbubble.setText("Hello World");
                    textflag = true;
                } else {
                    mBubbleInputDialog.setBubbleTextView(textbubble);
                    mBubbleInputDialog.show();
                }
                break;

            case R.id.LL_FontStyle:
                flyOut((View) LL_TextMainLayout, (View) ABCFont);
                Counter = 8;
                break;

            case R.id.LL_TextColor:
                viewColorPicker();
                break;

            case R.id.LL_TextOpacity:
                flyOut((View) LL_TextMainLayout, (View) fragment_Blur);
                flag = "Opacity";
                seekbar.setProgress(PrevOpacity);
                seekbar.setMax(255);
                txtProgressValue.setText("" + ((PrevOpacity * 100)) / 255 + "%");
                Counter = 7;
                break;

            case R.id.imgTextClose:
                FrameLayoutText.setVisibility(View.GONE);
                textflag = false;

                break;

            case R.id.LL_Sticker:
                flyOut((View) LL_MainMenu, (View) Sticker_recycler_view);
                Counter = 3;

                break;
            case R.id.LL_Abc:
                flyOut((View) LL_MainMenu, (View) Abc_recycler_view);
                Counter = 4;

                break;

//            End Of text Code

            case R.id.ic_clear:

                switch (flag) {
                    case "Brightness":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;

                    case "Contrast":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;

                    case "Saturation":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;

                    case "Vignette":
                        seekbar.setProgress(75);
                        txtProgressValue.setText("75");
                        break;
                    case "Opacity":
                        seekbar.setProgress(255);
                        PrevOpacity = 255;
                        txtProgressValue.setText("" + ((PrevOpacity * 100)) / 255 + "%");
                        break;
                    case "Sharpness":
                        seekbar.setProgress(50);
                        txtProgressValue.setText("50");
                        break;
                }

                break;

            case R.id.imgButtonImage:
                imgButtonImage.setImageResource(R.drawable.ic_next);
                if (Counter != 0) {
                    if (Counter == 1) {
                        flyOut((View) curveList, (View) MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 2) {
                        flyOut((View) fragment_Blur, (View) LL_MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 3) {
                        flyOut((View) Sticker_recycler_view, (View) LL_MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 4) {

                        flyOut((View) Abc_recycler_view, (View) LL_MainMenu);
                        Counter = 0;
                    }

                    if (Counter == 5) {
                        flyOut((View) LL_TextMainLayout, (View) LL_MainMenu);
                        Counter = 0;
                    }
                    if (Counter == 7) {
                        imgButtonImage.setImageResource(R.drawable.ic_true);
                        flyOut((View) fragment_Blur, (View) LL_TextMainLayout);
                        Counter = 5;
                    }
                    if (Counter == 8) {
                        imgButtonImage.setImageResource(R.drawable.ic_true);
                        flyOut((View) ABCFont, (View) LL_TextMainLayout);
                        Counter = 5;
                    }
                } else {
                    showProgress();
                    mergeAndSave();
                    Intent intent = new Intent(getActivity(), FinishActivity.class);
                    intent.putExtra("FinalURI", FinalURI);
                    startActivity(intent);
                    Dabdea.activity.finish();
                }
                break;

            case R.id.imgReset:
                imgButtonImage.setImageResource(R.drawable.ic_next);

                ((Dabdea) getActivity()).showResetDialog(getActivity(), new LocalBaseActivity.OnResetListner() {
                    @Override
                    public void onReset() {
                        imgButtonImage.setImageResource(R.drawable.ic_true);
                        MainGPUImageView.setImage(PatrickCox.FinalBitmap);
                        PrevCurvePosition = 0;
                        PrevBrightness = 50;
                        PrevContrast = 50;
                        PrevSaturation = 50;
                        PrevSharpness = 50;
                        PrevVignette = 75;
                        setFilters();
                    }
                });

                break;

        }
    }

    public void AddFontsRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        ABCFont.setLayoutManager(layoutManager);
        try {
            ArrayList<SusienChong> arrayList = new ArrayList<>();
            AssetManager assetManager = getActivity().getResources().getAssets();

            String files[] = assetManager.list("fonts");
            if (files != null) {
                for (String file : files) {
                    arrayList.add(new SusienChong("fonts/" + file));
                }

                CathyPill adapter = new CathyPill(arrayList, getActivity());
                ABCFont.setAdapter(adapter);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void FindControls(View view) {
        MainGPUImageView = (GPUImageView) view.findViewById(R.id.MainGPUImageView);
        curveList = (HListView) view.findViewById(R.id.curve_List);
        MainMenuContainer = (LinearLayout) view.findViewById(R.id.toolbar_area);
        drawing_view_container = (RelativeLayout) view.findViewById(R.id.drawing_view_container);
        sticker_view = (StickerView) view.findViewById(R.id.sticker_view);
        FrameLayoutText = (FrameLayout) view.findViewById(R.id.FrameLayoutText);
        imgTextClose = (ImageView) view.findViewById(R.id.imgTextClose);
        textbubble = (TextView) view.findViewById(R.id.textbubble);

        FrameLayoutText.setOnTouchListener(new MultiTouchListener());
        imgTextClose.setOnClickListener(this);


    }


    private void stickerData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        Sticker_recycler_view.setLayoutManager(layoutManager);
        try {
            ArrayList<SusienChong> arrayList = new ArrayList<>();
            AssetManager assetManager = getActivity().getResources().getAssets();

            String files[] = assetManager.list("sticker");
            if (files != null) {
                for (String file : files) {
                    arrayList.add(new SusienChong("sticker/" + file));
                }

                BrunoPieters adapter = new BrunoPieters(arrayList, getActivity());
                Sticker_recycler_view.setAdapter(adapter);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void ABCsData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        Abc_recycler_view.setLayoutManager(layoutManager);
        try {
            ArrayList<SusienChong> arrayList = new ArrayList<>();
            AssetManager assetManager = getActivity().getResources().getAssets();

            String files[] = assetManager.list("abc");
            if (files != null) {
                for (String file : files) {
                    arrayList.add(new SusienChong("abc/" + file));
                }

                MartinMargiela adapter = new MartinMargiela(arrayList, getActivity());
                Abc_recycler_view.setAdapter(adapter);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void AddTextColor(int color) {
        textbubble.setTextColor(color);
    }

    public static void displayAds() {
        if (AddCounter == 2) {

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //    Animation

    private static Context mContext;
    private static Animation animation;

    public static void flyOut(final View view, final View viewFlyIn) {

        animation = AnimationUtils.loadAnimation(mContext, R.anim.bottom_back_fast_holder);
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
                view.setVisibility(View.GONE);
                flyIn(viewFlyIn);
                viewFlyIn.setVisibility(View.VISIBLE);
            }

        });
    }

    private static void flyIn(final View view) {

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
            }

        });

    }

    @Override
    public void onComplete(View bubbleTextView, String str) {
        ((TextView) bubbleTextView).setText(str);
        FrameLayoutText.setVisibility(View.VISIBLE);
    }

    public static void AddSticker(Bitmap bitmap) {
        sticker_view.addSticker(bitmap);
    }

    public static Bitmap merge(Bitmap bitmapmain, Bitmap bitmapback) {

        Bitmap bmOverlay = Bitmap.createBitmap(bitmapback.getWidth(), bitmapback.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmOverlay);

        canvas.drawBitmap(bitmapback, new Matrix(), null);
        canvas.drawBitmap(bitmapmain, 0, 0, null);

        Log.i("TAG", "Image Created");

        return bmOverlay;

    }

    // Save Image Code
    public void mergeAndSave() {

        imgTextClose.setVisibility(View.GONE);
        sticker_view.setLooked(true);

        Bitmap bmOverlay = Bitmap.createBitmap(drawing_view_container.getWidth(), drawing_view_container.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bmOverlay);
        //canvas.drawBitmap(ThirdFinalBitmap, new Matrix(), null);
        canvas.drawBitmap(drawing_view_container.getDrawingCache(), 0, 0, null);
        //canvas.drawBitmap(bitmapframe, 0, 0, null);
        try {
            Bitmap gpubitmap = MainGPUImageView.capture();

            bmOverlay = merge(bmOverlay, gpubitmap);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        saveImageToSD(bmOverlay, "photox_" + generateRandomName(1000000, 5000000) + ".jpg", Bitmap.CompressFormat.JPEG);
        Log.i("TAG", "Image Created");
    }

    private int generateRandomName(int LowerLimit, int UpperLimit) {

        Random r = new Random();
        return r.nextInt((UpperLimit - LowerLimit) + 1) + LowerLimit;
    }

    ProgressDialog dia;

    public void showProgress() {
        //pDialog.show();

        dia = new ProgressDialog(getActivity());
        dia.setMessage("Loading ...");
        dia.setIndeterminate(false);
        dia.setCancelable(false);
        dia.setCanceledOnTouchOutside(false);
        dia.show();
    }


}
