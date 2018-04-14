package com.example.igor.produto.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Igor on 14/04/2018.
 */

public class ModelList {

    private List<ModelProduto> list;
    private boolean success;

    public List<ModelProduto> getList() {
        return list;
    }

    public void setList(List<ModelProduto> list) {
        this.list = list;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
