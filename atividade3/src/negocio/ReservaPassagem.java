package negocio;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservaPassagem {
    public ArrayList<Cidade> cidades;
    public ArrayList<Cliente> clientes;
    public ArrayList<ArrayList<Reserva>> reservas;
    Scanner scanner = new Scanner(System.in);

    public void cadastrarCidade(Cidade cidade) {
        cidades.add(cidade);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void reservarIda(Cliente cliente, Reserva reserva) {
        cliente.reservarIda(reserva);
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public ArrayList<Reserva> mostrarReservar(int cpfCliente) {
        Cliente c;
        c = clientes.stream()
                .filter(cliente -> cliente.getCpf() == cpfCliente)
                .findFirst()
                .orElse(null);

        return c != null ? reservas.get(c.getId()) : null;
    }

    public ArrayList<Cliente> mostrarClientes() {
        return clientes;
    }

    public ArrayList<Cidade> mostrarCidades() {
        return cidades;
    }

}
