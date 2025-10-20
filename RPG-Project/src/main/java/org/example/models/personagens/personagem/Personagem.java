package org.example.models.personagens.personagem;

import org.example.models.inventario.Inventario;
import org.example.models.personagens.inimigos.Inimigo;

public abstract class Personagem {
    protected String nome;
    protected int pontosVida, maxPontosVida;

    protected int ataque;
    protected int defensa;

    protected int nivel;

    protected Inventario inventario;

    public Personagem(String nome, int nivel) {
        this.nome = nome;
        this.pontosVida = 1;
        this.maxPontosVida = 1;
        this.nivel = nivel;
    }

    public int getNivel(){
        return this.nivel;
    }

    public boolean isVivo(){
        return this.pontosVida > 0;
    }

    public int rolarAtaque(){
        return this.ataque + ((int)(Math.random()*4));
    }

    public void tomarDano(Personagem personagem){
        int ataque = personagem.rolarAtaque();
        int dano = ataque - this.defensa;

        if(dano <= 0) return;

        this.pontosVida = (dano > this.pontosVida) ? 0 : this.pontosVida - dano;

    }

    @Override
    public String toString() {
        return " | " + this.nome + " | "
                + "hp: " + this.pontosVida + "/" + this.maxPontosVida + " | " + "lv: " + this.nivel;
    }
}
