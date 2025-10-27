package org.example.models.personagens.inimigos.inimigo;

import org.example.models.itens.itens.cura.PocaoCuraPequena;
import org.example.models.personagens.personagem.Personagem;

public class Inimigo extends Personagem implements Cloneable{


    public Inimigo(String nome, int nivel, int maxPontosVida, int ataque, int defensa) {
        super(nome, nivel,  maxPontosVida, ataque, defensa);
    }

    public Inimigo(Inimigo inimigo) {
        super(inimigo);
    }

    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*2 + 1);
        this.inventario.adicionarItem(new PocaoCuraPequena(randomChance1));
    }

    public String inimigoAsciiArt(){
        return """
                   _____
                  /     \\
                 | () () |
                  \\  ^  /
                   |||||""";
    }

    public int getDropedXp(){
        return (this.nivel + 2)*10;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Inimigo)) return false;
        Inimigo i = (Inimigo)obj;
        if(!this.nome.equals(i.nome)) return false;
        if(this.nivel != i.nivel) return false;
        if(this.defensa != i.defensa) return false;
        if(this.ataque != i.ataque) return false;
        if(this.pontosVida != i.pontosVida) return false;
        if(this.maxPontosVida != i.maxPontosVida) return false;
        if(!this.inventario.equals(i.inventario)) return false;
        return true;

    }

    @Override
    protected Object clone() {
        Inimigo inimigo = null;
        try {
            inimigo = new Inimigo(this);
        } catch (Exception e) {}
        return inimigo;
    }
}
