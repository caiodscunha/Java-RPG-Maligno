package org.example.models.personagens.inimigos.comuns;

import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.dano.Bomba;
import org.example.models.itens.itens.dano.FacaDeArremeco;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class Aranha extends Inimigo {

    public Aranha(int nivel) {
        super("Aranha", nivel);
        this.maxPontosVida = 25 + 2*nivel;
        this.pontosVida = this.maxPontosVida;
        this.ataque = 10 + nivel;
        this.defensa = 2 + nivel;
        this.inventarioAleatorio();

    }

    @Override
    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*2+1);
        int randomChance2 = (int)(Math.random()*2);
        this.inventario.adicionarItem(new PocaoCuraMedia(randomChance1));
        this.inventario.adicionarItem(new Bomba(randomChance2));
    }

    public Aranha(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
⠀⠀⠀⠀⠀⠀⠀⠀⠀        /\\  .-""\"-.  /\\
                //\\\\/  ,,,  \\//\\\\
                |/\\| ,;;;;;, |/\\|
                //\\\\\\;-""\"-;///\\\\
               //  \\/   .   \\/  \\\\
              (| ,-_| \\ | / |_-, |)
                //`__\\.-.-./__`\\\\
               // /.-(() ())-.\\ \\\\
              (\\ |)   '---'   (| /)
               ` (|           |) `
                 \\)           (/""";
    }
}
