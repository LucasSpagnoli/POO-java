package ex1.Sistema;

import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

import ex1.dados.Animal;
import ex1.dados.Consulta;
import ex1.dados.Dono;
import ex1.dados.Veterinario;
import ex1.negocio.Clinica;

public class Principal {

    private static Scanner teclado = new Scanner(System.in);
    private static Clinica clinica = new Clinica();
    private static int proximoCodigo = 1;

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("CLÍNICA VETERINÁRIA");
            System.out.println("1 - Cadastrar dono");
            System.out.println("2 - Cadastrar animal");
            System.out.println("3 - Cadastrar veterinário");
            System.out.println("4 - Marcar consulta");
            System.out.println("5 - Desmarcar consulta");
            System.out.println("6 - Listar consultas de uma data");
            System.out.println("0 - Sair");
            opcao = lerInt("Escolha uma opção: ");

            if (opcao == 1) {
                cadastrarDono();
            } else if (opcao == 2) {
                cadastrarAnimal();
            } else if (opcao == 3) {
                cadastrarVeterinario();
            } else if (opcao == 4) {
                marcarConsulta();
            } else if (opcao == 5) {
                desmarcarConsulta();
            } else if (opcao == 6) {
                listarConsultasPorData();
            } else if (opcao != 0) {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Encerrando o sistema...");
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return teclado.nextLine();
    }

    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(teclado.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private static void cadastrarDono() {
        System.out.println("--- Cadastro de dono ---");
        String nome = lerTexto("Nome: ");
        String cpf = lerTexto("CPF: ");

        clinica.cadastrarDono(new Dono(nome, cpf));
        System.out.println("Dono cadastrado!");
    }

    private static void cadastrarAnimal() {
        System.out.println("--- Cadastro de animal ---");

        if (clinica.getDonos().size() == 0) {
            System.out.println("Cadastre um dono antes de cadastrar um animal.");
            return;
        }

        String nome = lerTexto("Nome: ");
        String especie = lerTexto("Espécie: ");
        int idade = lerInt("Idade: ");

        System.out.println("Donos cadastrados:");
        ArrayList<Dono> donos = clinica.getDonos();
        for (int i = 0; i < donos.size(); i++) {
            System.out.println(i + " - " + donos.get(i));
        }
        int indice = lerInt("Número do dono: ");

        if (indice < 0 || indice >= donos.size()) {
            System.out.println("Dono inválido. Animal não cadastrado.");
            return;
        }

        Dono dono = donos.get(indice);
        Animal animal = new Animal(nome, especie, idade, dono);
        dono.cadastrarAnimal(animal);
        clinica.cadastrarAnimal(animal);
        System.out.println("Animal cadastrado!");
    }

    private static void cadastrarVeterinario() {
        System.out.println("--- Cadastro de veterinário ---");
        String nome = lerTexto("Nome: ");
        String cpf = lerTexto("CPF: ");
        double salario = lerDouble("Salário: ");

        clinica.cadastrarVeterinario(new Veterinario(nome, cpf, salario));
        System.out.println("Veterinário cadastrado!");
    }

    private static void marcarConsulta() {
        System.out.println("--- Marcar consulta ---");

        if (clinica.getAnimais().size() == 0 || clinica.getVeterinarios().size() == 0) {
            System.out.println("É preciso ter pelo menos um animal e um veterinário cadastrados.");
            return;
        }

        try {
            System.out.println("Data da consulta:");
            int dia = lerInt("  Dia: ");
            int mes = lerInt("  Mês: ");
            int ano = lerInt("  Ano: ");
            LocalDate data = LocalDate.of(ano, mes, dia);

            System.out.println("Horário da consulta:");
            int hora = lerInt("  Hora: ");
            int minuto = lerInt("  Minuto: ");
            LocalTime horario = LocalTime.of(hora, minuto);

            System.out.println("Animais cadastrados:");
            ArrayList<Animal> animais = clinica.getAnimais();
            for (int i = 0; i < animais.size(); i++) {
                System.out.println(i + " - " + animais.get(i));
            }
            int indiceAnimal = lerInt("Número do animal: ");

            System.out.println("Veterinários cadastrados:");
            ArrayList<Veterinario> vets = clinica.getVeterinarios();
            for (int i = 0; i < vets.size(); i++) {
                System.out.println(i + " - " + vets.get(i));
            }
            int indiceVet = lerInt("Número do veterinário: ");

            if (indiceAnimal < 0 || indiceAnimal >= animais.size()
                    || indiceVet < 0 || indiceVet >= vets.size()) {
                System.out.println("Animal ou veterinário inválido. Consulta não marcada.");
                return;
            }

            Consulta consulta = new Consulta(proximoCodigo, data, horario);
            consulta.alocarAnimal(animais.get(indiceAnimal));
            consulta.alocarVeterinario(vets.get(indiceVet));
            clinica.marcarConsulta(consulta);

            System.out.println("Consulta marcada! Código: " + proximoCodigo);
            proximoCodigo++;

        } catch (DateTimeException e) {
            System.out.println("Data ou horário inválido. Consulta não marcada.");
        }
    }

    private static void desmarcarConsulta() {
        System.out.println("--- Desmarcar consulta ---");
        int codigo = lerInt("Código da consulta: ");

        ArrayList<Consulta> consultas = clinica.getConsultas();
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getCodigo() == codigo) {
                clinica.desmarcarConsulta(consultas.get(i));
                System.out.println("Consulta desmarcada!");
                return;
            }
        }
        System.out.println("Consulta não encontrada.");
    }

    private static void listarConsultasPorData() {
        System.out.println("--- Consultas por data ---");

        try {
            int dia = lerInt("Dia: ");
            int mes = lerInt("Mês: ");
            int ano = lerInt("Ano: ");
            LocalDate data = LocalDate.of(ano, mes, dia);

            ArrayList<Consulta> lista = clinica.buscarConsultasPorData(data);

            if (lista.size() == 0) {
                System.out.println("Nenhuma consulta nessa data.");
            } else {
                System.out.println("Consultas em " + data + ":");
                for (int i = 0; i < lista.size(); i++) {
                    System.out.println(lista.get(i));
                }
            }
        } catch (DateTimeException e) {
            System.out.println("Data inválida.");
        }
    }
}
