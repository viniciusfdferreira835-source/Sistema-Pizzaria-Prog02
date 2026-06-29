public class PedidoDelivery extends Pedido {
    private double taxaEntrega;

    public PedidoDelivery(int numeroDoPedido, Cliente cliente, double taxaEntrega) {
        super(numeroDoPedido, cliente); 
        this.taxaEntrega = taxaEntrega;
    }

    @Override
    public void calcularTotalPedido() {
        super.calcularTotalPedido(); 
        this.valorTotal += taxaEntrega; 
    }
    
    @Override
    public void imprimirRecibo() {
        super.imprimirRecibo();
        System.out.println("(Taxa de Entrega de R$ " + taxaEntrega + " já inclusa no valor)\n");
    }
}