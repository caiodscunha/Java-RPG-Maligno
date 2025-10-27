package org.example.models.personagens.inimigos.boss;

import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.dano.Bomba;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class Skeleton extends Inimigo {
    public Skeleton(int nivel) {
        super("Skeleton", nivel);
        this.maxPontosVida = 100 + 2 * nivel;
        this.pontosVida = this.maxPontosVida;
        this.ataque = 10 + nivel;
        this.defensa = 2 + nivel;
        this.inventarioAleatorio();
    }

    @Override
    public void inventarioAleatorio() {
        int randomChance1 = (int)(Math.random() * 2 + 1);
        int randomChance2 = (int)(Math.random() * 2);
        this.inventario.adicionarItem(new PocaoCuraMedia(randomChance1));
        this.inventario.adicionarItem(new Bomba(randomChance2));
    }

    public Skeleton(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
                ⠀⠀⠀⠀⠀              .7
                                  .'/
                                 / /
                                / /
                               / /
                              / /        \s
                             / /         \s
                           __|/
                         ,-\\__\\
                         |f-"Y\\|
                         \\()7L/
                          cgD                            __ _
                          |\\(                          .'  Y '>,
                           \\ \\                        / _   _   \\
                            \\\\\\                       )(_) (_)(|}
                             \\\\\\                      {  4A   } /
                              \\\\\\                      \\uLuJJ/\\l
                               \\\\\\                     |3    p)/
                                \\\\\\___ __________      /nnm_n//
                                c7___-__,__-)\\,__)(".  \\_>-<_/D
                                           //V     \\_"-._.__G G_c__.-__<"/ ( \\
                                                  <"-._>__-,G_.___)\\   \\7\\
                                                 ("-.__.| \\"<.__.-" )   \\ \\
                                                 |"-.__"\\  |"-.__.-".\\   \\ \\
                                                 ("-.__"". \\"-.__.-".|    \\_\\ """;
    }
}
