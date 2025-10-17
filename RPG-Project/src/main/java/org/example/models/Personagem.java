package org.example.models;

public abstract class Personagem {
    protected String nome;
    protected int pontosVida, maxPontosVida;

    protected int ataque;
    protected int defensa;

    protected int nivel;
    protected int xp;
    protected int xpToNextLevel;

    protected Inventario inventario;

    public Personagem(String nome, int maxPontosVida, int nivel) {
        this.nome = nome;
        this.pontosVida = maxPontosVida;
        this.maxPontosVida = maxPontosVida;
        this.nivel = nivel;
        this.xpToNextLevel = 10;
        this.xp = 0;

    }

    @Override
    public String toString() {
        return " | " + this.nome + " | "
                + "hp: " + this.pontosVida + "/" + this.maxPontosVida + " | " + "lv: " + this.nivel +
                " | " + "xp: " + this.xp + "/" + this.xpToNextLevel;
    }
}
