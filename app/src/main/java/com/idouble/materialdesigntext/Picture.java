package com.idouble.materialdesigntext;

/**
 * Created by Administrator on 2018/3/23.
 */

public class Picture {

    private String  name;

    private int  imageId;

    public Picture(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

}
