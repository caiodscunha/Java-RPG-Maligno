package org.example.models.personagens.players.classes;

import org.example.models.inventario.Inventario;
import org.example.models.personagens.personagem.Personagem;
import org.example.models.personagens.players.player.Player;

public class Arqueiro extends Player {


    public Arqueiro(String nome) {
        super(nome, 1);

        this.pontosVida = 70;
        this.maxPontosVida = 70;
        this.ataque = 7;
        this.defensa = 8;
        this.inventario = new Inventario();
    }

    @Override
    public String toString() {
        return "Arqueiro" + super.toString();
    }
}
