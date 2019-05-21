package com.jmdevelopers.ifood.model;

public class Categoria {
    private String imagem;
    private String nome;

    public Categoria() {
    }

    public Categoria(String imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;
    }

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
}
