class Cliente:

    def __init__(self, nome, cpf, email, telefone="Não informado"):
        self.nome = nome
        self.cpf = cpf
        self.email = email
        self.telefone = telefone

    def __str__(self):
        return (f"Cliente(nome='{self.nome}', cpf='{self.cpf}', "
                f"email='{self.email}', telefone='{self.telefone}')")