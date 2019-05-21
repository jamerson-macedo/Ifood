package com.jmdevelopers.ifood.model;

public class Food {
      private String nome;
      private String imagem;
      private String descricao;
      private String preco;
      private String desconto;
      private String menuid;

    public Food() {
    }

    public Food(String nome, String imagem, String descricao, String preco, String desconto, String menuid) {
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
        this.preco = preco;
        this.desconto = desconto;
        this.menuid = menuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}
