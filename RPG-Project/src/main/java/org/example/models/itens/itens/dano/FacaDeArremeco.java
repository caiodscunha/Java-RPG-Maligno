package org.example.models.itens.itens.dano;

import org.example.models.efeitos.efeitos.EfeitoDano;
import org.example.models.itens.Item;

public class FacaDeArremeco extends Item {
    public FacaDeArremeco(int quantidade) {
        super("Faca de Arremeço", "Causa 10 de dano em um inimigo", new EfeitoDano(10), quantidade);
    }
}
