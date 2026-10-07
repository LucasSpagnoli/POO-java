package dados;

import dados.enums.LocalizacaoMesa;

import java.util.Objects;

public class Mesa {
    private int numero;
    private int capacidade;
    private LocalizacaoMesa localizacao;

    public Mesa() {}

    public Mesa(int numero, int capacidade, LocalizacaoMesa localizacao) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public LocalizacaoMesa getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoMesa localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return numero == mesa.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}