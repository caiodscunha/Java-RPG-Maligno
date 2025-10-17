package org.example;

public class Mago extends Personagem{

    public Mago(String nome) {
        super(nome, 50, 1);

        this.ataque = 10;
        this.defensa = 7;
        this.inventario = new Inventario();
    }
}
