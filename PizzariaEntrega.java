import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// ==========================================
// 1. EXCEÇÃO CUSTOMIZADA (Regra de Negócio)
// ==========================================
class QuantidadeInvalidaException extends Exception {
    public QuantidadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}

// ==========================================
// 2. CLASSE CLIENTE
// ==========================================
class Cliente {
    private String nome;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public void exibirInfoCliente() {
        System.out.println("Cliente: " + this.nome + " | Tel: " + this.telefone);
        System.out.println("Endereço: " + this.endereco);
    }

    public static Cliente cadastrarNovoCliente(Scanner leitor) {
        System.out.println("\n--- DADOS DO CLIENTE ---");
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("Telefone: ");
        String tel = leitor.nextLine();
        System.out.print("Endereço: ");
        String end = leitor.nextLine();
        return new Cliente(nome, tel, end);
    }
}

// ==========================================
// 3. CLASSE PIZZA
// ==========================================
class Pizza {
    private String sabor;
    private String tamanho;
    private double precoBase;

    public Pizza(String sabor, String tamanho, double precoBase) {
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.precoBase = precoBase;
    }

    public String getSabor() { return sabor; }
    public void setSabor(String sabor) { this.sabor = sabor; }
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public double getPrecoBase() { return precoBase; }
    public void setPrecoBase(double precoBase) { this.precoBase = precoBase; }
    public double calcularPrecoFinal() { return precoBase; }

    public void exibirDetalhesPizza() {
        System.out.println("- 1x Pizza " + this.tamanho + " de " + this.sabor + " (R$ " + this.precoBase + ")");
    }

    public static void escolherPizzas(Scanner leitor, Pedido pedido) {
        int opP = -1;
        while (opP != 0) {
            System.out.println("\n--- CARDÁPIO DE PIZZAS ---");
            System.out.println("1. Calabresa (R$ 40)      4. Quatro Queijos (R$ 48)");
            System.out.println("2. Marguerita (R$ 38)     5. Portuguesa (R$ 42)");
            System.out.println("3. Frango/Catupiry(R$ 45) 6. Bacon c/ Milho (R$ 44)");
            System.out.println("0. NÃO QUERO PIZZAS / AVANÇAR");
            System.out.print("Escolha o número (ou 0 para pular): ");
            
            try {
                opP = leitor.nextInt();
                if (opP == 0) break;

                if (opP >= 1 && opP <= 6) {
                    System.out.print("Quantidade desta pizza: ");
                    int qtd = leitor.nextInt();
                    
                    if (qtd <= 0) {
                        throw new QuantidadeInvalidaException("Erro: A quantidade deve ser maior que zero!");
                    }

                    for (int i = 0; i < qtd; i++) {
                        switch (opP) {
                            case 1: pedido.adicionarPizza(new Pizza("Calabresa", "G", 40.0)); break;
                            case 2: pedido.adicionarPizza(new Pizza("Marguerita", "G", 38.0)); break;
                            case 3: pedido.adicionarPizza(new Pizza("Frango/Catupiry", "G", 45.0)); break;
                            case 4: pedido.adicionarPizza(new Pizza("Quatro Queijos", "G", 48.0)); break;
                            case 5: pedido.adicionarPizza(new Pizza("Portuguesa", "G", 42.0)); break;
                            case 6: pedido.adicionarPizza(new Pizza("Bacon c/ Milho", "G", 44.0)); break;
                        }
                    }
                    System.out.println("✅ " + qtd + " pizza(s) adicionada(s)!");
                } else {
                    System.out.println("❌ Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Erro de digitação: Por favor, digite apenas números.");
                leitor.nextLine(); // Limpa o scanner
            } catch (QuantidadeInvalidaException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }
}