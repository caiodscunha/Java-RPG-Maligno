package org.example.models.personagens.players.classes;

import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.dano.Molotov;
import org.example.models.personagens.players.player.Player;

public class Mago extends Player {

    public Mago(String nome) {
        super(nome, 1);

        this.maxPontosVida = 50;
        this.pontosVida = 50;
        this.ataque = 10;
        this.defensa = 7;
        this.inventario.adicionarItem(new PocaoCuraMedia(2));
        this.inventario.adicionarItem(new Molotov(1));
    }

    @Override
    public String toString() {
        return "Mago" + super.toString();
    }
}
