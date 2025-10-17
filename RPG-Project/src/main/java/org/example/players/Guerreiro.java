package org.example.players;

import org.example.models.Inventario;
import org.example.models.Personagem;

public class Guerreiro extends Personagem {


    public Guerreiro(String nome) {
        super(nome, 100, 1);

        this.ataque = 5;
        this.defensa = 10;
        this.inventario = new Inventario();
    }

    @Override
    public String toString() {
        return "Guerreiro" + super.toString();
    }
}
