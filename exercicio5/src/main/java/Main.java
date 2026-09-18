import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;
import negocio.Zoologico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Zoologico zoologico = new Zoologico();

    private static final List<Animal> animaisCadastrados = new ArrayList<>();
    private static final List<Viveiro> viveirosCadastrados = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");
            switch (opcao) {
                case 1 -> cadastrarViveiroComum();
                case 2 -> cadastrarAquario();
                case 3 -> cadastrarAnimalComum();
                case 4 -> cadastrarPeixe();
                case 5 -> alocarAnimal();
                case 6 -> listarViveiros();
                case 7 -> listarAquarios();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
            System.out.println();
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("ZOOLÓGICO");
        System.out.println("1 - Cadastrar Viveiro");
        System.out.println("2 - Cadastrar Aquário");
        System.out.println("3 - Cadastrar Animal");
        System.out.println("4 - Cadastrar Peixe");
        System.out.println("5 - Alocar Animal em Viveiro");
        System.out.println("6 - Listar Viveiros");
        System.out.println("7 - Listar Aquários");
        System.out.println("0 - Sair");
    }

    private static void cadastrarViveiroComum() {
        System.out.println("Cadastro de Viveiro");
        Viveiro viveiro = new Viveiro();
        viveiro.setNome(lerString("Nome: "));
        viveiro.setComprimento(lerFloat("Comprimento: "));
        viveiro.setLargura(lerFloat("Largura: "));

        zoologico.cadastrarViveiro(viveiro);
        viveirosCadastrados.add(viveiro);
        System.out.println("Viveiro cadastrado com sucesso!");
    }

    private static void cadastrarAquario() {
        System.out.println(" Cadastro de Aquário ");
        Aquario aquario = new Aquario();
        aquario.setNome(lerString("Nome: "));
        aquario.setComprimento(lerFloat("Comprimento: "));
        aquario.setLargura(lerFloat("Largura: "));
        aquario.setAltura(lerFloat("Altura: "));
        aquario.setTemperatura(lerFloat("Temperatura da água: "));

        zoologico.cadastrarViveiro(aquario);
        viveirosCadastrados.add(aquario);
        System.out.println("Aquário cadastrado com sucesso!");
    }

    private static void cadastrarAnimalComum() {
        System.out.println(" Cadastro de Animal ");
        Animal animal = new Animal();
        animal.setNome(lerString("Nome: "));
        animal.setCor(lerString("Cor: "));
        animal.setEspecie(lerString("Espécie: "));
        animal.setIdade(lerInt("Idade: "));
        animal.setLargura(lerFloat("Largura: "));
        animal.setComprimento(lerFloat("Comprimento: "));
        animal.setAltura(lerFloat("Altura: "));

        zoologico.cadastrarAnimais(animal);
        animaisCadastrados.add(animal);
        System.out.println("Animal cadastrado com sucesso!");
    }

    private static void cadastrarPeixe() {
        System.out.println(" Cadastro de Peixe ");
        Peixe peixe = new Peixe();
        peixe.setNome(lerString("Nome: "));
        peixe.setCor(lerString("Cor: "));
        peixe.setEspecie(lerString("Espécie: "));
        peixe.setIdade(lerInt("Idade: "));
        peixe.setLargura(lerFloat("Largura: "));
        peixe.setComprimento(lerFloat("Comprimento: "));
        peixe.setAltura(lerFloat("Altura: "));
        peixe.setTemperaturaIdeal(lerFloat("Temperatura ideal: "));

        zoologico.cadastrarAnimais(peixe);
        animaisCadastrados.add(peixe);
        System.out.println("Peixe cadastrado com sucesso!");
    }

    private static void alocarAnimal() {
        if (animaisCadastrados.isEmpty()) {
            System.out.println("Nenhum animal cadastrado ainda.");
            return;
        }
        if (viveirosCadastrados.isEmpty()) {
            System.out.println("Nenhum viveiro cadastrado ainda.");
            return;
        }

        System.out.println(" Animais cadastrados ");
        for (int i = 0; i < animaisCadastrados.size(); i++) {
            Animal a = animaisCadastrados.get(i);
            String tipo = (a instanceof Peixe) ? "Peixe" : "Animal";
            System.out.printf("%d - [%s] %s%n", i, tipo, a.getNome());
        }
        int idxAnimal = lerInt("Escolha o animal: ");
        if (idxAnimal < 0 || idxAnimal >= animaisCadastrados.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        System.out.println(" Viveiros cadastrados ");
        for (int i = 0; i < viveirosCadastrados.size(); i++) {
            Viveiro v = viveirosCadastrados.get(i);
            String tipo = (v instanceof Aquario) ? "Aquário" : "Viveiro";
            System.out.printf("%d - [%s] %s%n", i, tipo, v.getNome());
        }
        int idxViveiro = lerInt("Escolha o viveiro/aquário: ");
        if (idxViveiro < 0 || idxViveiro >= viveirosCadastrados.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Animal animal = animaisCadastrados.get(idxAnimal);
        Viveiro viveiro = viveirosCadastrados.get(idxViveiro);

        boolean alocado = zoologico.alocarAnimal(animal, viveiro);
        if (alocado) {
            System.out.println("Animal alocado com sucesso!");
        } else {
            System.out.println("Não foi possível alocar o animal (espaço, tipo ou temperatura incompatíveis).");
        }
    }

    private static void listarViveiros() {
        Viveiro[] viveiros = zoologico.getViveiro();
        if (viveiros.length == 0) {
            System.out.println("Nenhum viveiro cadastrado.");
            return;
        }
        for (Viveiro v : viveiros) {
            exibirViveiro(v, "Viveiro");
        }
    }

    private static void listarAquarios() {
        Aquario[] aquarios = zoologico.getAquarios();
        if (aquarios.length == 0) {
            System.out.println("Nenhum aquário cadastrado.");
            return;
        }
        for (Aquario a : aquarios) {
            exibirViveiro(a, "Aquário");
        }
    }

    private static void exibirViveiro(Viveiro viveiro, String tipo) {
        System.out.println(" " + tipo + ": " + viveiro.getNome() + " ");
        List<Animal> animais = viveiro.getAnimais();
        if (animais == null || animais.isEmpty()) {
            System.out.println("Viveiro vazio.");
            return;
        }
        for (Animal a : animais) {
            System.out.println("Nome: " + a.getNome());
            System.out.println("Cor: " + a.getCor());
            System.out.println("Espécie: " + a.getEspecie());
            if (a instanceof Peixe peixe) {
                System.out.println("Temperatura ideal: " + peixe.getTemperaturaIdeal());
            }
        }
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static float lerFloat(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}