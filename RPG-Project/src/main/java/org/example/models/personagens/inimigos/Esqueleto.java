package org.example.models.personagens.inimigos;

import org.example.models.itens.itens.Bomba;
import org.example.models.itens.itens.PocaoCura;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class Esqueleto extends Inimigo {

    public Esqueleto(int nivel) {
        super("Esqueleto", nivel);
        this.maxPontosVida = 10 + 2*nivel;
        this.pontosVida = this.maxPontosVida;
        this.ataque = 8 + nivel;
        this.defensa = 1 + nivel;
        this.inventarioAleatorio();

    }

    @Override
    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*3 + 1);
        int randomChance2 = (int)(Math.random()*2);
        this.inventario.adicionarItem(new PocaoCura(randomChance1));
        this.inventario.adicionarItem(new Bomba(randomChance2));
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
