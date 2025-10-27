package org.example.models.personagens.players.classes;

import org.example.models.itens.itens.dano.Bomba;
import org.example.models.itens.itens.cura.PocaoCuraPequena;
import org.example.models.personagens.players.player.Player;

public class Guerreiro extends Player {


    public Guerreiro(String nome) {
        super(nome, 1);

        this.maxPontosVida = 100;
        this.pontosVida = 100;
        this.ataque = 150;
        this.defensa = 10;
        this.inventario.adicionarItem(new PocaoCuraPequena(2));
    }

    @Override
    public String toString() {
        return "Guerreiro" + super.toString();
    }
}
