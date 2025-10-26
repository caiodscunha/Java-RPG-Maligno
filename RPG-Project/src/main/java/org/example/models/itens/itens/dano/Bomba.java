package org.example.models.itens.itens.dano;

import org.example.models.efeitos.efeitos.EfeitoDano;
import org.example.models.itens.Item;

public class Bomba extends Item {
    public Bomba(int quantidade) {
        super("Bomba", "Causa 30 de dano em um inimigo", new EfeitoDano(30), quantidade);
    }
}
