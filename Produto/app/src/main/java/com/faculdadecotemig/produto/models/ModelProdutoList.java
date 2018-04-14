package com.faculdadecotemig.produto.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 71600388 on 13/04/2018.
 */

public class ModelProdutoList {

    private List<ModelProduto> list;
    private  boolean success;

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
