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
