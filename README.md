### Cenário

Imaginemos um cenário onde temos um serviço de pedidos que precisa interagir com um serviço de estoque e um serviço de pagamento.

### Estrutura dos Serviços

1. **Serviço de Pedido**: Recebe solicitações de pedidos.
2. **Serviço de Estoque**: Verifica a disponibilidade do item.
3. **Serviço de Pagamento**: Processa o pagamento.

### Orquestração:

1. **Verificação de Disponibilidade**: 
   - O método chama um serviço de estoque para verificar se o produto está disponível.
   - Se o produto não estiver disponível, retorna um status `BAD_REQUEST` com uma mensagem informando que o produto não está disponível.

2. **Criação do Pedido**: 
   - Se o produto estiver disponível, o código continua e tenta criar o pedido chamando outro serviço (presumivelmente um microserviço de pedidos).

3. **Resposta do Pedido**: 
   - Se o pedido for criado com sucesso (status `CREATED`), retorna a resposta com o corpo do pedido criado.
   - Caso contrário, retorna um erro com status `INTERNAL_SERVER_ERROR`.

> **Observação**: O código acima assume que a classe `Pedido` e as URLs do serviço de estoque e do serviço de pedidos estão corretamente configuradas.
