class Livro:

    def __init__(self, titulo, autor, isbn, preco=0.0):
        self.titulo = titulo
        self.autor = autor
        self.isbn = isbn
        self.preco = preco

    def __str__(self):
        return (f"Livro(titulo='{self.titulo}', autor='{self.autor}', "
                f"isbn='{self.isbn}', preco={self.preco})")

    # Dois livros são considerados iguais quando possuem o mesmo ISBN
    def __eq__(self, outro):
        if not isinstance(outro, Livro):
            return False
        return self.isbn == outro.isbn

    # Necessário sobrescrever também para manter a consistência com __eq__
    def __hash__(self):
        return hash(self.isbn)