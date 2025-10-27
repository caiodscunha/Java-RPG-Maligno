package org.example.models.personagens.inimigos.comuns;

import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.cura.PocaoCuraPequena;
import org.example.models.itens.itens.dano.FacaDeArremeco;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class Morcego extends Inimigo {

    public Morcego(int nivel) {
        super("Morcego", nivel,  20 + 2*nivel, 4+nivel, 10+nivel);

        this.inventarioAleatorio();

    }

    @Override
    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*2);
        this.inventario.adicionarItem(new PocaoCuraMedia(randomChance1));
        this.inventario.adicionarItem(new PocaoCuraPequena(randomChance1+1));
    }

    public Morcego(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
⠀     ,*-~"`^"*u_                                _u*"^`"~-*,
   p!^       /  jPw                            w9j \\        ^!p
 w^.._      /      "\\_                      _/"     \\        _.^w
      *_   /          \\_      _    _      _/         \\     _*\s
        q /           / \\q   ( `--` )   p/ \\          \\   p
        jj5****._    /    ^\\_) o  o (_/^    \\    _.****6jj
                 *_ /      "==) ;; (=="      \\ _*
                  `/.w***,   /(    )\\   ,***w.\\"
                   ^ ilmk ^c/ )    ( \\c^      ^
                           'V')_)(_('V'
                               `` ``""";
    }
}
