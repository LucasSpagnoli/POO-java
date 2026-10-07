package dados;

import dados.enums.FormaPagamento;

import java.time.LocalDateTime;

public class Pagamento {
    private int id;
    private double valor;
    private LocalDateTime dataHora;
    private FormaPagamento formaPagamento;

    public Pagamento() {}

    public Pagamento(int id, double valor, LocalDateTime dataHora, FormaPagamento formaPagamento) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}