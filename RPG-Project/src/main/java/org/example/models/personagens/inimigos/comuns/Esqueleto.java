package org.example.models.personagens.inimigos.comuns;

import org.example.models.itens.itens.cura.PocaoCuraPequena;
import org.example.models.itens.itens.dano.FacaDeArremeco;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class Esqueleto extends Inimigo {

    public Esqueleto(int nivel) {
        super("Esqueleto", nivel);
        this.maxPontosVida = 20 + 2*nivel;
        this.pontosVida = this.maxPontosVida;
        this.ataque = 8 + nivel;
        this.defensa = 3 + nivel;
        this.inventarioAleatorio();

    }

    @Override
    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*2 + 1);
        int randomChance2 = (int)(Math.random()*2);
        this.inventario.adicionarItem(new PocaoCuraPequena(randomChance1));
        this.inventario.adicionarItem(new FacaDeArremeco(randomChance2));
    }

    public Esqueleto(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
                         _.---._
                       .'       `.
                       :)       (:
                       \\ (@) (@) /
                        \\   A   /
                         )     (
                         \\""\"""/
                          `._.'
                           .=.
                   .---._.-.=.-._.---.
                  / ':-(_.-: :-._)-:` \\""";
    }
}
