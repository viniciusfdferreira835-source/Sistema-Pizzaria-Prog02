//Viniícius 
public class Pizza {

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



    public double calcularPrecoFinal() {

        return precoBase;

    }



    public void exibirDetalhesPizza() {

        System.out.println("- 1x Pizza " + this.tamanho + " de " + this.sabor + " (R$ " + this.precoBase + ")");

    }

}
public class Cliente {

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

}
// Lucas Soares Rangel- pedidos
    import java.util.ArrayList;

public class Pedido {
    private int numeroDoPedido; 
    private Cliente cliente;
    private ArrayList<Pizza> pizzas;
    private ArrayList<String> itensExtras;
    private ArrayList<Double> precosExtras;
    private String status;
    private double valorTotal;

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

    public void adicionarPizza(Pizza novaPizza) {
        pizzas.add(novaPizza);
    }

    public void adicionarItemExtra(String nome, double preco) {
        itensExtras.add(nome);
        precosExtras.add(preco);
    }

    public void calcularTotalPedido() {
        this.valorTotal = 0.0; 
        for (Pizza p : pizzas) {
            this.valorTotal += p.calcularPrecoFinal();
        }
        for (Double preco : precosExtras) {
            this.valorTotal += preco;
        }
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
        
        for (Pizza p : pizzas) {
            p.exibirDetalhesPizza();
        }
        
        for (int i = 0; i < itensExtras.size(); i++) {
            System.out.println("- 1x " + itensExtras.get(i) + " (R$ " + precosExtras.get(i) + ")");
        }
        
        System.out.println("--------------------------------------");
        System.out.println("TOTAL A PAGAR: R$ " + this.valorTotal);
        System.out.println("======================================\n");
    }
}
