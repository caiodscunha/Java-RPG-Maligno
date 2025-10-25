package org.example.models.efeitos.efeito;

import org.example.models.personagens.personagem.Personagem;

import java.io.Serializable;

public abstract class Efeito implements Serializable {
    public abstract void aplicar(Personagem alvo);
}
