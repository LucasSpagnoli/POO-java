package ex1.dados;

import java.util.ArrayList;

public class Dono {

    private String nome;
    private String cpf;
    private ArrayList<Animal> animais;

    public Dono(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.animais = new ArrayList<Animal>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public void cadastrarAnimal(Animal animal) {
        animais.add(animal);
    }

    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }
}
