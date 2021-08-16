package com.kali_corporation.vividcooleditor.ui.KayCohen;

public class SusienChong {

    String DirName,FileName;

    public SusienChong(String dirName) {
        DirName = dirName;
    }

    public SusienChong(String dirName, String fileName) {
        DirName = dirName;
        FileName = fileName;
    }

    public String getDirName() {
        return DirName;
    }

    public void setDirName(String dirName) {
        DirName = dirName;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }
}
