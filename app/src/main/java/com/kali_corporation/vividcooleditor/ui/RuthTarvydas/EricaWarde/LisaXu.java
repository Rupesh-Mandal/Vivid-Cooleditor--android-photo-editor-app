package com.kali_corporation.vividcooleditor.ui.RuthTarvydas.EricaWarde;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.kali_corporation.vividcooleditor.ui.DovCharney.DeanandDanCaten;
import com.kali_corporation.vividcooleditor.ui.DovCharney.PatrickCox;
import com.kali_corporation.vividcooleditor.ui.KayCohen.SusienChong;
import com.kali_corporation.vividcooleditor.R;
import com.kali_corporation.vividcooleditor.ui.RuthTarvydas.AhedZanetti.VeroniqueBranquinho;

import java.util.ArrayList;

public class LisaXu extends RecyclerView.Adapter<LisaXu.MyViewHolder> {

    public ArrayList<SusienChong> dataSet;
    private Context mContext;

    DeanandDanCaten appPrefs;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.abc_card_row_photo_filter, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    public LisaXu(ArrayList<SusienChong> data, Context mContext) {
        this.dataSet = data;
        this.mContext = mContext;
        appPrefs = new DeanandDanCaten(mContext);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.imageViewIcon.setTag("" + listPosition);

        holder.imageViewIcon.setImageBitmap(PatrickCox.getBitmapFromAsset(dataSet.get(listPosition).getDirName(), mContext));

        holder.imageViewIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int pos = Integer.parseInt(v.getTag().toString());

                    Bitmap bitmap = PatrickCox.getBitmapFromAsset(dataSet.get(listPosition).getDirName(), mContext);
                    VeroniqueBranquinho.AddSticker(bitmap);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewIcon;
        FrameLayout LL_Progress;


        public MyViewHolder(final View itemView) {
            super(itemView);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imgPIPFramePreview);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}


