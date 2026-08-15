package atividade2.ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPetShop sistema = new SistemaPetShop(scanner);
        int opcao;

        do {
            System.out.println("sistema pet shop");
            System.out.println("1 - cadastrar veterinario");
            System.out.println("2 - mostrar veterinarios");
            System.out.println("3 - cadastrar endereco do veterinario");
            System.out.println("4 - cadastrar animal");
            System.out.println("5 - mostrar animais");
            System.out.println("6 - cadastrar dono");
            System.out.println("7 - cadastrar endereco do dono");
            System.out.println("0 - sair");
            System.out.print("escolha uma opcao ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    sistema.cadastrarVeterinario();
                    break;
                case 2:
                    sistema.mostrarVeterinarios();
                    break;
                case 3:
                    sistema.cadastrarEnderecoVeterinario();
                    break;
                case 4:
                    sistema.cadastrarAnimal();
                    break;
                case 5:
                    sistema.mostrarAnimais();
                    break;
                case 6:
                    sistema.cadastrarDono();
                    break;
                case 7:
                    sistema.cadastrarEnderecoDono();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("opcao invalida\n");
            }
        } while (opcao != 0);

        scanner.close();
    }
}