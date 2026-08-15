package atividade2.ex1;

public class Pessoa {
    private String nome;
    private int idade;
    private float altura;
    private float massa;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String nome, int idade, float altura, float massa) {
        this.nome = nome;
        this.idade = idade;
        this.massa = massa;
        this.altura = altura;
    }

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getidade() {
        return idade;
    }

    public void setidade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getMassa() {
        return massa;
    }

    public void setMassa(float massa) {
        this.massa = massa;
    }

    public float getIMC() {
        float imc = this.massa / (this.altura * this.altura);
        return imc;
    }

    public String toString() {
        return "nome: " + nome + " | Idade: " + idade + " | Altura: " + altura + " | Massa: " + massa + " | IMC: "
                + getIMC();
    }

    public boolean equals(Object o) {
        if (o instanceof Pessoa) {
            Pessoa p = (Pessoa) o;
            if (this.nome.equals(p.getNome()) && this.idade == p.getidade()) {
                return true;
            }
        }
        return false;
    }

    
}