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
            this.maxPontosVida = this.maxPontosVida + 3;
            this.ataque++;
            this.defensa++;
        }
        this.pontosVida = this.maxPontosVida;
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

    @Override
    public int hashCode() {
        int retorno = super.hashCode();
        retorno = retorno * 7 + ((Integer)(this.xp)).hashCode();
        retorno = retorno * 7 + ((Integer)(this.xpToNextLevel)).hashCode();
        return (retorno<0) ? -retorno : retorno;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Player)) return false;
        Player p = (Player)obj;
        if(!this.nome.equals(p.nome)) return false;
        if(this.xp != p.xp) return false;
        if(this.xpToNextLevel != p.xpToNextLevel) return false;
        if(this.nivel != p.nivel) return false;
        if(this.defensa != p.defensa) return false;
        if(this.ataque != p.ataque) return false;
        if(this.pontosVida != p.pontosVida) return false;
        if(this.maxPontosVida != p.maxPontosVida) return false;
        if(!this.inventario.equals(p.inventario)) return false;
        return true;

    }

    @Override
    protected Object clone() {
        Personagem player = null;
        try {
            player = new Player(this);
        } catch (Exception e) {}
        return player;
    }

}
