package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CarrinhoComprasFactory {

    private Map<String, CarrinhoCompras> carrinhos = new HashMap<>();

    public CarrinhoCompras criar(String identificacaoCliente) {
        if (carrinhos.containsKey(identificacaoCliente)) {
            return carrinhos.get(identificacaoCliente);
        }

        CarrinhoCompras carrinho = new CarrinhoCompras();
        carrinhos.put(identificacaoCliente, carrinho);
        return carrinho;
    }

    public BigDecimal getValorTicketMedio() {
        if (carrinhos.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalValorCarrinhos = BigDecimal.ZERO;
        for (CarrinhoCompras carrinho : carrinhos.values()) {
            totalValorCarrinhos = totalValorCarrinhos.add(carrinho.getValorTotal());
        }

        return totalValorCarrinhos.divide(BigDecimal.valueOf(carrinhos.size()), 2, RoundingMode.HALF_UP);
    }

    public boolean invalidar(String identificacaoCliente) {
        if (!carrinhos.containsKey(identificacaoCliente)) {
            return false;
        }

        carrinhos.remove(identificacaoCliente);
        return true;
    }
}