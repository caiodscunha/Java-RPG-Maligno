package org.example.models.personagens.inimigos.boss;

import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.dano.Bomba;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class DevoradorDeMundos extends Inimigo {
    public DevoradorDeMundos(int nivel) {
        super("Devorador de Mundos", nivel,  75 + 2*nivel, 8+nivel, 10+nivel);

        this.inventarioAleatorio();

    }

    @Override
    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*2+1);
        int randomChance2 = (int)(Math.random()*2);
        this.inventario.adicionarItem(new PocaoCuraMedia(randomChance1));
        this.inventario.adicionarItem(new Bomba(randomChance2));
    }

    public DevoradorDeMundos(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
                                           **
                                       +  ##  +
                                       *  %%  *
                                       * %##% *
                                    +   %#**#%   +
                                 +   # %#*++*#% #   +
                                   #%#*++****++*#%#
                                +  %#%%*%****%*%%#%  +
                                 #%#%*@#=***=:#@+%#%#
                                   %#%%%*%%%#=%%%#%
                                   %###*+%%%%+*###%
                                    %#+%#%##%#%+#%
                                   %+=%#%=++=%#%=+%
                                  %+=% #      # %=+%
                                   %+=% *    * %=+%
                                   %=%          %=%
                                    %+%        %+%
                                       #      #""";
    }
}



