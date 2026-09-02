package dados;

import java.util.Objects;

public class Contato {
    private int nome;
    private String telefone;

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Contato contato) {
            Contato c = (Contato) o;
            if (this.telefone == c.getTelefone() && this.nome == c.getNome()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome=" + nome +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
