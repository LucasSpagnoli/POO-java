package dados;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDateTime dataAbertura;
    private boolean taxaServicoIncluida;
    private double valorTotal;
    private Mesa mesa;
    private Garcom garcom;
    private List<ItemPedido> itens;
    private List<Pagamento> pagamentos;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
    }

    public Pedido(int id, LocalDateTime dataAbertura, Mesa mesa, Garcom garcom) {
        this();
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.mesa = mesa;
        this.garcom = garcom;
    }

    public double calcularTotal() {
        double subtotal = 0.0;
        for (ItemPedido item : itens) {
            if (item != null && item.getItemCardapio() != null) {
                subtotal += item.getItemCardapio().getPreco() * item.getQuantidade();
            }
        }
        if (taxaServicoIncluida) {
            subtotal *= 1.10;
        }
        this.valorTotal = subtotal;
        return subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public boolean isTaxaServicoIncluida() {
        return taxaServicoIncluida;
    }

    public void setTaxaServicoIncluida(boolean taxaServicoIncluida) {
        this.taxaServicoIncluida = taxaServicoIncluida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
}