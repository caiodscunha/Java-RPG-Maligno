package org.example.models.personagens.inimigos;

import org.example.models.personagens.personagem.Personagem;

public class Inimigo extends Personagem implements Cloneable{


    public Inimigo(String nome, int nivel) {
        super(nome, nivel);
    }

    public Inimigo(Inimigo inimigo) {
        super(inimigo);
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
        return (this.nivel + 2);
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
