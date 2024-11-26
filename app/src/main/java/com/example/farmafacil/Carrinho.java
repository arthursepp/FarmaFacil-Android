package com.example.farmafacil;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private static List<ItemCarrinho> itens = new ArrayList<>();

    public static void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemCarrinho(produto, quantidade));
    }

    public static void removerItem(int position) {
        if (position >= 0 && position < itens.size()) {
            itens.remove(position);
        }
    }

    public static List<ItemCarrinho> getItens() {
        return itens;
    }
}