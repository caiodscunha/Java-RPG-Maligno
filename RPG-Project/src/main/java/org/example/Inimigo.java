package org.example;

public class Inimigo extends Personagem{

    public Inimigo(String nome, int maxPontosVida, int nivel, int defensa, int ataque, Inventario inventario) {
        super(nome, maxPontosVida, nivel);

        this.ataque = ataque;
        this.defensa = defensa;
        this.inventario = inventario;
    }
}
