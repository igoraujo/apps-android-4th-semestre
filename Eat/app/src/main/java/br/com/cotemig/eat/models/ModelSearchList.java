package br.com.cotemig.eat.models;

import java.util.List;

/**
 * Created by fourt on 21/05/2018.
 */

public class ModelSearchList {

    private List<ModelSearch> lista;
    private boolean success;

    public List<ModelSearch> getList() {
        return lista;
    }

    public List<ModelSearch> getLista() {
        return lista;
    }

    public void setLista(List<ModelSearch> lista) {
        this.lista = lista;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
