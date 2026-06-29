import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Pedido {
    private int numeroDoPedido; 
    private Cliente cliente;
    private ArrayList<Pizza> pizzas;
    private ArrayList<String> itensExtras;
    private ArrayList<Double> precosExtras;
    private String status;
    
    // PROTECTED para permitir a herança
    protected double valorTotal;

    public Pedido(int numeroDoPedido, Cliente cliente) {
        this.numeroDoPedido = numeroDoPedido;
        this.cliente = cliente;
        this.pizzas = new ArrayList<>();
        this.itensExtras = new ArrayList<>();
        this.precosExtras = new ArrayList<>();
        this.status = "Aguardando preparo";
        this.valorTotal = 0.0;
    }

    public int getNumeroDoPedido() { return numeroDoPedido; }
    public Cliente getCliente() { return cliente; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void adicionarPizza(Pizza novaPizza) { pizzas.add(novaPizza); }

    public void adicionarItemExtra(String nome, double preco) {
        itensExtras.add(nome);
        precosExtras.add(preco);
    }

    public void escolherBebidasEExtras(Scanner leitor) {
        int opB = -1;
        while (opB != 0) {
            System.out.println("\n--- BEBIDAS ---");
            System.out.println("1. Coca-Cola 2L (R$ 12)        4. Cerveja (R$ 7)");
            System.out.println("2. Guaraná Antarctica (R$ 10)  5. Água (R$ 5)");
            System.out.println("3. Suco de Laranja 1L (R$ 14)  0. AVANÇAR");
            System.out.print("Escolha o número: ");
            
            try {
                opB = leitor.nextInt();
                if (opB == 0) break;
                
                if (opB >= 1 && opB <= 5) {
                    System.out.print("Quantidade desta bebida: ");
                    int qtd = leitor.nextInt();
                    if (qtd <= 0) throw new QuantidadeInvalidaException("Erro: A quantidade deve ser maior que zero!");
                    
                    for (int i = 0; i < qtd; i++) {
                        switch (opB) {
                            case 1: this.adicionarItemExtra("Coca-Cola 2L", 12.0); break;
                            case 2: this.adicionarItemExtra("Guaraná 2L", 10.0); break;
                            case 3: this.adicionarItemExtra("Suco Laranja 1L", 14.0); break;
                            case 4: this.adicionarItemExtra("Cerveja", 7.0); break;
                            case 5: this.adicionarItemExtra("Água", 5.0); break;
                        }
                    }
                    System.out.println("✅ " + qtd + " bebida(s) adicionada(s)!");
                } else {
                    System.out.println("❌ Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Erro de digitação: Por favor, digite apenas números.");
                leitor.nextLine(); 
            } catch (QuantidadeInvalidaException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
        
        int opS = -1;
        while (opS != 0) {
            System.out.println("\n--- EXTRAS E SOBREMESAS ---");
            System.out.println("1. Batata Frita (R$ 18)   4. Pudim (R$ 10)");
            System.out.println("2. Pão de Alho (R$ 12)    5. Petit Gâteau (R$ 18)");
            System.out.println("3. Frango (R$ 25)         6. Sorvete (R$ 12)");
            System.out.println("0. FINALIZAR ESCOLHAS");
            System.out.print("Escolha o número: ");
            
            try {
                opS = leitor.nextInt();
                if (opS == 0) break;
                
                if (opS >= 1 && opS <= 6) {
                    System.out.print("Quantidade deste item: ");
                    int qtd = leitor.nextInt();
                    if (qtd <= 0) throw new QuantidadeInvalidaException("Erro: A quantidade deve ser maior que zero!");
                    
                    for (int i = 0; i < qtd; i++) {
                        switch (opS) {
                            case 1: this.adicionarItemExtra("Batata Frita", 18.0); break;
                            case 2: this.adicionarItemExtra("Pão de Alho", 12.0); break;
                            case 3: this.adicionarItemExtra("Frango", 25.0); break;
                            case 4: this.adicionarItemExtra("Pudim", 10.0); break;
                            case 5: this.adicionarItemExtra("Petit Gâteau", 18.0); break;
                            case 6: this.adicionarItemExtra("Sorvete", 12.0); break;
                        }
                    }
                    System.out.println("✅ " + qtd + " item(ns) adicionado(s)!");
                } else {
                    System.out.println("❌ Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Erro de digitação: Por favor, digite apenas números.");
                leitor.nextLine();
            } catch (QuantidadeInvalidaException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    public void calcularTotalPedido() {
        this.valorTotal = 0.0; 
        for (Pizza p : pizzas) { this.valorTotal += p.calcularPrecoFinal(); }
        for (Double preco : precosExtras) { this.valorTotal += preco; }
    }

    public void imprimirRecibo() {
        calcularTotalPedido(); 
        System.out.println("\n======================================");
        System.out.println("          PIZZARIA DA TURMA           ");
        System.out.println("======================================");
        System.out.println("Pedido Nº: " + this.numeroDoPedido + " | Status: " + this.status);
        System.out.println("--------------------------------------");
        cliente.exibirInfoCliente();
        System.out.println("--------------------------------------");
        System.out.println("RESUMO DO PEDIDO:");
        for (Pizza p : pizzas) p.exibirDetalhesPizza();
        for (int i = 0; i < itensExtras.size(); i++) {
            System.out.println("- 1x " + itensExtras.get(i) + " (R$ " + precosExtras.get(i) + ")");
        }
        System.out.println("--------------------------------------");
        System.out.println("TOTAL A PAGAR: R$ " + this.valorTotal);
        System.out.println("======================================");
    }
}
