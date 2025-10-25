package org.example.models.efeitos.efeitos;

import org.example.models.efeitos.efeito.Efeito;
import org.example.models.personagens.personagem.Personagem;

public class EfeitoCura extends Efeito {
    private int cura;

    public EfeitoCura(int cura) {
        this.cura = cura;
    }

    @Override
    public void aplicar(Personagem alvo) {
        alvo.aplicarVida(this.cura);
        System.out.println("Você recuperou " + cura + " pontos de vida!");
    }
}
