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
