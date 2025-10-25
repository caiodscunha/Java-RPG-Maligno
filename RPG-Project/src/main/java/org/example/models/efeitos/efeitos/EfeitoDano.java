package org.example.models.efeitos.efeitos;

import org.example.models.efeitos.efeito.Efeito;
import org.example.models.personagens.inimigos.inimigo.Inimigo;
import org.example.models.personagens.personagem.Personagem;

public class EfeitoDano extends Efeito implements Comparable<EfeitoDano>{

    private int dano;

    public EfeitoDano(int dano) {
        this.dano = dano;
    }

    @Override
    public void aplicar(Personagem alvo) {
        alvo.aplicarVida(-this.dano);
        System.out.println("Você aplicou " + dano + " de dano!");

    }

    @Override
    public int compareTo(EfeitoDano o) {
        if (this.dano < o.dano) return -1;
        if (this.dano > o.dano) return 1;
        return 0;
    }

    @Override
    public int hashCode() {
        int retorno = 1;
        retorno = retorno * 7 + ((Integer)(this.dano)).hashCode();

        return (retorno<0) ? -retorno : retorno;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        return this.dano == ((EfeitoDano)obj).dano;
    }

    @Override
    public String toString() {
        return "EfeitoDano{" + "dano=" + this.dano + '}';
    }
}
