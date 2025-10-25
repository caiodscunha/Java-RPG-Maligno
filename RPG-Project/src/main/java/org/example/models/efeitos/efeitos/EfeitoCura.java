package org.example.models.efeitos.efeitos;

import org.example.models.efeitos.efeito.Efeito;
import org.example.models.personagens.personagem.Personagem;

public class EfeitoCura extends Efeito implements Comparable<EfeitoCura>{
    private int cura;

    public EfeitoCura(int cura) {
        this.cura = cura;
    }

    @Override
    public void aplicar(Personagem alvo) {
        alvo.aplicarVida(this.cura);
        System.out.println("Você recuperou " + cura + " pontos de vida!");
    }

    @Override
    public int compareTo(EfeitoCura o) {
        if (this.cura < o.cura) return -1;
        if (this.cura > o.cura) return 1;
        return 0;
    }

    @Override
    public int hashCode() {
        int retorno = 1;
        retorno = retorno * 7 + ((Integer)(this.cura)).hashCode();

        return (retorno<0) ? -retorno : retorno;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        return this.cura == ((EfeitoCura)obj).cura;
    }

    @Override
    public String toString() {
        return "EfeitoCura{" + "cura=" + this.cura + '}';
    }
}
