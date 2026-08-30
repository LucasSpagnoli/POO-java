package apresentacao;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;
import negocio.ReservaPassagem;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ReservaPassagem reservaPassagem = new ReservaPassagem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        do {
            System.out.println("\nSISTEMA DE RESERVA DE PASSAGENS");
            System.out.println("1. Cadastrar Cidade");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Fazer Reserva");
            System.out.println("4. Mostrar Reservas de um Cliente");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCidade();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    fazerReserva();
                    break;
                case 4:
                    mostrarReservas();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        } while (opcao != 0);
    }

    public static void cadastrarCidade() {
        System.out.println("\nCADASTRAR CIDADE");
        Cidade cidade = new Cidade();

        System.out.println("Nome da cidade: ");
        cidade.setNome(scanner.nextLine());

        System.out.println("Estado (UF): ");
        cidade.setEstado(scanner.nextLine());

        reservaPassagem.cadastrarCidade(cidade);
        System.out.println("Cidade cadastrada com sucesso!");
    }

    public static void cadastrarCliente() {
        System.out.println("\nCADASTRAR CLIENTE");
        Cliente cliente = new Cliente();

        System.out.println("CPF (somente números): ");
        cliente.setCpf(scanner.nextInt());
        scanner.nextLine(); // limpar buffer

        System.out.println("Nome: ");
        cliente.setNome(scanner.nextLine());

        System.out.println("Endereço: ");
        cliente.setEndereco(scanner.nextLine());

        System.out.println("Telefone: ");
        cliente.setTelefone(scanner.nextInt());
        scanner.nextLine(); // limpar buffer

        reservaPassagem.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void fazerReserva() {
        System.out.println("\nFAZER RESERVA");

        ArrayList<Cliente> clientes = reservaPassagem.mostrarClientes();
        ArrayList<Cidade> cidades = reservaPassagem.mostrarCidades();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente primeiro!");
            return;
        }

        if (cidades.size() < 2) {
            System.out.println("Cadastre pelo menos 2 cidades para selecionar origem e destino!");
            return;
        }

        // Buscar Cliente
        System.out.println("Informe o CPF do cliente: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteSelecionado = null;
        for (Cliente c : clientes) {
            if (c.getCpf() == cpf) {
                clienteSelecionado = c;
                break;
            }
        }

        if (clienteSelecionado == null) {
            System.out.println("Cliente não encontrado com este CPF!");
            return;
        }

        // Selecionar Origem e Destino
        System.out.println("\nCidades disponíveis:");
        for (int i = 0; i < cidades.size(); i++) {
            System.out.println(i + " - " + cidades.get(i).getNome() + " / " + cidades.get(i).getEstado());
        }

        System.out.println("Digite o número da cidade de ORIGEM: ");
        int indexOrigem = scanner.nextInt();

        System.out.println("Digite o número da cidade de DESTINO: ");
        int indexDestino = scanner.nextInt();
        scanner.nextLine();

        if (indexOrigem < 0 || indexOrigem >= cidades.size() || indexDestino < 0 || indexDestino >= cidades.size()) {
            System.out.println("Opção de cidade inválida!");
            return;
        }

        Cidade origem = cidades.get(indexOrigem);
        Cidade destino = cidades.get(indexDestino);

        // Criar Reserva de Ida
        Reserva ida = new Reserva();
        System.out.println("Número da Reserva de Ida: ");
        ida.setNumReserva(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Data do voo de ida (DD/MM/AAAA): ");
        ida.setDataVoo(scanner.nextLine());

        System.out.println("Hora do voo de ida (HH:MM): ");
        ida.setHoraVoo(scanner.nextLine());

        System.out.println("Preço: ");
        ida.setPreco(scanner.nextFloat());
        scanner.nextLine();

        System.out.println("Classe do voo: ");
        ida.setClasseVoo(scanner.nextLine());

        System.out.println("Número da poltrona: ");
        ida.setPoltrona(scanner.nextInt());
        scanner.nextLine();

        ida.setOrigem(origem);
        ida.setDestino(destino);

        System.out.println("A reserva é de Ida e Volta? (1-Sim / 2-Não): ");
        int tipoReserva = scanner.nextInt();
        scanner.nextLine();

        if (tipoReserva == 1) {
            ida.setIdaEvolta(true);

            Reserva volta = new Reserva();
            System.out.println("Número da Reserva de Volta: ");
            volta.setNumReserva(scanner.nextInt());
            scanner.nextLine();

            System.out.println("Data do voo de volta (DD/MM/AAAA): ");
            volta.setDataVoo(scanner.nextLine());

            System.out.println("Hora do voo de volta (HH:MM): ");
            volta.setHoraVoo(scanner.nextLine());

            System.out.println("Preço da volta: ");
            volta.setPreco(scanner.nextFloat());
            scanner.nextLine();

            System.out.println("Classe do voo de volta: ");
            volta.setClasseVoo(scanner.nextLine());

            System.out.println("Número da poltrona de volta: ");
            volta.setPoltrona(scanner.nextInt());
            scanner.nextLine();

            // Inverte origem e destino na volta
            volta.setOrigem(destino);
            volta.setDestino(origem);
            volta.setIdaEvolta(true);

            reservaPassagem.reservarVolta(clienteSelecionado, ida, volta);
            System.out.println("Reserva de Ida e Volta realizada com sucesso!");
        } else {
            ida.setIdaEvolta(false);
            reservaPassagem.reservarIda(clienteSelecionado, ida);
            System.out.println("Reserva de Ida realizada com sucesso!");
        }
    }

    public static void mostrarReservas() {
        System.out.println("\nMOSTRAR RESERVAS");
        System.out.println("Digite o CPF do cliente: ");
        int cpf = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Reserva> reservas = reservaPassagem.mostrarReservas(cpf);

        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para este CPF");
        } else {
            System.out.println("Reservas encontradas:");
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }
}