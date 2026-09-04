package apresentacao;

import dados.Contato;
import negocio.ListaTelefonica;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static ListaTelefonica listaTelefonica = new ListaTelefonica();
    private static Scanner scanner = new Scanner(System.in);

    public static Contato novoContato() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        int telefone = Integer.parseInt(scanner.nextLine());

        return new Contato(nome, telefone);
    }

    public static void adicionarContato() {
        Contato contato = novoContato();
        listaTelefonica.adicionarContato(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public static void removerContato() {
        System.out.print("Digite a inicial do contato que deseja remover: ");
        char letra = scanner.nextLine().charAt(0);

        List<Contato> encontrados = listaTelefonica.buscarContatos(letra);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum contato encontrado com essa inicial.");
            return;
        }

        System.out.println("Contatos encontrados:");
        for (int i = 0; i < encontrados.size(); i++) {
            System.out.println((i + 1) + " - " + encontrados.get(i));
        }

        System.out.print("Escolha o número do contato a remover: ");
        int escolha = Integer.parseInt(scanner.nextLine()) - 1;

        if (escolha >= 0 && escolha < encontrados.size()) {
            listaTelefonica.removerContato(encontrados.get(escolha));
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void exibirContatos() {
        Map<Character, List<Contato>> todosOsContatos = listaTelefonica.buscarContatos();

        for (char letra = 'A'; letra <= 'Z'; letra++) {
            System.out.println(letra + ":");
            List<Contato> lista = todosOsContatos.get(letra);
            if (lista != null) {
                for (Contato contato : lista) {
                    System.out.println("- " + contato);
                }
            }
        }
    }

    public static void exibirContatos(char letra) {
        char inicial = Character.toUpperCase(letra);
        System.out.println(inicial + ":");

        List<Contato> lista = listaTelefonica.buscarContatos(inicial);
        for (Contato contato : lista) {
            System.out.println("- " + contato);
        }
    }

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nAgenda Telefônica");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Exibir todos os contatos");
            System.out.println("4 - Exibir contatos por letra");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                case 4:
                    System.out.print("Digite a letra: ");
                    char letra = scanner.nextLine().charAt(0);
                    exibirContatos(letra);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}