package org.example.models.itens.itens;

import org.example.models.efeitos.efeitos.EfeitoCura;
import org.example.models.itens.Item;

public class PocaoCura extends Item {

    public PocaoCura(int quantidade) {
        super("Poção de Cura", "Restaura 20 pontos de vida", new EfeitoCura(20), quantidade);
    }
}
