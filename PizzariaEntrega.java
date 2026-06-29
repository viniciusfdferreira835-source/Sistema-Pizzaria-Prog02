import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PizzariaEntrega {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        ArrayList<Pedido> historicoDePedidos = new ArrayList<>();
        
        int contadorPedidos = 1001; 
        int opcaoMenu = 0;

        while (opcaoMenu != 7) {
            System.out.println("\n🍕 GERENCIADOR DA PIZZARIA 🍕");
            System.out.println("1 - Adicionar Novo Pedido");
            System.out.println("2 - Listar Pedidos ATIVOS");
            System.out.println("3 - Editar Status do Pedido");
            System.out.println("4 - Cancelar/Remover Pedido");
            System.out.println("5 - Finalizar Pedido (Mover para Histórico)");
            System.out.println("6 - Histórico de Pedidos (Cancelados e Finalizados)");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcaoMenu = leitor.nextInt();
                leitor.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Erro: Por favor, digite apenas números! Letras não são aceitas.");
                leitor.nextLine(); 
                continue; 
            }

            switch (opcaoMenu) {
                case 1: 
                    Cliente c = Cliente.cadastrarNovoCliente(leitor);
                    
                    int tipo = 0;
                    boolean tipoValido = false;
                    
                    while (!tipoValido) {
                        try {
                            System.out.print("\nTipo do Pedido (1 - Entrega R$ 5,00 | 2 - Retirada no balcão): ");
                            tipo = leitor.nextInt();
                            if (tipo == 1 || tipo == 2) {
                                tipoValido = true;
                            } else {
                                System.out.println("❌ Opção inválida!");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("❌ Erro: Digite 1 ou 2.");
                            leitor.nextLine();
                        }
                    }
                    
                    // POLIMORFISMO
                    Pedido novoPedido;
                    if (tipo == 1) {
                        novoPedido = new PedidoDelivery(contadorPedidos, c, 5.00);
                    } else {
                        novoPedido = new Pedido(contadorPedidos, c);
                    }
                    
                    Pizza.escolherPizzas(leitor, novoPedido);
                    novoPedido.escolherBebidasEExtras(leitor);

                    listaDePedidos.add(novoPedido);
                    System.out.println("\n✅ PEDIDO " + contadorPedidos + " CADASTRADO COM SUCESSO!");
                    contadorPedidos++; 
                    break;

                case 2: 
                    System.out.println("\n--- LISTA DE PEDIDOS ATIVOS ---");
                    if (listaDePedidos.isEmpty()) System.out.println("Nenhum pedido ativo no momento.");
                    else for (Pedido p : listaDePedidos) p.imprimirRecibo();
                    break;

                case 3: 
                    System.out.print("\nDigite o Nº do Pedido para editar o status: ");
                    try {
                        int numEdicao = leitor.nextInt();
                        leitor.nextLine();
                        boolean achouEdicao = false;
                        for (Pedido p : listaDePedidos) {
                            if (p.getNumeroDoPedido() == numEdicao) {
                                System.out.print("Novo Status: ");
                                p.setStatus(leitor.nextLine());
                                System.out.println("✅ Status atualizado!");
                                achouEdicao = true;
                                break;
                            }
                        }
                        if (!achouEdicao) System.out.println("❌ Pedido ativo não encontrado.");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Erro: Digite um número de pedido válido.");
                        leitor.nextLine();
                    }
                    break;

                case 4: 
                    System.out.print("\nDigite o Nº do Pedido para cancelar: ");
                    try {
                        int numRem = leitor.nextInt();
                        boolean achouRem = false;
                        for (int i = 0; i < listaDePedidos.size(); i++) {
                            if (listaDePedidos.get(i).getNumeroDoPedido() == numRem) {
                                Pedido pCancelado = listaDePedidos.remove(i);
                                pCancelado.setStatus("Cancelado ❌");
                                historicoDePedidos.add(pCancelado);
                                
                                System.out.println("🗑️ Pedido " + numRem + " cancelado e movido para o histórico.");
                                achouRem = true;
                                break;
                            }
                        }
                        if (!achouRem) System.out.println("❌ Pedido ativo não encontrado.");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Erro: Digite um número de pedido válido.");
                        leitor.nextLine();
                    }
                    break;

                case 5: 
                    System.out.print("\nDigite o Nº do Pedido para finalizar: ");
                    try {
                        int numFin = leitor.nextInt();
                        boolean achouFin = false;
                        for (int i = 0; i < listaDePedidos.size(); i++) {
                            if (listaDePedidos.get(i).getNumeroDoPedido() == numFin) {
                                Pedido pFinalizado = listaDePedidos.remove(i);
                                
                                if (pFinalizado instanceof PedidoDelivery) {
                                    pFinalizado.setStatus("Finalizado: Entregue 🏍️");
                                    System.out.println("\n==============================================");
                                    System.out.println("🛵 SUA PIZZA ESTÁ A CAMINHO! Prepare a mesa! 🍕💨");
                                    System.out.println("==============================================");
                                } else {
                                    pFinalizado.setStatus("Finalizado: Retirado 🍕");
                                    System.out.println("\n==============================================");
                                    System.out.println("🍕 SEU PEDIDO ESTÁ PRONTO! Pode vir retirar! 🏃‍♂️💨");
                                    System.out.println("==============================================");
                                }
                                
                                historicoDePedidos.add(pFinalizado);
                                pFinalizado.imprimirRecibo(); 
                                achouFin = true;
                                break;
                            }
                        }
                        if (!achouFin) System.out.println("❌ Pedido ativo não encontrado.");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Erro: Digite um número de pedido válido.");
                        leitor.nextLine();
                    }
                    break;

                case 6: 
                    System.out.println("\n--- 🗄️ HISTÓRICO DE PEDIDOS (Finalizados / Cancelados) ---");
                    if (historicoDePedidos.isEmpty()) {
                        System.out.println("O histórico está vazio. Nenhum pedido foi finalizado ou cancelado ainda.");
                    } else {
                        for (Pedido p : historicoDePedidos) {
                            p.imprimirRecibo();
                        }
                    }
                    break;

                case 7: 
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha de 1 a 7.");
            }
        }
        leitor.close();
    }
}