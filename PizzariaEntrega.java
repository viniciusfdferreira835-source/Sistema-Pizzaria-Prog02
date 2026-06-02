import java.util.ArrayList;
import java.util.Scanner;

public class PizzariaEntrega {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        int contadorPedidos = 1001; 
        int opcaoMenu = 0;

        while (opcaoMenu != 6) {
            System.out.println("\n🍕 GERENCIADOR DA PIZZARIA 🍕");
            System.out.println("1 - Adicionar Novo Pedido");
            System.out.println("2 - Listar Todos os Pedidos");
            System.out.println("3 - Editar Status do Pedido");
            System.out.println("4 - Remover Pedido");
            System.out.println("5 - Finalizar Pedido (Enviar p/ Entrega)");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoMenu = leitor.nextInt();
            leitor.nextLine(); 

            switch (opcaoMenu) {
                case 1: 
                    System.out.println("\n--- DADOS DO CLIENTE ---");
                    System.out.print("Nome: ");
                    String nome = leitor.nextLine();
                    System.out.print("Telefone: ");
                    String tel = leitor.nextLine();
                    System.out.print("Endereço: ");
                    String end = leitor.nextLine();

                    Cliente c = new Cliente(nome, tel, end);
                    Pedido novoPedido = new Pedido(contadorPedidos, c);

                    int opP = -1;
                    while (opP != 0) {
                        System.out.println("\n--- CARDÁPIO DE PIZZAS ---");
                        System.out.println("1. Calabresa (R$ 40)      4. Quatro Queijos (R$ 48)");
                        System.out.println("2. Marguerita (R$ 38)     5. Portuguesa (R$ 42)");
                        System.out.println("3. Frango/Catupiry(R$ 45) 6. Bacon c/ Milho (R$ 44)");
                        System.out.println("0. NÃO QUERO PIZZAS / IR PARA BEBIDAS");
                        System.out.print("Escolha o número (ou 0 para pular): ");
                        opP = leitor.nextInt();
                        
                        if (opP == 0) break;

                        if (opP >= 1 && opP <= 6) {
                            System.out.print("Quantidade desta pizza: ");
                            int qtd = leitor.nextInt();
                            
                            for (int i = 0; i < qtd; i++) {
                                switch (opP) {
                                    case 1: novoPedido.adicionarPizza(new Pizza("Calabresa", "G", 40.0)); break;
                                    case 2: novoPedido.adicionarPizza(new Pizza("Marguerita", "G", 38.0)); break;
                                    case 3: novoPedido.adicionarPizza(new Pizza("Frango/Catupiry", "G", 45.0)); break;
                                    case 4: novoPedido.adicionarPizza(new Pizza("Quatro Queijos", "G", 48.0)); break;
                                    case 5: novoPedido.adicionarPizza(new Pizza("Portuguesa", "G", 42.0)); break;
                                    case 6: novoPedido.adicionarPizza(new Pizza("Bacon com Milho", "G", 44.0)); break;
                                }
                            }
                            System.out.println("✅ " + qtd + " pizza(s) adicionada(s)!");
                        } else {
                            System.out.println("❌ Opção inválida!");
                        }
                    }

                    int opB = -1;
                    while (opB != 0) {
                        System.out.println("\n--- BEBIDAS ---");
                        System.out.println("1. Coca-Cola 2L (R$ 12)        4. Cerveja Lata (R$ 7)");
                        System.out.println("2. Guaraná Antarctica (R$ 10)  5. Água Mineral (R$ 5)");
                        System.out.println("3. Suco de Laranja 1L (R$ 14)");
                        System.out.println("0. NÃO QUERO BEBIDAS / IR PARA EXTRAS");
                        System.out.print("Escolha o número (ou 0 para pular): ");
                        opB = leitor.nextInt();
                        
                        if (opB == 0) break;

                        if (opB >= 1 && opB <= 5) {
                            System.out.print("Quantidade desta bebida: ");
                            int qtd = leitor.nextInt();
                            
                            for (int i = 0; i < qtd; i++) {
                                switch (opB) {
                                    case 1: novoPedido.adicionarItemExtra("Coca-Cola 2L", 12.0); break;
                                    case 2: novoPedido.adicionarItemExtra("Guaraná Antarctica 2L", 10.0); break;
                                    case 3: novoPedido.adicionarItemExtra("Suco de Laranja 1L", 14.0); break;
                                    case 4: novoPedido.adicionarItemExtra("Cerveja Lata", 7.0); break;
                                    case 5: novoPedido.adicionarItemExtra("Água Mineral", 5.0); break;
                                }
                            }
                            System.out.println("✅ " + qtd + " bebida(s) adicionada(s)!");
                        } else {
                            System.out.println("❌ Opção inválida!");
                        }
                    }

                    int opS = -1;
                    while (opS != 0) {
                        System.out.println("\n--- EXTRAS E SOBREMESAS ---");
                        System.out.println("1. Batata Frita (R$ 18)   4. Pudim (R$ 10)");
                        System.out.println("2. Pão de Alho (R$ 12)    5. Petit Gâteau (R$ 18)");
                        System.out.println("3. Frango (R$ 25)         6. Sorvete (R$ 12)");
                        System.out.println("0. NÃO QUERO EXTRAS / SALVAR PEDIDO");
                        System.out.print("Escolha o número (ou 0 para finalizar): ");
                        opS = leitor.nextInt();
                        
                        if (opS == 0) break;
                        
                        if (opS >= 1 && opS <= 6) {
                            System.out.print("Quantidade deste item: ");
                            int qtd = leitor.nextInt();
                            
                            for (int i = 0; i < qtd; i++) {
                                switch (opS) {
                                    case 1: novoPedido.adicionarItemExtra("Batata Frita", 18.0); break;
                                    case 2: novoPedido.adicionarItemExtra("Pão de Alho", 12.0); break;
                                    case 3: novoPedido.adicionarItemExtra("Frango Passarinho", 25.0); break;
                                    case 4: novoPedido.adicionarItemExtra("Pudim", 10.0); break;
                                    case 5: novoPedido.adicionarItemExtra("Petit Gâteau", 18.0); break;
                                    case 6: novoPedido.adicionarItemExtra("Sorvete", 12.0); break;
                                }
                            }
                            System.out.println("✅ " + qtd + " item(ns) adicionado(s)!");
                        } else {
                            System.out.println("❌ Opção inválida!");
                        }
                    }

                    listaDePedidos.add(novoPedido);
                    System.out.println("\n✅ PEDIDO " + contadorPedidos + " CADASTRADO COM SUCESSO!");
                    contadorPedidos++; 
                    break;

                case 2: 
                    System.out.println("\n--- LISTA DE PEDIDOS ATIVOS ---");
                    if (listaDePedidos.isEmpty()) {
                        System.out.println("Nenhum pedido no sistema.");
                    } else {
                        for (Pedido p : listaDePedidos) {
                            p.imprimirRecibo();
                        }
                    }
                    break;

                case 3: 
                    System.out.print("\nDigite o Nº do Pedido para editar o status: ");
                    int numEdicao = leitor.nextInt();
                    leitor.nextLine();
                    boolean encontradoEdicao = false;

                    for (Pedido p : listaDePedidos) {
                        if (p.getNumeroDoPedido() == numEdicao) {
                            System.out.print("Novo Status (Ex: Em preparo): ");
                            String novoStatus = leitor.nextLine();
                            p.setStatus(novoStatus);
                            System.out.println("✅ Status atualizado!");
                            encontradoEdicao = true;
                            break;
                        }
                    }
                    if (!encontradoEdicao) System.out.println("❌ Pedido não encontrado.");
                    break;

                case 4: 
                    System.out.print("\nDigite o Nº do Pedido para remover: ");
                    int numRemover = leitor.nextInt();
                    boolean encontradoRemocao = false;

                    for (int i = 0; i < listaDePedidos.size(); i++) {
                        if (listaDePedidos.get(i).getNumeroDoPedido() == numRemover) {
                            listaDePedidos.remove(i);
                            System.out.println("🗑️ Pedido " + numRemover + " removido do sistema.");
                            encontradoRemocao = true;
                            break;
                        }
                    }
                    if (!encontradoRemocao) System.out.println("❌ Pedido não encontrado.");
                    break;

                case 5: 
                    System.out.print("\nDigite o Nº do Pedido para finalizar e enviar: ");
                    int numFinalizar = leitor.nextInt();
                    boolean encontradoFinalizar = false;

                    for (Pedido p : listaDePedidos) {
                        if (p.getNumeroDoPedido() == numFinalizar) {
                            p.setStatus("Saiu para entrega 🏍️");
                            
                            System.out.println("\n==============================================");
                            System.out.println("🛵 SUA PIZZA ESTÁ A CAMINHO! Prepare a mesa! 🍕💨");
                            System.out.println("==============================================");
                            
                            p.imprimirRecibo(); 
                            encontradoFinalizar = true;
                            break;
                        }
                    }
                    if (!encontradoFinalizar) System.out.println("❌ Pedido não encontrado.");
                    break;

                case 6: 
                    System.out.println("Encerrando o sistema da Pizzaria. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Digite um número de 1 a 6.");
            }
        }
        leitor.close();
    }
}
