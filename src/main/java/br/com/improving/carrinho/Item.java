package br.com.improving.carrinho;

import java.math.BigDecimal;

public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidadeidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
