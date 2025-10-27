package org.example.models.personagens.inimigos.boss;

import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.dano.Bomba;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class ReiSlime extends Inimigo {
    public ReiSlime(int nivel) {
        super("ReiSlime", nivel);
        this.maxPontosVida = 45 + 2 * nivel;
        this.pontosVida = this.maxPontosVida;
        this.ataque = 5 + nivel;
        this.defensa = 2 + nivel;
        this.inventarioAleatorio();
    }

    @Override
    public void inventarioAleatorio() {
        int randomChance1 = (int) (Math.random() * 2 + 1);
        int randomChance2 = (int) (Math.random() * 2);
        this.inventario.adicionarItem(new PocaoCuraMedia(randomChance1));
        this.inventario.adicionarItem(new Bomba(randomChance2));
    }

    public ReiSlime(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
                                 <>             \s
                               .::::.            \s
                           @\\\\/W\\/\\/W\\//@        \s
                            \\\\/^\\/\\/^\\//    \s
                             \\_O_<>_O_/
                             ⣤⣤⣤⣤⣤⣤⣤⣤⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠀⢀⣠⣤⣤⣾⠟⠛⠛⠛⠛⠛⠛⠛⠻⣦⣤⣤⣄⠀⠀⠀⠀⠀
                    ⠀⠀⣠⣾⡿⠟⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠻⠟⠿⣿⣦⣄⠀⠀⠀
                     ⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣦⣄⠀⠀⠀ ⣠⣼⠀⠀⣿⣿⡇⠀
                     ⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⣿⣿⠀⠀⠀⣯⣿⡇⠀
                     ⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⠇⠀⠀⠀⠿⣿   ⣧⣧⣿⡇⡀
                     ⠿⢿⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⠀⡀⠀⠀⠀⠁⣠⣼⣿⠟⠃
                    ⠀⠀⠿⢷⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣁⣀⣀⣀⣤⣿⠿⠁⠀⠀
                    ⠀⠀⠀⠘⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠁⠁⠀⠀⠀
                """;
    }
}