package br.com.cotemig.igor.questao4.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 71600388 on 16/04/2018.
 */

public class ModelList {

    @SerializedName("71600388")
    private List<ModelProva> lista;

    private boolean success;

    public List<ModelProva> getList() {
        return lista;
    }

    public void setLista(List<ModelProva> lista) {
        this.lista = lista;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}
