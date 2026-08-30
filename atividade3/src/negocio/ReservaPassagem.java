package negocio;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;

import java.util.ArrayList;

public class ReservaPassagem {
    private ArrayList<Cidade> listaDeCidades = new ArrayList<>();
    private ArrayList<Cliente> listaDeClientes = new ArrayList<>();

    public void cadastrarCidade(Cidade cidade) {
        if (cidade != null && !listaDeCidades.contains(cidade)) {
            listaDeCidades.add(cidade);
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente != null) {
            boolean clienteExiste = false;
            for (Cliente c : listaDeClientes) {
                if (c.getCpf() == cliente.getCpf()) {
                    clienteExiste = true;
                    break;
                }
            }
            if (!clienteExiste) {
                listaDeClientes.add(cliente);
            }
        }
    }

    public void reservarIda(Cliente cliente, Reserva reserva) {
        if (cliente != null && reserva != null) {
            cliente.reservarIda(reserva);
        }
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
        if (cliente != null && ida != null && volta != null) {
            cliente.reservarVolta(ida, volta);
        }
    }

    public ArrayList<Reserva> mostrarReservas(int cpfCliente) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getCpf() == cpfCliente) {
                return cliente.getReservas();
            }
        }
        return new ArrayList<>();
    }

    public ArrayList<Cliente> mostrarClientes() {
        return listaDeClientes;
    }

    public ArrayList<Cidade> mostrarCidades() {
        return listaDeCidades;
    }
}