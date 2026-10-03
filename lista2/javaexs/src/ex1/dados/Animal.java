package ex1.dados;

public class Animal {

    private String nome;
    private String especie;
    private int idade;
    private Dono dono;

    public Animal(String nome, String especie, int idade, Dono dono) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public String toString() {
        String nomeDono = "sem dono";
        if (dono != null) {
            nomeDono = dono.getNome();
        }
        return nome + " (" + especie + ", " + idade + " anos) - Dono: " + nomeDono;
    }
}
