class Musico:

    def __init__(self, nome, idade):
        self.__nome = nome
        self.__idade = idade
        self.__instrumentos = []

    def get_nome(self):
        return self.__nome

    def get_idade(self):
        return self.__idade

    def get_instrumentos(self):
        return self.__instrumentos

    def adicionar_instrumento(self, instrumento):
        if len(self.__instrumentos) < 2 and instrumento not in self.__instrumentos:
            self.__instrumentos.append(instrumento)
            return True
        return False
