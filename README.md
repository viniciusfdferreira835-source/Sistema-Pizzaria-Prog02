# Sistema-Pizzaria-Prog2.
# 🍕 Sistema de Gerenciamento de Pizzaria (Delivery)

Repositório criado para o projeto da disciplina de Programação 2, demonstrando a aplicação prática de Programação Orientada a Objetos (POO) em Java.

### 🏛️ Informações Acadêmicas
* **Instituição:** Universidade Federal Rural de Pernambuco (UFRPE) - Unidade Acadêmica de Belo Jardim (UABJ)
* **Disciplina:** Programação 2
* **Docente:** Anderson Pinheiro Cavalcanti
* **Discentes (Equipe):** * Antônio Miranda
  * Lucas Soares
  * Marcos Matheus
  * Vinícius Fernando

---

## 🎯 Objetivo da Entrega 2
Nesta segunda etapa do projeto, o professor solicitou a evolução do sistema base para incluir conceitos mais robustos de segurança de dados e gerenciamento dinâmico de memória. As principais exigências foram:
1. Aplicação de **Encapsulamento** (atributos `private` com métodos `get` e `set`).
2. Substituição de vetores fixos (Arrays) por **Listas Dinâmicas** (`ArrayList`).
3. Implementação de um sistema de **CRUD** (Create, Read, Update, Delete) através de uma classe principal com menu interativo, permitindo adicionar, listar, editar e remover objetos criados.

---

## ⚙️ Explicação da Arquitetura do Código

O código foi dividido em 4 blocos principais (Classes) para manter a modularidade e as regras de negócio bem definidas:

### 1. Classe `Cliente`
* **O que faz:** Molde para armazenar os dados de contato do cliente.
* **O que foi utilizado:** Atributos `private` (`nome`, `telefone`, `endereco`) para garantir o **Encapsulamento**. Apenas os métodos `get` e `set` permitem a leitura e alteração segura desses dados após o objeto ser instanciado pelo Construtor.

### 2. Classe `Pizza`
* **O que faz:** Representa o produto base do restaurante.
* **O que foi utilizado:** Atributos protegidos para `sabor`, `tamanho` e `precoBase`. Possui o método `exibirDetalhesPizza()` para padronizar a forma como as informações do produto são impressas no console.

### 3. Classe `Pedido`
* **O que faz:** Funciona como o "carrinho de compras" e unifica o cliente aos produtos escolhidos, além de ser responsável pelas regras de cálculo.
* **O que foi utilizado:** * O atributo `numeroDoPedido` possui apenas o método `get`, travando qualquer tentativa externa de modificar o número fiscal de um pedido já gerado.
  * Uso massivo de `ArrayList<Pizza>`, `ArrayList<String>` e `ArrayList<Double>` para permitir que o cliente inclua dezenas de itens extras sem travar o sistema por falta de espaço (o que aconteceria em um vetor simples de tamanho 10, por exemplo).
  * O método `calcularTotalPedido()` utiliza laços de repetição `for-each` para varrer dinamicamente as listas e somar o valor a pagar.

### 4. Classe Principal (`PizzariaEntrega`)
* **O que faz:** É o cérebro (Motor) da aplicação onde o método `main` é executado. Responsável pela interação direta com o usuário via terminal.
* **O que foi utilizado:** * A biblioteca `Scanner` para capturar a digitação do usuário.
  * Um `ArrayList<Pedido>` principal, que funciona como o banco de dados temporário do restaurante (memória).
  * **O Sistema CRUD (Switch/Case):** Um menu interativo que roda dentro de um laço `while`.
    * **Create (Adicionar):** Lê os dados, utiliza sub-laços (`while` e `for`) para incluir quantidades variadas de Pizzas, Bebidas e Sobremesas, e salva o objeto `Pedido` na lista.
    * **Read (Listar):** Varre o `ArrayList` exibindo os recibos ativos.
    * **Update (Editar):** Permite alterar o `Status` do pedido (ex: "Em preparo" para "Saiu para entrega").
    * **Delete (Remover):** Localiza o pedido pelo ID e utiliza o comando `.remove()` da lista para apagar os dados em caso de cancelamento.

---

## 🚀 Como Executar
1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado.
2. Compile o arquivo: `javac PizzariaEntrega.java`
3. Execute o programa: `java PizzariaEntrega`
