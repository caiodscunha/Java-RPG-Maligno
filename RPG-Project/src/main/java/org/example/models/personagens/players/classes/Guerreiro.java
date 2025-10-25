package org.example.models.personagens.players.classes;

import org.example.models.inventario.Inventario;
import org.example.models.itens.itens.Bomba;
import org.example.models.itens.itens.PocaoCura;
import org.example.models.personagens.personagem.Personagem;
import org.example.models.personagens.players.player.Player;

public class Guerreiro extends Player {


    public Guerreiro(String nome) {
        super(nome, 1);

        this.maxPontosVida = 100;
        this.pontosVida = 100;
        this.ataque = 5;
        this.defensa = 10;
        this.inventario.adicionarItem(new PocaoCura(2));
        this.inventario.adicionarItem(new Bomba(3));
    }

    @Override
    public String toString() {
        return "Guerreiro" + super.toString();
    }
}
