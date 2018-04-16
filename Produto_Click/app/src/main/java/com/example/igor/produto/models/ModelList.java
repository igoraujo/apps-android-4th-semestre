package com.example.igor.produto.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Igor on 14/04/2018.
 */

public class ModelList {

    private List<ModelProduto> lista;
    private boolean success;

    public List<ModelProduto> getList() {
        return lista;
    }

    public void setLista(List<ModelProduto> lista) {
        this.lista = lista;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
