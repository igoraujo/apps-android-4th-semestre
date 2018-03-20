package com.igor.exemploretrofit.model;

import java.util.List;

/**
 * Created by 71600388 on 19/03/2018.
 */

public class ListaProdutoModel {

    public List<ProdutoModel> getLista() {
        return lista;
    }

    public void setLista(List<ProdutoModel> lista) {
        this.lista = lista;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    private List<ProdutoModel> lista;
    private boolean sucesso;

}
