package dados;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private int cpf;
    private String nomme;
    private String endereco;
    private int telefone;
    private ArrayList<Reserva> idas;
    private ArrayList<Reserva> voltas;

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
                ", idas=" + idas +
                ", voltas=" + voltas +
                '}';
    }

    public void reservarIda(Reserva reserva) {
        idas.add(reserva);
    }

    public ArrayList<Reserva> getVoltas() {
        return voltas;
    }

    public ArrayList<Reserva> getIdas() {
        return idas;
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        voltas.add(volta);
    }
}
