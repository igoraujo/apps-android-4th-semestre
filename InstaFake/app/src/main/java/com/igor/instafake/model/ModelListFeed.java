package com.igor.instafake.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 71600388 on 02/04/2018.
 */

public class ModelListFeed {
    @SerializedName("lista")

    private List<ModelFeed> list;

    public List<ModelFeed> getList() {
        return list;
    }

    public void setList(List<ModelFeed> list) {
        this.list = list;
    }
}
