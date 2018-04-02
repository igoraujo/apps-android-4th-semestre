package com.igor.instafake.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 71600388 on 02/04/2018.
 */

public class ModelUser {
    @SerializedName("user")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
