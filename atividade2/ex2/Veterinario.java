package atividade2.ex2;


public class Veterinario {
    private String nome;
    private float salario;
    private Endereco endereco;
    private Animal[] animais = new Animal[10];
    private int quantidadeAnimais = 0;

    public Veterinario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Animal[] getAnimais() {
        return animais;
    }

    public void setAnimais(Animal[] animais) {
        this.animais = animais;
    }

    public int getQuantidadeAnimais() {
        return quantidadeAnimais;
    }

    public void setQuantidadeAnimais(int quantidadeAnimais) {
        this.quantidadeAnimais = quantidadeAnimais;
    }

    public void adicionarAnimal(Animal a) {
        if (this.quantidadeAnimais < this.animais.length) {
            this.animais[this.quantidadeAnimais] = a;
            this.quantidadeAnimais++;
        } else {
            System.out.println("Não há mais posições disponíveis para animais.");
        }
    }

    public String toString() {
        return "Nome: " + nome + " | Salário: " + salario;
    }
}
