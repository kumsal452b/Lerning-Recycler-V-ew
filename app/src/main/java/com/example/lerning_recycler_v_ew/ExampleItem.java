package com.example.lerning_recycler_v_ew;

public class ExampleItem {
    private String imageurl,Creator;
    private  int likec;

    public  ExampleItem(String imageurl,String Creator,int likec){
        this.Creator=Creator;
        this.imageurl=imageurl;
        this.likec=likec;
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



}
