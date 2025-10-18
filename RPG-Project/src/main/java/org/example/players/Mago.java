package org.example.players;

import org.example.models.Inventario;
import org.example.models.Personagem;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 1);

        this.maxPontosVida = 50;
        this.pontosVida = 50;
        this.ataque = 10;
        this.defensa = 7;
        this.inventario = new Inventario();
    }

    @Override
    public String toString() {
        return "Mago" + super.toString();
    }
}
