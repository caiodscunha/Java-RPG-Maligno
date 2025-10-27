package org.example.models.personagens.players.classes;

import org.example.models.itens.itens.dano.Bomba;
import org.example.models.itens.itens.cura.PocaoCuraPequena;
import org.example.models.personagens.players.player.Player;

public class Guerreiro extends Player {


    public Guerreiro(String nome) {
        super(nome, 1,  100, 5, 18);

        this.inventario.adicionarItem(new PocaoCuraPequena(2));
    }

    @Override
    public String toString() {
        return "Guerreiro | " + super.toString();
    }
}
