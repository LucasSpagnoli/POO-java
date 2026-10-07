package negocio;

import dados.ItemPedido;
import dados.Mesa;
import dados.Pagamento;
import dados.PedidoDelivery;
import dados.Reserva;
import dados.ItemCardapio;
import dados.Garcom;
import dados.Pedido;
import dados.enums.CategoriaItem;
import dados.enums.FormaPagamento;
import dados.enums.StatusEntrega;
import dados.enums.StatusItemPedido;
import dados.enums.StatusReserva;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Mesa> mesas;
    private List<Reserva> reservas;
    private List<ItemCardapio> cardapio;
    private List<Garcom> garcons;
    private List<Pedido> pedidos;

    public Sistema() {
        this.mesas = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.cardapio = new ArrayList<>();
        this.garcons = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void cadastrarItemCardapio(ItemCardapio item) {
        if (item != null) {
            this.cardapio.add(item);
        }
    }

    public boolean removerItemCardapio(int codigo) {
        ItemCardapio item = buscarItemCardapio(codigo);
        if (item != null) {
            return this.cardapio.remove(item);
        }
        return false;
    }

    public ItemCardapio buscarItemCardapio(int codigo) {
        for (ItemCardapio item : this.cardapio) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    public List<ItemCardapio> listarCardapio() {
        return new ArrayList<>(this.cardapio);
    }

    public List<ItemCardapio> listarItensPorCategoria(CategoriaItem categoria) {
        List<ItemCardapio> filtrados = new ArrayList<>();
        for (ItemCardapio item : this.cardapio) {
            if (item.getCategoria() == categoria) {
                filtrados.add(item);
            }
        }
        return filtrados;
    }

    public void alterarDisponibilidadeItem(int codigo, boolean disponivel) {
        ItemCardapio item = buscarItemCardapio(codigo);
        if (item != null) {
            item.setDisponivel(disponivel);
        }
    }

    public void cadastrarMesa(Mesa mesa) {
        if (mesa != null) {
            this.mesas.add(mesa);
        }
    }

    public Mesa buscarMesa(int numero) {
        for (Mesa mesa : this.mesas) {
            if (mesa.getNumero() == numero) {
                return mesa;
            }
        }
        return null;
    }

    public List<Mesa> listarMesas() {
        return new ArrayList<>(this.mesas);
    }

    public void cadastrarGarcom(Garcom garcom) {
        if (garcom != null) {
            this.garcons.add(garcom);
        }
    }

    public Garcom buscarGarcomPorCpf(String cpf) {
        for (Garcom garcom : this.garcons) {
            if (garcom.getCpf() != null && garcom.getCpf().equals(cpf)) {
                return garcom;
            }
        }
        return null;
    }

    public List<Garcom> listarGarcons() {
        return new ArrayList<>(this.garcons);
    }

    public Reserva buscarReserva(int id) {
        for (Reserva reserva : this.reservas) {
            if (reserva.getId() == id) {
                return reserva;
            }
        }
        return null;
    }

    public List<Reserva> realizarReserva(String nomeCliente, String telefone, LocalDateTime dataHora, int numPessoas, String obs, int numeroMesas) {

        List<Reserva> reservas = new ArrayList<>();

        for (int i = 0; i < numeroMesas; i++) {
            Reserva reserva = new Reserva(this.reservas.size() + 1, nomeCliente, telefone, dataHora, numPessoas, obs, StatusReserva.PENDENTE);

            this.reservas.add(reserva);
            reservas.add(reserva);
        }

        return reservas;
    }

    public boolean alterarStatusReserva(int idReserva, StatusReserva novoStatus) {
        Reserva reserva = buscarReserva(idReserva);
        if (reserva != null) {
            reserva.setStatus(novoStatus);
            return true;
        }
        return false;
    }

    public List<Reserva> listarReservasPorStatus(StatusReserva status) {
        List<Reserva> filtradas = new ArrayList<>();
        for (Reserva reserva : this.reservas) {
            if (reserva.getStatus() == status) {
                filtradas.add(reserva);
            }
        }
        return filtradas;
    }

    public Pedido abrirPedido(int numeroMesa, String cpfGarcom) {
        Mesa mesa = buscarMesa(numeroMesa);
        Garcom garcom = buscarGarcomPorCpf(cpfGarcom);

        if (mesa != null && garcom != null) {
            int novoId = this.pedidos.size() + 1;
            Pedido pedido = new Pedido(novoId, LocalDateTime.now(), mesa, garcom);
            this.pedidos.add(pedido);
            return pedido;
        }
        return null;
    }

    public boolean adicionarItemPedido(int idPedido, int codigoItem, int quantidade, String observacao) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        ItemCardapio item = buscarItemCardapio(codigoItem);

        if (pedido != null && item != null && item.isDisponivel()) {
            ItemPedido itemPedido = new ItemPedido(item, quantidade, observacao);
            pedido.getItens().add(itemPedido);
            return true;
        }
        return false;
    }

    public boolean atualizarStatusItemPedido(int idPedido, int idItemPedido, StatusItemPedido novoStatus) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido != null && idItemPedido >= 0 && idItemPedido < pedido.getItens().size()) {
            pedido.getItens().get(idItemPedido).setStatusItem(novoStatus);
            return true;
        }
        return false;
    }

    public Pedido buscarPedidoPorMesa(int numeroMesa) {
        for (Pedido pedido : this.pedidos) {
            if (pedido.getMesa() != null && pedido.getMesa().getNumero() == numeroMesa) {
                return pedido;
            }
        }
        return null;
    }

    public PedidoDelivery abrirPedidoDelivery(String endereco, double taxaEntrega) {
        int novoId = this.pedidos.size() + 1;
        PedidoDelivery pedidoDelivery = new PedidoDelivery(novoId, LocalDateTime.now(), endereco, taxaEntrega);
        this.pedidos.add(pedidoDelivery);
        return pedidoDelivery;
    }

    public boolean atualizarStatusEntrega(int idPedidoDelivery, StatusEntrega novoStatus) {
        Pedido pedido = buscarPedidoPorId(idPedidoDelivery);
        if (pedido instanceof PedidoDelivery) {
            ((PedidoDelivery) pedido).setStatusEntrega(novoStatus);
            return true;
        }
        return false;
    }

    public double calcularTotalPedido(int idPedido, boolean incluirTaxaServico) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido != null) {
            pedido.setTaxaServicoIncluida(incluirTaxaServico);
            return pedido.calcularTotal();
        }
        return 0.0;
    }

    public boolean registrarPagamento(int idPedido, double valor, FormaPagamento forma) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido != null) {
            int novoIdPagamento = pedido.getPagamentos().size() + 1;
            Pagamento pagamento = new Pagamento(novoIdPagamento, valor, LocalDateTime.now(), forma);
            pedido.getPagamentos().add(pagamento);
            return true;
        }
        return false;
    }

    public boolean verificarQuitacaoPedido(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido != null) {
            double totalPago = 0.0;
            for (Pagamento p : pedido.getPagamentos()) {
                totalPago += p.getValor();
            }
            return totalPago >= pedido.calcularTotal();
        }
        return false;
    }

    public boolean fecharPedido(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido != null && verificarQuitacaoPedido(idPedido)) {
            return true;
        }
        return false;
    }

    private Pedido buscarPedidoPorId(int idPedido) {
        for (Pedido pedido : this.pedidos) {
            if (pedido.getId() == idPedido) {
                return pedido;
            }
        }
        return null;
    }
}