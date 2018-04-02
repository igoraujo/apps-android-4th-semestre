package com.example.hiago.exercicio3.to;

/**
 * Created by hiago on 20/06/2017.
 */
public class Cidade {
    private int codigoEstado;
    private int codigo;
    private String descricao;

    public Cidade(int codigoEstado, int codigo, String descricao) {
        this.codigoEstado = codigoEstado;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
