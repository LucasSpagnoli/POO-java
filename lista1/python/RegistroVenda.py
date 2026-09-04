class RegistroVenda:

    def __init__(self, codigo_venda, cliente, funcionario, livros=None):
        self.codigo_venda = codigo_venda
        self.cliente = cliente
        self.funcionario = funcionario
        self.livros = livros if livros is not None else []

    # Percorre a lista de livros e retorna o valor total da venda
    def calcular_valor_venda(self):
        valor_total = 0.0
        for livro in self.livros:
            valor_total += livro.preco
        return valor_total

    def __str__(self):
        titulos = ", ".join(livro.titulo for livro in self.livros)
        return (f"RegistroVenda(codigo={self.codigo_venda}, "
                f"cliente='{self.cliente.nome}', "
                f"funcionario='{self.funcionario.nome}', "
                f"livros=[{titulos}], "
                f"valorTotal={self.calcular_valor_venda()})")