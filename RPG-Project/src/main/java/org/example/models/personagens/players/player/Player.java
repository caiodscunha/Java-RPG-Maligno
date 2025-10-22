package org.example.models.personagens.players.player;

import org.example.models.personagens.personagem.Personagem;

import java.io.Serializable;

public class Player extends Personagem implements Serializable {

    protected int xp;
    protected int xpToNextLevel;

    public Player(String nome, int nivel) {
        super(nome, nivel);
        this.xp = 0;
        this.xpToNextLevel = 10;
    }

    public Player(Player p){
        super(p);

        this.xp = p.xp;
        this.xpToNextLevel = p.xpToNextLevel;

    }

    public void upar(int xp){
        int tempXp = this.xp + xp;

        while (tempXp >= this.xpToNextLevel){
            tempXp = tempXp - this.xpToNextLevel;
            this.nivel++;
            this.xpToNextLevel += (int)nivel/2*5;
        }

        this.xp = tempXp;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | " + "xp: " + this.xp + "/" + this.xpToNextLevel;
    }

}
