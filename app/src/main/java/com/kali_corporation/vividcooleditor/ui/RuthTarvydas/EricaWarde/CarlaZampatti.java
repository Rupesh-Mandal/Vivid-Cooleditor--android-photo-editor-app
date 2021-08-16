package com.kali_corporation.vividcooleditor.ui.RuthTarvydas.EricaWarde;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kali_corporation.vividcooleditor.ui.KayCohen.SusienChong;
import com.kali_corporation.vividcooleditor.R;
import com.kali_corporation.vividcooleditor.ui.RuthTarvydas.AhedZanetti.VeroniqueBranquinho;

import java.util.ArrayList;


public class CarlaZampatti extends RecyclerView.Adapter<CarlaZampatti.MyViewHolder> {

    public static ArrayList<SusienChong> fontsaArrayList;
    private static Context mContext;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.font_adapter, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    public CarlaZampatti(ArrayList<SusienChong> data, Context mContext) {
        this.fontsaArrayList = data;
        this.mContext = mContext;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.txtfonts);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int possion = Integer.parseInt(v.getTag().toString());

                    try {
                        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), fontsaArrayList.get(possion).getDirName());
                        VeroniqueBranquinho.textbubble.setTypeface(typeface);
                        VeroniqueBranquinho.displayAds();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.textView.setTag("" + listPosition);
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), fontsaArrayList.get(listPosition).getDirName());
        holder.textView.setTypeface(typeface);
        holder.textView.setText("Abcd");
//        holder.textView.setText(Main2Activity.textView.getText().toString());

    }

    @Override
    public int getItemCount() {
        return fontsaArrayList.size();
    }
}
