package org.example.models.personagens.inimigos.boss;

import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.dano.Bomba;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class OlhoDoCthulhu extends Inimigo {
    public OlhoDoCthulhu(int nivel) {
        super("OlhoDoCthulhu", nivel);
        this.maxPontosVida = 55 + 2 * nivel;
        this.pontosVida = this.maxPontosVida;
        this.ataque = 7 + nivel;
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

    public OlhoDoCthulhu(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
                ⠀⠀⠀
                                 :=-:                         \s
                           @@=====+====%%@@                # =\s
                        @=====%%%%#= %%#  #%%*    **   %--    \s
                      @=====%==         -#   %*#     #=       \s
                     @+%@.@@##  +  #            ##%           \s
                    @#% @%+# @@#=--   -    +-*# -#%#*#:     - \s
                       %@  @@ #%*@+  *    #    *%###%         \s
                       +  @#  *@=%%.   :..#####  -####        \s
                              -  #@*#  *-*       #-##%     ## \s
                       +  %@ @%-:%%-      -    #-#=###-:      \s
                       %@ %+  %#@@*   **---##-  -##-%         \s
                    @% @#@@%@ %@#        -  -    ##-: +# ##   \s
                     %+@@@%%-*  -    -=.        -#%           \s
                      @#::::::.::.:**#:-%==#######   %#=----  \s
                         @::::...........--#@                 \s
                              @@@::..@@@                      \s⠀⠀⠀⠀⠀⠀
                """;
    }
}
