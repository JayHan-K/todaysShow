package com.example.todaysshow.object;

public class HomeShow {
    private int imageResouce;
    private String showName;

    public HomeShow(int imageResouce, String showName){
        this.imageResouce = imageResouce;
        this.showName = showName;
    }

    public int getImageResouce() {
        return this.imageResouce;
    }
    public String getShowName(){ return this.showName;}
}
