package com.example.lerning_recycler_v_ew;

import android.widget.Button;

public class ExampleItem {
    private String imageurl,Creator;
    private  int likec;
    private Button btn;

    public String getPageUrl() {
        return pageUrl;
    }

    private String pageUrl;
    public  ExampleItem(String imageurl,String Creator,int likec,Button btn,String url){
        this.Creator=Creator;
        this.imageurl=imageurl;
        this.likec=likec;
        this.pageUrl=url;

    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public int getLikec() {
        return likec;
    }

    public void setLikec(int likec) {
        this.likec = likec;
    }
    public Button getBtn(){
        return btn;
    }



}
