package dados;

public class Cliente {
    private int cpf;
    private String nomme;
    private String endereco;
    private int telefone;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNomme() {
        return nomme;
    }

    public void setNomme(String nomme) {
        this.nomme = nomme;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf=" + cpf +
                ", nomme='" + nomme + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                '}';
    }

    public void reservarIda(Reserva reserva) {

    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        
    }
}
