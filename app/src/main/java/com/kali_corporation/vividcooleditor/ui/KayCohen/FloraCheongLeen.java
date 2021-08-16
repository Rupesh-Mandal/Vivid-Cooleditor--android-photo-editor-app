package com.kali_corporation.vividcooleditor.ui.KayCohen;

public class FloraCheongLeen {

    String DirName,ImageName;

    public FloraCheongLeen(String imageName) {
        ImageName = imageName;
    }

    public FloraCheongLeen(String dirName, String imageName) {
        DirName = dirName;
        ImageName = imageName;
    }

    public String getDirName() {
        return DirName;
    }

    public void setDirName(String dirName) {
        DirName = dirName;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }
}
