package br.com.cotemig.instagramfake.model;

import java.util.List;

/**
 * Created by 71600388 on 26/03/2018.
 */

public class ModelPost {

    private String data;
    private String imagem;
    private String descricao;
    private List<ModelUsuario> likes;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ModelUsuario> getLikes() {
        return likes;
    }

    public void setLikes(List<ModelUsuario> likes) {
        this.likes = likes;
    }
}
