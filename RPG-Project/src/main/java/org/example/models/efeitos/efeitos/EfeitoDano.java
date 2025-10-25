package org.example.models.efeitos.efeitos;

import org.example.models.efeitos.efeito.Efeito;
import org.example.models.personagens.inimigos.inimigo.Inimigo;
import org.example.models.personagens.personagem.Personagem;

public class EfeitoDano extends Efeito {

    private int dano;

    public EfeitoDano(int dano) {
        this.dano = dano;
    }

    @Override
    public void aplicar(Personagem alvo) {
        alvo.aplicarVida(-this.dano);
        System.out.println("Você aplicou " + dano + " de dano!");

    }
}
