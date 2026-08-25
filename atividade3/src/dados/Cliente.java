package dados;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private int cpf;
    private String nomme;
    private String endereco;
    private int telefone;
    private ArrayList<Reserva> reservas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNomme() {
        return nomme;
    }

    public void setNomme(String nomme) {
        this.nomme = nomme;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf=" + cpf +
                ", nomme='" + nomme + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                ", reservas=" + reservas +
                '}';
    }

    public ArrayList<Reserva> getreservas() {
        return reservas;
    }

    public void reservarIda(Reserva reserva) {
        boolean existe = false;
        for (int i = 0; i < reservas.toArray().length; i++) {
            if (reservas.get(i).equals(reserva)) {
                existe = true;
            }
        }
        if (!existe) {
            reservas.add(reserva);
        }
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        reservas.add(volta);
    }
}
