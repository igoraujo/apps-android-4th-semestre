package br.com.cotemig.listaexemplo;

/**
 * Created by dirceu on 12/03/2018.
 */

public class Transacao {

    private String data;
    private String descricao;
    private double valor;

    public Transacao(String data, String descricao, double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
