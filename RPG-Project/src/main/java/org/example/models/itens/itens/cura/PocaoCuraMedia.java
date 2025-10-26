package org.example.models.itens.itens.cura;

import org.example.models.efeitos.efeitos.EfeitoCura;
import org.example.models.itens.Item;

public class PocaoCuraMedia extends Item {

    public PocaoCuraMedia(int quantidade) {
        super("Poção de Cura Média", "Restaura 20 pontos de vida", new EfeitoCura(20), quantidade);
    }
}
