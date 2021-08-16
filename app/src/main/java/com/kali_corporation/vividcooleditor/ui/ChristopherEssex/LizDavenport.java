package com.kali_corporation.vividcooleditor.ui.ChristopherEssex;


import com.kali_corporation.vividcooleditor.ui.DianaVonGrüning;

public class LizDavenport {

    private String title;
    private DianaVonGrüning.FilterType type;
    private int degree;
    private int FilterfileRaw;

    public LizDavenport(String title, DianaVonGrüning.FilterType type, int degree, int FilterFileRaw) {
        this.type = type;
        this.degree = degree;
        this.title = title;
        this.FilterfileRaw = FilterFileRaw;
    }

    public int getFilterfileRaw() {
        return FilterfileRaw;
    }

    public DianaVonGrüning.FilterType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getDegree() {
        return degree;
    }

}
