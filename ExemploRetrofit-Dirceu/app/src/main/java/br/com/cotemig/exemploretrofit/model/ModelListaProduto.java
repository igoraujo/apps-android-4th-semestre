package br.com.cotemig.exemploretrofit.model;

import java.util.List;

/**
 * Created by dirceu on 19/03/2018.
 */

public class ModelListaProduto {

    private List<ModelProduto> lista;
    private boolean sucesso;

    public List<ModelProduto> getLista() {
        return lista;
    }

    public void setLista(List<ModelProduto> lista) {
        this.lista = lista;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
