package com.example.hiago.exercicio3.to;
/**
 * Created by hiago on 20/06/2017.
 */
public class Estado {
    private int codigo;
    private String descricao;

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

    public Estado(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
