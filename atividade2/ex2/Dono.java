package atividade2.ex2;

public class Dono {
    private String nome;
    private Endereco endereco;
    private String cpf;

    public Dono() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String toString() {
        String enderecoStr = (this.endereco != null) ? this.endereco.toString() : "não cadastrado";
        return "Nome: " + nome + " | CPF: " + cpf + " | Endereço: " + enderecoStr;
    }
}
