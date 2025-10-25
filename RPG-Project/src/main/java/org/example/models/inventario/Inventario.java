package org.example.models.inventario;

import org.example.models.itens.Item;
import org.example.models.personagens.personagem.Personagem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Inventario implements Cloneable, Serializable {

    private ArrayList<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public Inventario(Inventario inventario) throws Exception {
        if (inventario == null) {
            throw new Exception("Inventário nulo");
        }
        this.itens = new ArrayList<>();
        for (Item item : inventario.itens) {
            this.itens.add(item.clone());
        }
    }

    public void pilhar(Personagem personagem) throws Exception {
        if (personagem == null) throw new Exception("Personagem nulo");
        Inventario inventario = (Inventario) personagem.getInventario().clone();
        for(Item item: inventario.itens) {
            adicionarItem(item.clone());
            System.out.println("+"+item.getQuantidade()+" "+ item.getNome());
        }
    }

    public void adicionarItem(Item novoItem) {
        if (novoItem.getQuantidade() == 0) {
            return;
        }
        for (Item item : this.itens) {
            if (item.equals(novoItem)) {
                item.adicionarQuantidade(novoItem.getQuantidade());
                return;
            }
        }
        itens.add(novoItem);
        Collections.sort(itens);
    }

    public void usarItem(int index, Personagem alvo) {
        Item item = this.itens.get(index-1);
        item.usar(alvo);

        this.removerItem(index);
    }

    public void removerItem(int index) {
        Item item = this.itens.get(index-1);

        if(item.getQuantidade() == 0) {
            this.itens.remove(index-1);
        }

    }

    public Item buscarItem(int index) {
        return this.itens.get(index-1);
    }

    public boolean isVazio(){
        return this.itens.isEmpty();
    }

    public void listarItens() {
        System.out.println("=== Inventário ===");
        if (this.isVazio()) {
            System.out.println("Nenhum item encontrado!");
            return;
        }

        int i = 1;
        for (Item item : itens) {
            System.out.println("("+i+")" + " " + item.toString());
            i++;
        }

    }

    public int quantidadeItens() {
        return this.itens.size();
    }


    //TODO: Implementar clone
    @Override
    public Inventario clone() {
        Inventario retorno = null;
        try {
            retorno = new Inventario(this);
        } catch (Exception e) {

        }
        return retorno;
    }
}
