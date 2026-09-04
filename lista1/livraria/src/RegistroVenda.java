public class RegistroVenda {

    private int codigoVenda;
    private Cliente cliente;
    private Funcionario funcionario;
    private Livro[] livros;

    public RegistroVenda(int codigoVenda, Cliente cliente, Funcionario funcionario, Livro[] livros) {
        this.codigoVenda = codigoVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.livros = livros;
    }

    public RegistroVenda(int codigoVenda, Cliente cliente, Funcionario funcionario) {
        this(codigoVenda, cliente, funcionario, new Livro[0]);
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    public double calcularValorVenda() {
        double valorTotal = 0.0;
        for (Livro livro : livros) {
            valorTotal += livro.getPreco();
        }
        return valorTotal;
    }

    public boolean possuiLivrosRepetidos() {
        for (int i = 0; i < livros.length; i++) {
            for (int j = i + 1; j < livros.length; j++) {
                if (livros[i].equals(livros[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegistroVenda{")
                .append("codigoVenda=").append(codigoVenda)
                .append(", cliente=").append(cliente.getNome())
                .append(", funcionario=").append(funcionario.getNome())
                .append(", livros=[");

        for (int i = 0; i < livros.length; i++) {
            sb.append(livros[i].getTitulo());
            if (i < livros.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("], valorTotal=").append(calcularValorVenda())
                .append(", possuiLivrosRepetidos=").append(possuiLivrosRepetidos())
                .append('}');

        return sb.toString();
    }
}