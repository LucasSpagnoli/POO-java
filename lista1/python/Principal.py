from cliente import Cliente
from funcionario import Funcionario
from livro import Livro
from registro_venda import RegistroVenda


def main():
    print("TESTANDO A CLASSE CLIENTE")
    cliente1 = Cliente("Fabiano Baldo", "123.456.789-00", "baldo@email.com", "(47) 99999-0001")
    cliente2 = Cliente("Vinicius Takeo Friedrich Kuwaki", "987.654.321-00", "takeo@email.com")
    print(cliente1)
    print(cliente2)

    print("\nTESTANDO A CLASSE FUNCIONARIO")
    funcionario1 = Funcionario("Vinicius Kruger", "111.222.333-44", "Vendedor", 2200.0)
    funcionario2 = Funcionario("Lucas Spagnoli", "555.666.777-88", "Caixa")
    print(funcionario1)
    print(funcionario2)

    print("\nTESTANDO A CLASSE LIVRO")
    livro1 = Livro("Harry Potter", "J. K. Rowling", "978-0132350884", 120.90)
    livro2 = Livro("Cartas de um Diabo a seu aprendiz", "C. S. Lewis", "978-0134685991", 89.90)
    livro3 = Livro("Harry Potter", "J. K. Rowling", "978-0132350884", 120.90)
    print(livro1)
    print(livro2)
    print(livro3)

    print()
    print("livro1 é igual a livro2?", livro1 == livro2)  # False (ISBNs diferentes)
    print("livro1 é igual a livro3?", livro1 == livro3)  # True (mesmo ISBN)

    print("\nTESTANDO A CLASSE REGISTROVENDA")
    venda1 = RegistroVenda(1, cliente1, funcionario1, [livro1, livro2])
    print(venda1)
    print(f"Valor total da venda 1: R$ {venda1.calcular_valor_venda()}")

    venda2 = RegistroVenda(2, cliente2, funcionario2, [livro1, livro3, livro2])
    print(venda2)
    print(f"Valor total da venda 2: R$ {venda2.calcular_valor_venda()}")


if __name__ == "__main__":
    main()