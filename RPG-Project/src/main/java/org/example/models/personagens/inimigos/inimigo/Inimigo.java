package org.example.models.personagens.inimigos.inimigo;

import org.example.models.itens.itens.PocaoCura;
import org.example.models.personagens.personagem.Personagem;

public class Inimigo extends Personagem implements Cloneable{


    public Inimigo(String nome, int nivel) {
        super(nome, nivel);
    }

    public Inimigo(Inimigo inimigo) {
        super(inimigo);
    }

    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*2 + 1);
        this.inventario.adicionarItem(new PocaoCura(randomChance1));
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
    public Inimigo clone() {
        Inimigo retorno = null;
        try {
            retorno = (Inimigo) super.clone();

        } catch (Exception e) {

        }
        return retorno;
    }
}
