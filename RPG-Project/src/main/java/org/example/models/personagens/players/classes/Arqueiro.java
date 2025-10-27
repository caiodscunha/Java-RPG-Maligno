package org.example.models.personagens.players.classes;

import org.example.models.inventario.Inventario;
import org.example.models.itens.itens.cura.PocaoCuraPequena;
import org.example.models.itens.itens.dano.Bomba;
import org.example.models.itens.itens.dano.FacaDeArremeco;
import org.example.models.personagens.personagem.Personagem;
import org.example.models.personagens.players.player.Player;

public class Arqueiro extends Player {


    public Arqueiro(String nome) {
        super(nome, 1,  80, 7, 16);

        this.inventario.adicionarItem(new PocaoCuraPequena(2));
        this.inventario.adicionarItem(new FacaDeArremeco(3));
    }

    @Override
    public String toString() {
        return "Arqueiro | " + super.toString();
    }
}
