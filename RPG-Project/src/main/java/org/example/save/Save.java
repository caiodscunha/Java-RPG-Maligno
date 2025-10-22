package org.example.save;

import org.example.models.personagens.players.player.Player;

import java.io.Serializable;

public class Save implements Serializable {
    private Player jogador;
    private int gameAct;

    public Save(Player jogador, int gameAct) {
        this.jogador = jogador;
        this.gameAct = gameAct;
    }

    public Save() {}

    public Player getJogador() { return jogador; }
    public int getGameAct() { return gameAct; }

}
