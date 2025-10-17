package org.example.players;

import org.example.models.Inventario;
import org.example.models.Personagem;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 50, 1);

        this.ataque = 10;
        this.defensa = 7;
        this.inventario = new Inventario();
    }
}
