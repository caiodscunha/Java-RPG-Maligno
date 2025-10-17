package org.example.models;

public abstract class Personagem {
    protected String nome;
    protected int pontosVida, maxPontosVida;
    protected int ataque;
    protected int defensa;
    protected int nivel;
    protected Inventario inventario;

    public Personagem(String nome, int maxPontosVida, int nivel) {
        this.nome = nome;
        this.pontosVida = maxPontosVida;
        this.maxPontosVida = maxPontosVida;
        this.nivel = nivel;

    }
}
