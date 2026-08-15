package atividade2.ex2;


import java.util.Scanner;

public class SistemaPetShop {
    private Veterinario[] veterinarios = new Veterinario[50];
    private int quantidadeVeterinarios = 0;
    private Scanner scanner;

    public SistemaPetShop(Scanner scanner) {
        this.scanner = scanner;
    }

    public void cadastrarVeterinario() {
        Veterinario v = new Veterinario();

        System.out.print("Digite o nome do veterinário: ");
        v.setNome(this.scanner.nextLine());

        System.out.print("Digite o salário do veterinário: ");
        v.setSalario(this.scanner.nextFloat());
        this.scanner.nextLine();

        if (this.quantidadeVeterinarios < this.veterinarios.length) {
            this.veterinarios[this.quantidadeVeterinarios] = v;
            this.quantidadeVeterinarios++;
            System.out.println("Veterinário cadastrado com sucesso!\n");
        } else {
            System.out.println("Não há mais posições disponíveis para veterinários.\n");
        }
    }

    public void mostrarVeterinarios() {
        System.out.println("Listagem de veterinários:");
        for (int i = 0; i < this.quantidadeVeterinarios; i++) {
            System.out.println(i + " - " + this.veterinarios[i]);
        }
        System.out.println();
    }

    public void cadastrarEnderecoVeterinario() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado ainda.\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário para cadastrar o endereço: ");
        int indice = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indice < 0 || indice >= this.quantidadeVeterinarios) {
            System.out.println("Veterinário inválido.\n");
            return;
        }

        Endereco e = new Endereco();
        System.out.print("Rua: ");
        e.setRua(this.scanner.nextLine());
        System.out.print("Número: ");
        e.setNumero(this.scanner.nextLine());
        System.out.print("Bairro: ");
        e.setBairro(this.scanner.nextLine());
        System.out.print("Cidade: ");
        e.setCidade(this.scanner.nextLine());
        System.out.print("Estado: ");
        e.setEstado(this.scanner.nextLine());
        System.out.print("CEP: ");
        e.setCep(this.scanner.nextLine());

        this.veterinarios[indice].setEndereco(e);
        System.out.println("Endereço cadastrado com sucesso!\n");
    }

    public void cadastrarAnimal() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado ainda.\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário que vai atender o animal: ");
        int indice = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indice < 0 || indice >= this.quantidadeVeterinarios) {
            System.out.println("Veterinário inválido.\n");
            return;
        }

        Animal a = new Animal();
        System.out.print("Nome do animal: ");
        a.setNome(this.scanner.nextLine());
        System.out.print("Espécie: ");
        a.setEspecie(this.scanner.nextLine());
        System.out.print("Descrição: ");
        a.setDescricao(this.scanner.nextLine());

        this.veterinarios[indice].adicionarAnimal(a);
        System.out.println("Animal cadastrado com sucesso!\n");
    }

    public void mostrarAnimais() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado ainda.\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário para ver os animais: ");
        int indice = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indice < 0 || indice >= this.quantidadeVeterinarios) {
            System.out.println("Veterinário inválido.\n");
            return;
        }

        Veterinario v = this.veterinarios[indice];
        System.out.println("Animais atendidos por " + v.getNome() + ":");
        for (int i = 0; i < v.getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + v.getAnimais()[i]);
        }
        System.out.println();
    }

    public void cadastrarDono() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado ainda.\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário: ");
        int indiceVet = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indiceVet < 0 || indiceVet >= this.quantidadeVeterinarios) {
            System.out.println("Veterinário inválido.\n");
            return;
        }

        Veterinario v = this.veterinarios[indiceVet];
        if (v.getQuantidadeAnimais() == 0) {
            System.out.println("Esse veterinário não possui animais cadastrados.\n");
            return;
        }

        System.out.println("Animais atendidos por " + v.getNome() + ":");
        for (int i = 0; i < v.getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + v.getAnimais()[i]);
        }
        System.out.print("Escolha o número do animal para cadastrar o dono: ");
        int indiceAnimal = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indiceAnimal < 0 || indiceAnimal >= v.getQuantidadeAnimais()) {
            System.out.println("Animal inválido.\n");
            return;
        }

        Dono d = new Dono();
        System.out.print("Nome do dono: ");
        d.setNome(this.scanner.nextLine());
        System.out.print("CPF do dono: ");
        d.setCpf(this.scanner.nextLine());

        v.getAnimais()[indiceAnimal].setDono(d);
        System.out.println("Dono cadastrado com sucesso!\n");
    }

    public void cadastrarEnderecoDono() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado ainda.\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário: ");
        int indiceVet = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indiceVet < 0 || indiceVet >= this.quantidadeVeterinarios) {
            System.out.println("Veterinário inválido.\n");
            return;
        }

        Veterinario v = this.veterinarios[indiceVet];
        if (v.getQuantidadeAnimais() == 0) {
            System.out.println("Esse veterinário não possui animais cadastrados.\n");
            return;
        }

        System.out.println("Animais atendidos por " + v.getNome() + ":");
        for (int i = 0; i < v.getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + v.getAnimais()[i]);
        }
        System.out.print("Escolha o número do animal para cadastrar o endereço do dono: ");
        int indiceAnimal = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indiceAnimal < 0 || indiceAnimal >= v.getQuantidadeAnimais()) {
            System.out.println("Animal inválido.\n");
            return;
        }

        Animal a = v.getAnimais()[indiceAnimal];
        if (a.getDono() == null) {
            System.out.println("Esse animal ainda não possui dono cadastrado.\n");
            return;
        }

        System.out.println("Dono: " + a.getDono().getNome() + " | CPF: " + a.getDono().getCpf());

        Endereco e = new Endereco();
        System.out.print("Rua: ");
        e.setRua(this.scanner.nextLine());
        System.out.print("Número: ");
        e.setNumero(this.scanner.nextLine());
        System.out.print("Bairro: ");
        e.setBairro(this.scanner.nextLine());
        System.out.print("Cidade: ");
        e.setCidade(this.scanner.nextLine());
        System.out.print("Estado: ");
        e.setEstado(this.scanner.nextLine());
        System.out.print("CEP: ");
        e.setCep(this.scanner.nextLine());

        a.getDono().setEndereco(e);
        System.out.println("Endereço do dono cadastrado com sucesso!\n");
    }
}
