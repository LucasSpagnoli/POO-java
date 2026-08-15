package atividade2.ex2;


import java.util.Scanner;

public class SistemaPetShop {
    private Veterinario[] veterinarios = new Veterinario[10];
    private int quantidadeVeterinarios = 0;
    private Scanner scanner;

    public SistemaPetShop(Scanner scanner) {
        this.scanner = scanner;
    }

    public void cadastrarVeterinario() {
        Veterinario v = new Veterinario();

        System.out.print("digite o nome do veterinario ");
        v.setNome(this.scanner.nextLine());

        System.out.print("digite o salario do veterinario ");
        v.setSalario(this.scanner.nextFloat());
        this.scanner.nextLine();

        if (this.quantidadeVeterinarios < this.veterinarios.length) {
            this.veterinarios[this.quantidadeVeterinarios] = v;
            this.quantidadeVeterinarios++;
            System.out.println("veterinario cadastrado com sucesso\n");
        } else {
            System.out.println("nao ha mais posicoes disponiveis para veterinarios\n");
        }
    }

    public void mostrarVeterinarios() {
        System.out.println("listagem de veterinarios");
        for (int i = 0; i < this.quantidadeVeterinarios; i++) {
            System.out.println(i + " - " + this.veterinarios[i]);
        }
        System.out.println();
    }

    public void cadastrarEnderecoVeterinario() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("nenhum veterinario cadastrado ainda\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("escolha o numero do veterinario para cadastrar o endereco ");
        int indice = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indice < 0 || indice >= this.quantidadeVeterinarios) {
            System.out.println("veterinario invalido\n");
            return;
        }

        Endereco e = new Endereco();
        System.out.print("rua ");
        e.setRua(this.scanner.nextLine());
        System.out.print("numero ");
        e.setNumero(this.scanner.nextLine());
        System.out.print("bairro ");
        e.setBairro(this.scanner.nextLine());
        System.out.print("cidade ");
        e.setCidade(this.scanner.nextLine());
        System.out.print("estado ");
        e.setEstado(this.scanner.nextLine());
        System.out.print("cep ");
        e.setCep(this.scanner.nextLine());

        this.veterinarios[indice].setEndereco(e);
        System.out.println("endereco cadastrado com sucesso\n");
    }

    public void cadastrarAnimal() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("nenhum veterinario cadastrado ainda\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("escolha o numero do veterinario que vai atender o animal ");
        int indice = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indice < 0 || indice >= this.quantidadeVeterinarios) {
            System.out.println("veterinario invalido\n");
            return;
        }

        Animal a = new Animal();
        System.out.print("nome do animal ");
        a.setNome(this.scanner.nextLine());
        System.out.print("especie ");
        a.setEspecie(this.scanner.nextLine());
        System.out.print("descricao ");
        a.setDescricao(this.scanner.nextLine());

        this.veterinarios[indice].adicionarAnimal(a);
        System.out.println("animal cadastrado com sucesso\n");
    }

    public void mostrarAnimais() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("nenhum veterinario cadastrado ainda\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("escolha o numero do veterinario para ver os animais ");
        int indice = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indice < 0 || indice >= this.quantidadeVeterinarios) {
            System.out.println("veterinario invalido\n");
            return;
        }

        Veterinario v = this.veterinarios[indice];
        System.out.println("animais atendidos por " + v.getNome());
        for (int i = 0; i < v.getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + v.getAnimais()[i]);
        }
        System.out.println();
    }

    public void cadastrarDono() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("nenhum veterinario cadastrado ainda\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("escolha o numero do veterinario ");
        int indiceVet = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indiceVet < 0 || indiceVet >= this.quantidadeVeterinarios) {
            System.out.println("veterinario invalido\n");
            return;
        }

        Veterinario v = this.veterinarios[indiceVet];
        if (v.getQuantidadeAnimais() == 0) {
            System.out.println("esse veterinario nao possui animais cadastrados\n");
            return;
        }

        System.out.println("animais atendidos por " + v.getNome());
        for (int i = 0; i < v.getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + v.getAnimais()[i]);
        }
        System.out.print("escolha o numero do animal para cadastrar o dono ");
        int indiceAnimal = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indiceAnimal < 0 || indiceAnimal >= v.getQuantidadeAnimais()) {
            System.out.println("animal invalido\n");
            return;
        }

        Dono d = new Dono();
        System.out.print("nome do dono ");
        d.setNome(this.scanner.nextLine());
        System.out.print("cpf do dono ");
        d.setCpf(this.scanner.nextLine());

        v.getAnimais()[indiceAnimal].setDono(d);
        System.out.println("dono cadastrado com sucesso\n");
    }

    public void cadastrarEnderecoDono() {
        if (this.quantidadeVeterinarios == 0) {
            System.out.println("nenhum veterinario cadastrado ainda\n");
            return;
        }

        this.mostrarVeterinarios();
        System.out.print("escolha o numero do veterinario ");
        int indiceVet = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indiceVet < 0 || indiceVet >= this.quantidadeVeterinarios) {
            System.out.println("veterinario invalido\n");
            return;
        }

        Veterinario v = this.veterinarios[indiceVet];
        if (v.getQuantidadeAnimais() == 0) {
            System.out.println("esse veterinario nao possui animais cadastrados\n");
            return;
        }

        System.out.println("animais atendidos por " + v.getNome());
        for (int i = 0; i < v.getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + v.getAnimais()[i]);
        }
        System.out.print("escolha o numero do animal para cadastrar o endereco do dono ");
        int indiceAnimal = this.scanner.nextInt();
        this.scanner.nextLine();

        if (indiceAnimal < 0 || indiceAnimal >= v.getQuantidadeAnimais()) {
            System.out.println("animal invalido\n");
            return;
        }

        Animal a = v.getAnimais()[indiceAnimal];
        if (a.getDono() == null) {
            System.out.println("esse animal ainda nao possui dono cadastrado\n");
            return;
        }

        System.out.println("dono " + a.getDono().getNome() + " | cpf " + a.getDono().getCpf());

        Endereco e = new Endereco();
        System.out.print("rua ");
        e.setRua(this.scanner.nextLine());
        System.out.print("numero ");
        e.setNumero(this.scanner.nextLine());
        System.out.print("bairro ");
        e.setBairro(this.scanner.nextLine());
        System.out.print("cidade ");
        e.setCidade(this.scanner.nextLine());
        System.out.print("estado ");
        e.setEstado(this.scanner.nextLine());
        System.out.print("cep ");
        e.setCep(this.scanner.nextLine());

        a.getDono().setEndereco(e);
        System.out.println("endereco do dono cadastrado com sucesso\n");
    }
}