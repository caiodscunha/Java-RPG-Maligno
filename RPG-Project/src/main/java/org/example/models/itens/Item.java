package org.example.models.itens;

import org.example.models.efeitos.efeito.Efeito;
import org.example.models.efeitos.efeitos.EfeitoCura;
import org.example.models.personagens.personagem.Personagem;
import org.example.models.personagens.players.player.Player;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable {
    private String nome;
    private String descricao;
    private Efeito efeito;
    private int quantidade;

    public Item(String nome, String descricao, Efeito efeito, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.efeito = efeito;
    }

    public Item(Item i) throws Exception{
        if (i == null){
            throw new Exception("Item nulo");
        }
        this.nome = i.getNome();
        this.descricao = i.getDescricao();
        this.efeito = i.getEfeito();
        this.quantidade = i.getQuantidade();
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public Efeito getEfeito() { return efeito; }
    public int getQuantidade() { return quantidade; }

    public void adicionarQuantidade(int valor) {
        this.quantidade += valor;
    }

    public void removerQuantidade(int valor) {
        this.quantidade -= valor;
        if (this.quantidade < 0) this.quantidade = 0;
    }

    public void usar(Personagem alvo) {
        if (alvo == null) return;
        if (alvo instanceof Player && !(efeito instanceof EfeitoCura)) {
            System.out.println("Este item não pode ser usado neste momento...");
        }
        this.efeito.aplicar(alvo);
        this.quantidade = this.quantidade-1;


    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Item)) return false;
        Item outro = (Item) obj;
        return this.nome.equalsIgnoreCase(outro.nome);
    }

    @Override
    public int compareTo(Item outro) {
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.quantidade + ") - " + this.descricao;
    }

    @Override
    public Item clone() {
        Item retono = null;
        try {
            retono = new Item(this);
        } catch (Exception e) {}
        return retono;
    }


}