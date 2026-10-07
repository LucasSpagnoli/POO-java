package dados;

import dados.enums.StatusEntrega;

import java.time.LocalDateTime;

public class PedidoDelivery extends Pedido {
    private String enderecoEntrega;
    private double taxaEntrega;
    private StatusEntrega statusEntrega;

    public PedidoDelivery() {
        super();
    }

    public PedidoDelivery(int id, LocalDateTime dataAbertura, String enderecoEntrega, double taxaEntrega) {
        super(id, dataAbertura, null, null);
        this.enderecoEntrega = enderecoEntrega;
        this.taxaEntrega = taxaEntrega;
        this.statusEntrega = StatusEntrega.PREPARANDO;
    }

    @Override
    public double calcularTotal() {
        double total = super.calcularTotal() + taxaEntrega;
        setValorTotal(total);
        return total;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }
}