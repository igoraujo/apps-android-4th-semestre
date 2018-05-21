package br.com.cotemig.eat.models;

import java.util.List;

/**
 * Created by fourt on 21/05/2018.
 */

public class ModelDetailList {

    private List<ModelDateail> lista;
    private boolean success;

    public List<ModelDateail> getList() {
        return lista;
    }

    public List<ModelDateail> getLista() {
        return lista;
    }

    public void setLista(List<ModelDateail> lista) {
        this.lista = lista;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
