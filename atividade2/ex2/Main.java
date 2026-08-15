package atividade2.ex2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPetShop sistema = new SistemaPetShop(scanner);
        int opcao;

        do {
            System.out.println("===== SISTEMA PET SHOP =====");
            System.out.println("1 - Cadastrar veterinário");
            System.out.println("2 - Mostrar veterinários");
            System.out.println("3 - Cadastrar endereço do veterinário");
            System.out.println("4 - Cadastrar animal");
            System.out.println("5 - Mostrar animais");
            System.out.println("6 - Cadastrar dono");
            System.out.println("7 - Cadastrar endereço do dono");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
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
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.\n");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
