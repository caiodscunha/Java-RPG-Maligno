package org.example.models.personagens.players.classes;

import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.dano.Molotov;
import org.example.models.personagens.players.player.Player;

public class Mago extends Player {

    public Mago(String nome) {
        super(nome, 1,  60, 9, 15);

        this.inventario.adicionarItem(new PocaoCuraMedia(2));
        this.inventario.adicionarItem(new Molotov(1));
    }

    @Override
    public String toString() {
        return "Mago | " + super.toString();
    }
}
