package org.example.models.itens.itens;

import org.example.models.efeitos.efeitos.EfeitoCura;
import org.example.models.efeitos.efeitos.EfeitoDano;
import org.example.models.itens.Item;

public class Bomba extends Item {
    public Bomba(int quantidade) {
        super("Bomba", "Causa 10 de dano em um inimigo", new EfeitoDano(20), quantidade);
    }
}
