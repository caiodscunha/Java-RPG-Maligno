package org.example.models.personagens.players.classes;

import org.example.models.inventario.Inventario;
import org.example.models.personagens.personagem.Personagem;
import org.example.models.personagens.players.player.Player;

public class Mago extends Player {

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
