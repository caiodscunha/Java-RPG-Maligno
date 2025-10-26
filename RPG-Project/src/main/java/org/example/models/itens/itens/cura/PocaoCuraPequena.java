package org.example.models.itens.itens.cura;

import org.example.models.efeitos.efeitos.EfeitoCura;
import org.example.models.itens.Item;

public class PocaoCuraPequena extends Item {

    public PocaoCuraPequena(int quantidade) {
        super("Poção de Cura Pequena", "Restaura 10 pontos de vida", new EfeitoCura(10), quantidade);
    }
}
