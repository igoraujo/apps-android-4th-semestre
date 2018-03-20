package com.igor.exemploretrofit.model;

/**
 * Created by 71600388 on 19/03/2018.
 */

public class ProdutoModel {

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String imagem;
    private String valor;
    private String nome;

}
