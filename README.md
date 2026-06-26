# 🍕 Sistema de Gerenciamento de Pizzaria (Delivery)

Repositório criado para o projeto da disciplina de Programação 2, demonstrando a evolução e aplicação prática de conceitos de Programação Orientada a Objetos (POO) em Java.

### 🏛️ Informações Acadêmicas
* **Instituição:** Universidade Federal Rural de Pernambuco (UFRPE) - Unidade Acadêmica de Belo Jardim (UABJ)
* **Disciplina:** Programação 2
* **Docente:** Anderson Pinheiro Cavalcanti
* **Equipe:** Antônio Miranda, Lucas Soares, Marcos Matheus e Vinícius Fernando

---

## 🎯 Evolução do Projeto (Entregas 2 e 3)
O sistema foi desenvolvido de forma incremental para contemplar conceitos robustos de segurança de dados, gerenciamento dinâmico de memória e tratamento de falhas. As principais implementações incluem:

* **Encapsulamento:** Proteção de dados através de atributos `private` e `protected` com métodos `get` e `set`.
* **Listas Dinâmicas:** Substituição de vetores fixos por `ArrayList` para gerenciar múltiplos itens e pedidos de forma ilimitada.
* **Sistema CRUD Interativo:** Menu completo via terminal para Adicionar, Listar, Atualizar Status e Cancelar/Finalizar pedidos.
* **Herança e Polimorfismo:** Especialização de classes onde objetos derivados possuem comportamentos únicos no cálculo de valores e emissão de recibos.
* **Tratamento de Exceções:** Blindagem do sistema contra erros de digitação do usuário e infrações de regras de negócio através de blocos `try-catch` e exceções customizadas.
* **Sistema de Histórico:** Gerenciamento de dupla memória, separando pedidos em andamento de pedidos concluídos ou cancelados.

---

## ⚙️ Explicação da Arquitetura do Código

O código está modularizado em 6 arquivos principais (Classes) para manter as regras de negócio bem definidas:

### 1. Classe `Cliente`
Molde para armazenar os dados de contato do cliente. Utiliza o encapsulamento para garantir a leitura e alteração segura dos dados após a instanciação pelo Construtor. Possui um método estático inteligente para realizar a própria leitura de dados via Scanner.

### 2. Classe `Pizza`
Representa o produto base do restaurante. Contém os atributos de produto e os laços de repetição (protegidos por tratamento de erros) responsáveis por exibir o cardápio e instanciar os itens escolhidos.

### 3. Classe `Pedido` (Superclasse)
Funciona como o "carrinho de compras" unificando o cliente aos produtos escolhidos. Utiliza `ArrayList` de forma massiva para armazenar Pizzas, Bebidas e Sobremesas. O atributo do valor total foi definido como `protected` para permitir a comunicação direta com suas subclasses.

### 4. Classe `PedidoDelivery` (Subclasse)
Aplica o conceito de **Herança** ao estender a classe `Pedido`. Demonstra o uso de **Polimorfismo** através da anotação `@Override`, sobrescrevendo o método de cálculo total para embutir automaticamente a taxa de entrega, além de personalizar a impressão do recibo.

### 5. Classe `QuantidadeInvalidaException`
Aplica a exigência de **Exceções Verificadas**. É uma classe customizada (herdando diretamente de `Exception`) para representar uma quebra na regra de negócio, sendo disparada (`throw`) caso o usuário tente pedir uma quantidade igual ou menor que zero de qualquer item.

### 6. Classe Principal `PizzariaEntrega`
É o motor da aplicação onde o método `main` é executado e a interação com o usuário acontece. Gerencia duas listas dinâmicas (`listaDePedidos` e `historicoDePedidos`). Todo o menu de opções (`Scanner`) está protegido contra o erro `InputMismatchException`, impedindo que o sistema congele caso o usuário digite letras acidentalmente.

---

## 🚀 Como Executar

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado na sua máquina.
2. Faça o download de todos os arquivos `.java` deste repositório e coloque-os em uma mesma pasta.
3. Abra o terminal (ou prompt de comando) nesta pasta e compile todos os arquivos de uma vez usando o comando:
   `javac *.java`
4. Execute o programa principal chamando a classe motora:
   `java PizzariaEntrega`
