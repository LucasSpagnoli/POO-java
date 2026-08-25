package negocio;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservaPassagem {
    public ArrayList<Cidade> listaDeCidades;
    public ArrayList<Cliente> listaDeClientes;
    Scanner scanner = new Scanner(System.in);

    public void cadastrarCidade(Cidade cidade) {
        listaDeCidades.add(cidade);
    }

    public void cadastrarCliente(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

    public void reservarIda(Cliente cliente, Reserva reserva) {
        cliente.reservarIda(reserva);
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public ArrayList<Reserva> mostrarReservar(int cpfCliente) {
        Cliente cliente = listaDeClientes.stream().filter(c -> c.getCpf() == cpfCliente).findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Nenhum cliente com este CPF encontrado");
        }
        return cliente.getreservas();
    }

    public ArrayList<Cliente> mostrarClientes() {
        return listaDeClientes;
    }

    public ArrayList<Cidade> mostrarCidades() {
        return listaDeCidades;
    }

}
