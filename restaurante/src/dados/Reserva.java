package dados;

import dados.enums.StatusReserva;

import java.time.LocalDateTime;

public class Reserva {

    private int id;
    private String nomeCliente;
    private String telefoneCliente;
    private LocalDateTime dataHora;
    private int numeroPessoas;
    private String observacoes;
    private StatusReserva status;

    public Reserva(int id, String nomeCliente, String telefoneCliente,
                   LocalDateTime dataHora, int numeroPessoas,
                   String observacoes, StatusReserva status) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.dataHora = dataHora;
        this.numeroPessoas = numeroPessoas;
        this.observacoes = observacoes;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }
}