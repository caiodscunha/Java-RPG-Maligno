package org.example.models.itens.itens.dano;

import org.example.models.efeitos.efeitos.EfeitoDano;
import org.example.models.itens.Item;

public class Molotov extends Item {
    public Molotov(int quantidade) {
        super("Molotov", "Causa 20 de dano em um inimigo", new EfeitoDano(20), quantidade);
    }
}
