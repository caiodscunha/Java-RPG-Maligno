package org.example.models.personagens.inimigos;

import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class Esqueleto extends Inimigo {

    public Esqueleto(int nivel) {
        super("Esqueleto", nivel);
        this.maxPontosVida = 10 + 2*nivel;
        this.pontosVida = this.maxPontosVida;
        this.ataque = 8 + nivel;
        this.defensa = 1 + nivel;

    }

    public Esqueleto(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
                      .-.
                     (o.o) \s
                      |=|
                     __|__
                   //.=|=.\\\\""";
    }
}
