package dados;

import java.util.Objects;

public class Cidade {
    private String nome;
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cidade cidade)) return false;
        return Objects.equals(nome, cidade.nome) && Objects.equals(estado, cidade.estado);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
