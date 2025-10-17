package org.example;

public class Arqueiro extends Personagem{


    public Arqueiro(String nome) {
        super(nome, 70, 1);

        this.ataque = 7;
        this.defensa = 8;
        this.inventario = new Inventario();
    }
}
