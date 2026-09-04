class Funcionario:

    def __init__(self, nome, cpf, cargo, salario=1500.0):
        self.nome = nome
        self.cpf = cpf
        self.cargo = cargo
        self.salario = salario

    def __str__(self):
        return (f"Funcionario(nome='{self.nome}', cpf='{self.cpf}', "
                f"cargo='{self.cargo}', salario={self.salario})")