package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class CarrinhoCompras {

    private Collection<Item> itens = new ArrayList<>();

    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
        Objects.requireNonNull(produto, "Produto cannot be null");
        Objects.requireNonNull(valorUnitario, "Value unitario cannot be null");

        for (Item item : itens) {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                item.setValorUnitario(valorUnitario);
                return;
            }
        }

        itens.add(new Item(produto, quantidade, valorUnitario));
    }

    public boolean removerItem(Produto produto) {
        Objects.requireNonNull(produto, "Produto cannot be null");
        return itens.removeIf(item -> item.getProduto().equals(produto));
    }

    public boolean removerItem(int posicaoItem) {
        if (posicaoItem < 0 || posicaoItem >= itens.size()) {
            throw new IndexOutOfBoundsException("Invalid item position");
        }
        itens.remove(posicaoItem);
        return true;
    }

    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : itens) {
            total = total.add(item.getValorTotal());
        }
        return total;
    }

    public Collection<Item> getItens() {
        return Collections.unmodifiableCollection(itens);
    }
}