package org.example.models.personagens.personagem;

import org.example.models.inventario.Inventario;
import org.example.models.itens.Item;

import java.io.Serializable;

public abstract class Personagem implements Cloneable, Serializable {
    protected String nome;
    protected int pontosVida, maxPontosVida;

    protected int ataque;
    protected int defensa;

    protected int nivel;

    protected Inventario inventario;

    public Personagem(String nome, int nivel, int maxPontosVida, int ataque, int defensa) {
        this.nome = nome;
        this.pontosVida = maxPontosVida;
        this.maxPontosVida = maxPontosVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        this.inventario = new Inventario();
    }

    public Personagem(Personagem personagem) {
        this.nome = personagem.nome;
        this.pontosVida = personagem.pontosVida;
        this.maxPontosVida = personagem.maxPontosVida;
        this.ataque = personagem.ataque;
        this.defensa = personagem.defensa;
        this.nivel = personagem.nivel;
        this.inventario = personagem.inventario.clone();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public int getNivel(){
        return this.nivel;
    }

    public boolean isVivo(){
        return this.pontosVida > 0;
    }

    public int rolarAtaque(){
        return this.ataque + ((int)(Math.random()*20 + 1));
    }

    public void tomarDano(Personagem personagem) {
        int ataque = personagem.rolarAtaque();
        int dano = ataque - this.defensa;

        if(dano <= 0) {
            System.out.println(this.nome + " desviou do ataque...");
            return;
        }
        System.out.println(this.nome + " tomou "+ dano +" de dano...");

        this.pontosVida = (dano > this.pontosVida) ? 0 : this.pontosVida - dano;

    }

    public void aplicarVida(int vida){
        int variacaoVida = this.pontosVida + vida;

        if(variacaoVida <= 0){
            this.pontosVida = 0;
            return;
        }

        if(variacaoVida > this.maxPontosVida){
            this.pontosVida = this.maxPontosVida;
            return;
        }

        this.pontosVida = variacaoVida;

    }

    @Override
    public String toString() {
        String nomeFormatado = this.nome.replaceAll("([a-z])([A-Z])", "$1 $2");

        return nomeFormatado + " | "
                + "HP: " + this.pontosVida + "/" + this.maxPontosVida
                + " | LV: " + this.nivel;
    }

    @Override
    public int hashCode() {
        int retorno = 1;
        retorno = retorno * 7 + this.nome.hashCode();
        retorno = retorno * 7 + ((Integer)this.pontosVida).hashCode();
        retorno = retorno * 7 + ((Integer)this.maxPontosVida).hashCode();
        retorno = retorno * 7 + ((Integer)this.ataque).hashCode();
        retorno = retorno * 7 + ((Integer)this.defensa).hashCode();
        retorno = retorno * 7 + ((Integer)this.nivel);
        retorno = retorno * 7 + this.inventario.hashCode();

        return (retorno<0) ? -retorno : retorno;
    }

}
