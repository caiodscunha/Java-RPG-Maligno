package org.example.models.itens.itens.cura;

import org.example.models.efeitos.efeitos.EfeitoCura;
import org.example.models.itens.Item;

public class PocaoCuraGrande extends Item {

    public PocaoCuraGrande(int quantidade) {
        super("Poção de Cura Grande", "Restaura 30 pontos de vida", new EfeitoCura(30), quantidade);
    }
}
