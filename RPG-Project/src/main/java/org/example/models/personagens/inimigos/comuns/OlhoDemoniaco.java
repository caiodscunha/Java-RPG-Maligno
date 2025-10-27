package org.example.models.personagens.inimigos.comuns;

import org.example.models.itens.itens.cura.PocaoCuraGrande;
import org.example.models.itens.itens.cura.PocaoCuraMedia;
import org.example.models.itens.itens.cura.PocaoCuraPequena;
import org.example.models.personagens.inimigos.inimigo.Inimigo;

public class OlhoDemoniaco extends Inimigo {

    public OlhoDemoniaco(int nivel) {
        super("Olho Demoníaco", nivel,  20 + 2*nivel, 5+nivel, 12+nivel);

        this.inventarioAleatorio();

    }

    @Override
    public void inventarioAleatorio(){
        int randomChance1 = (int)(Math.random()*2);
        this.inventario.adicionarItem(new PocaoCuraMedia(randomChance1+1));
        this.inventario.adicionarItem(new PocaoCuraGrande(randomChance1));
    }

    public OlhoDemoniaco(Inimigo inimigo) {
        super(inimigo);
    }

    @Override
    public String inimigoAsciiArt() {
        return """
                                            __..---`___..---`
                                   _...--.-`   _.--`
                               _.-`.-`.-`  _.-`
                            .-` .`  .`   .`
                 .         /   /   /    /                    .
                 \\`-.._    |  |    \\    `.              _..-`/
                .'-.._ ``--.._\\     `. -- `.      _..-``  _..-`.
                `_    _       `-. .`        `. .-`      _    _`
                  `.``           .            \\          ``.`
                   `-.-'    _   .              :   _   `-.-`
                     `..-..'    ;       .` `.  '    `..-..`
                         /      .      : .-. : :        \\
                         `._     \\     ;( O ) /      _.`
                            `-._.'`.    .`-'.' `._.-'
                                    `-....-`""";
    }
}
