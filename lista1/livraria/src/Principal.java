public class Principal {

    public static void main(String[] args) {

        System.out.println("TESTANDO A CLASSE CLIENTE");

        Cliente cliente1 = new Cliente("Fabiano Baldo", "123.456.789-00", "baldo@email.com", "(47) 99999-0001");

        Cliente cliente2 = new Cliente("Vinicius Takeo Friedrich Kuwaki", "987.654.321-00", "takeo@email.com");

        System.out.println(cliente1);
        System.out.println(cliente2);

        cliente2.setTelefone("(47) 98888-0002");
        cliente2.setEmail("vinicius@email.com");
        System.out.println("Telefone atualizado do cliente 2: " + cliente2.getTelefone());
        System.out.println(cliente2);

        System.out.println("\nTESTANDO A CLASSE FUNCIONARIO");

        Funcionario funcionario1 = new Funcionario("Vinicius Kruger", "111.222.333-44", "Vendedor", 2200.0);

        Funcionario funcionario2 = new Funcionario("Lucas Spagnoli", "555.666.777-88", "Caixa");

        System.out.println(funcionario1);
        System.out.println(funcionario2);

        funcionario2.setSalario(1800.0);
        funcionario2.setCargo("Gerente de Caixa");
        System.out.println("Novo cargo/salário do funcionário 2: " + funcionario2.getCargo() + " | " + funcionario2.getSalario());
        System.out.println(funcionario2);

        System.out.println("\nTESTANDO A CLASSE LIVRO");

        Livro livro1 = new Livro("Harry Potter", "J. K. Rowling", "978-0132350884", 120.90);

        Livro livro2 = new Livro("Cartas de um Diabo a seu aprendiz", "C. S. Lewis", "978-0134685991");

        Livro livro3 = new Livro("Harry Potter", "J. K. Rowling", "978-0132350884", 120.90);

        System.out.println(livro1);
        System.out.println(livro2);
        System.out.println(livro3);

        livro2.setPreco(150.50);
        System.out.println("Preço atualizado do livro 2: " + livro2.getPreco());
        System.out.println(livro2);

        System.out.println();
        System.out.println("livro1 é igual a livro2? " + livro1.equals(livro2)); // false (ISBNs diferentes)
        System.out.println("livro1 é igual a livro3? " + livro1.equals(livro3)); // true (mesmo ISBN)

        System.out.println();
        System.out.println("TESTANDO A CLASSE REGISTROVENDA");

        Livro[] livrosVenda1 = {livro1, livro2};
        RegistroVenda venda1 = new RegistroVenda(1, cliente1, funcionario1, livrosVenda1);

        RegistroVenda venda2 = new RegistroVenda(2, cliente2, funcionario2);
        Livro[] livrosVenda2 = {livro1, livro3, livro2};
        venda2.setLivros(livrosVenda2);

        System.out.println(venda1);
        System.out.println("Valor total da venda 1: R$ " + venda1.calcularValorVenda());

        System.out.println(venda2);
        System.out.println("Valor total da venda 2: R$ " + venda2.calcularValorVenda());

        venda2.setFuncionario(funcionario1);
        System.out.println("Funcionário atualizado da venda 2: " + venda2.getFuncionario().getNome());

        System.out.println();
        System.out.println("TESTANDO O METODO POSSUILIVROSREPETIDOS()");

        if (venda1.possuiLivrosRepetidos()) {
            System.out.println("Venda 1: o cliente " + venda1.getCliente().getNome() + " possui direito ao desconto.");
        } else {
            System.out.println("Venda 1: o cliente " + venda1.getCliente().getNome() + " NAO possui direito ao desconto.");
        }

        if (venda2.possuiLivrosRepetidos()) {
            System.out.println("Venda 2: o cliente " + venda2.getCliente().getNome() + " possui direito ao desconto.");
        } else {
            System.out.println("Venda 2: o cliente " + venda2.getCliente().getNome() + " NAO possui direito ao desconto.");
        }
    }
}