package dados;

import java.util.ArrayList;

public class Cliente {
    private int cpf;
    private String nome;
    private String endereco;
    private int telefone;
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void reservarIda(Reserva reserva) {
        if (!reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        ida.setVolta(volta);
        if (!reservas.contains(ida)) {
            reservas.add(ida);
        }
        if (!reservas.contains(volta)) {
            reservas.add(volta);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                ", reservas=" + reservas +
                '}';
    }
}