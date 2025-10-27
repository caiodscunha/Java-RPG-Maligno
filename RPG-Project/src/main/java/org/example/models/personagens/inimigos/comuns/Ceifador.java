package org.example.models.personagens.inimigos.comuns;

import org.example.models.itens.itens.dano.Bomba;
import org.example.models.itens.itens.dano.Molotov;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class Ceifador extends Inimigo {

    public Ceifador(int nivel) {
        super("Ceifador", nivel,  30 + 2*nivel, 9+nivel, 11+nivel);

        this.inventarioAleatorio();

    }

    @Override
    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*2+1);
        this.inventario.adicionarItem(new Molotov(randomChance1));
    }

    public Ceifador(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
                                          .""--.._
                                          []      `'--.._
                                          ||__           `'-,
                                        `)||_ ```'--..       \\
                    _                    /|//}        ``--._  |
                 .'` `'.                /////}              `\\/
                /  .""\".\\              //{///   \s
               /  /_  _`\\\\            // `||
               | |(_)(_)||          _//   ||
               | |  /\\  )|        _///\\   ||
               | |L====J |       / |/ |   ||
              /  /'-..-' /    .'`  \\  |   ||
             /   |  :: | |_.-`      |  \\  ||
            /|   `\\-::.| |          \\   | ||""";
    }
}
