# Carrinho de Compras

Este projeto é composto por quatro classes Java que implementam um carrinho de compras básico:

1. `CarrinhoCompras`
2. `Item`
3. `Produto`
4. `CarrinhoComprasFactory`

## CarrinhoCompras

Esta classe representa o carrinho de compras de um cliente, possuindo métodos para adicionar, remover itens e calcular o valor total do carrinho.

### Métodos

- `adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade)`: adiciona um novo item ao carrinho de compras.
- `removerItem(Produto produto)`: remove um item do carrinho de compras com base no produto.
- `removerItem(int posicaoItem)`: remove um item do carrinho de compras com base na posição.
- `getValorTotal()`: retorna o valor total do carrinho de compras.
- `getItens()`: retorna a lista de itens do carrinho de compras.

## Item

Esta classe representa um item no carrinho de compras, contendo um produto, um valor unitário e uma quantidade.

### Métodos

- `getProduto()`: retorna o produto do item.
- `getValorUnitario()`: retorna o valor unitário do item.
- `getQuantidade()`: retorna a quantidade do item.
- `getValorTotal()`: retorna o valor total do item (valor unitário multiplicado pela quantidade).

## Produto

Esta classe representa um produto que pode ser adicionado ao carrinho de compras, identificado por um código único.

### Métodos

- `getCodigo()`: retorna o código do produto.
- `getDescricao()`: retorna a descrição do produto.

## CarrinhoComprasFactory

Esta classe é responsável pela criação e recuperação dos carrinhos de compras, mantendo uma lista de carrinhos ativos e fornecendo métodos para criar, obter o valor médio do ticket e invalidar um carrinho de compras.

### Métodos

- `criar(String identificacaoCliente)`: cria um novo carrinho de compras para o cliente identificado ou retorna um carrinho existente.
- `getValorTicketMedio()`: retorna o valor médio do ticket de todos os carrinhos ativos.
- `invalidar(String identificacaoCliente)`: remove o carrinho do cliente identificado.
