package org.example.models.itens;

import org.example.models.efeitos.efeito.Efeito;

import java.io.Serializable;

public abstract class Item implements Serializable {
    protected String nome;
    protected String descricao;
    protected Efeito efeito;
    protected int quantidade;

    public Item(String nome, String descricao, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void usarItem(){
        if(this.quantidade <= 0){
            System.out.println("Você não tem " + this.nome + " no inventário...");
            return;
        }
        this.quantidade--;

    }


}