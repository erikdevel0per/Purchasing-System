# Sistema de Pagamento

## Descrição
Este projeto implementa um sistema completo de e-commerce com processamento de pedidos, integração de pagamentos e funcionalidades de gerenciamento de usuários e produtos. O sistema também possui uma interface gráfica feita em JavaFX, permitindo ao usuário inserir detalhes do pedido e processar pagamentos de forma interativa e dinâmica.

## Linguagem e Tipos de Código
- **Linguagem:** O código foi escrito em Java, utilizando o framework JavaFX para a construção de interfaces gráficas de usuário (GUIs) e manipulação de eventos gráficos.
- **Funcionalidades:** 
Classe `Main` (Principal):

- **Objetivo**: Inicia o sistema de compras online, criando a interface gráfica e gerenciando as ações do usuário.

Comportamento:
- Define o layout principal da aplicação, usando o `BorderPane` como contêiner de alto nível.
- O topo da interface (`root.setTop(header)`) exibe um título e um ícone.
- O centro (`root.setCenter(grid)`) contém campos de entrada para o ID do pedido e valor do pedido, além de dois botões:
- "Criar Pedido": Cria um novo pedido com ID e valor, e atualiza o status do pedido.
- "Processar Pagamento": Processa o pagamento de um pedido, chamando a função de pagamento.
- Um efeito de transição (fade) é aplicado ao status do pedido após qualquer ação (criação ou pagamento).

Detalhes da Interface:
- O título "E-Commerce System" é exibido com um ícone acima.
- Dois campos de texto (`TextField`) são usados para inserir o ID do pedido e o valor.
- O layout usa o `GridPane`, um contêiner flexível para colocar os elementos.
- Estilo visual: O fundo da tela tem a cor `#282c36` (cinza escuro), e os botões têm cores distintas: verde para criar pedido e azul para processar pagamento.
- Fade Transition: Um efeito de animação é usado para suavizar a exibição das mensagens de status.

Classe `Pedido`:
- **Objetivo**: Representa o conceito de um pedido na loja.
Comportamento:
- A classe tem três atributos: `id`, `valorTotal` e `status` (iniciado como "Pendente").
- Método `processarPagamento`: Muda o status do pedido para "Pago" e exibe uma mensagem no console indicando que o pagamento foi processado.
- Método `getStatus: Retorna o status atual do pedido.
- Interação: A classe `Pedido` é usada dentro do método `start()` para criar um novo pedido sempre que o botão "Criar Pedido" é pressionado.
Classe `Pagamento`:

- **Objetivo**: Simula o processamento de um pagamento.
  
Comportamento:
- O método `processarPagamento(double valor)` recebe o valor do pagamento, simula a realização do pagamento e retorna `true` para indicar que o pagamento foi bem-sucedido.
- Interação: Essa classe é chamada dentro do método `start()` quando o usuário pressiona o botão "Processar Pagamento", passando o valor do pedido.

## Como Funciona o Sistema:
Tela Inicial:
- O usuário vê uma tela com o título "E-Commerce System" e um ícone, além de campos para inserir um ID de pedido e o valor do pedido.
- O usuário pode clicar no botão "Criar Pedido" para criar um novo pedido com o ID e o valor inseridos.

Criação de Pedido:
- Ao pressionar o botão "Criar Pedido", o sistema:
- Lê os valores dos campos de texto (ID e valor do pedido).
- Cria uma instância da classe `Pedido`, passando os valores inseridos.
- Exibe o status do pedido (inicialmente "Pendente") na tela.
- Aplica uma transição de fade à label do status.

Processamento de Pagamento:
- Ao pressionar o botão "Processar Pagamento", o sistema:
- Lê o valor do pedido.
- Chama o método `processarPagamento` da classe `Pagamento` para simular o pagamento.
- Se o pagamento for bem-sucedido (simulado como sempre verdadeiro), o status do pedido é atualizado para "Pago".
- Aplica uma transição de fade à label do status, indicando que o pagamento foi realizado com sucesso.

Interatividade e Efeitos:
- O sistema utiliza animações (``fade``) para tornar a interface mais fluida e interativa. O status da transação (pedido criado ou pagamento realizado) aparece suavemente na tela por meio de um efeito visual.

Mensagens no Console:
- Quando um pedido é criado, uma mensagem como "Pedido criado com status: Pendente" é exibida.
- Quando o pagamento é processado, a mensagem "Pagamento processado para o pedido X" é exibida no console.

## Resumo do Fluxo de Execução:
- O usuário insere os dados do pedido (ID e valor).
- O usuário cria um pedido, que exibe o status "Pendente".
- O usuário processa o pagamento, e o status do pedido é alterado para "Pago", com a atualização visível na interface.
- O efeito visual de fade é utilizado para destacar essas mudanças de status.

## **Muito Obrigado pela sua atenção!**
