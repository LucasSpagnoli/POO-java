import java.util.Arrays;

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
        this.codigoVenda = codigoVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.livros = new Livro[0];
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

    @Override
    public String toString() {
        return "RegistroVenda{" +
                "codigoVenda=" + codigoVenda +
                ", cliente=" + cliente +
                ", funcionario=" + funcionario +
                ", livros=" + Arrays.toString(livros) +
                '}';
    }
}