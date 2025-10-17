package org.example.players;

import org.example.models.Inventario;
import org.example.models.Personagem;

public class Arqueiro extends Personagem {


    public Arqueiro(String nome) {
        super(nome, 70, 1);

        this.ataque = 7;
        this.defensa = 8;
        this.inventario = new Inventario();
    }

    @Override
    public String toString() {
        return "Arqueiro" + super.toString();
    }
}
