package br.com.cotemig.exemploretrofit.model;

/**
 * Created by dirceu on 19/03/2018.
 */

public class ModelProduto { //implements Serializable {

    //@SerializedName("imagem_produto")
    private String imagem;
    private String nome;
    private double valor;

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
