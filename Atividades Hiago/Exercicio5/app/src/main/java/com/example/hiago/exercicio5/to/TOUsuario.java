package com.example.hiago.exercicio5.to;

/**
 * Created by hiago on 20/06/2017.
 */
public class TOUsuario extends TOBase {

    private String nome;
    private String sobrenome;
    private String avatar;
    private Boolean sucesso;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public TOUsuario() {
    }

}
