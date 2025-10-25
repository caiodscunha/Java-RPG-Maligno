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

    @Override
    public String toString() {
        return this.jogador.toString() + " | Ato " + this.gameAct;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        Save s = (Save) obj;
        return this.jogador.equals(s.jogador) && this.gameAct == s.gameAct;
    }

    @Override
    public int hashCode() {
        int retorno = 1;
        retorno = 31 * retorno + this.jogador.hashCode();
        retorno = 31 * retorno + ((Integer)(this.gameAct)).hashCode();

        return (retorno<0) ? -retorno : retorno;
    }
}
