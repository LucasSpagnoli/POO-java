class Banda:

    def __init__(self, nome):
        self.__nome = nome
        self.__musicos = []

    def get_nome(self):
        return self.__nome

    def get_musicos(self):
        return self.__musicos

    def adicionar_musico(self, musico):
        self.__musicos.append(musico)

    def quantidade_em_comum(self, musico):
        instrumentos_da_banda = []
        for integrante in self.__musicos:
            for instrumento in integrante.get_instrumentos():
                instrumentos_da_banda.append(instrumento)

        em_comum = 0
        for instrumento in musico.get_instrumentos():
            if instrumento in instrumentos_da_banda:
                em_comum = em_comum + 1
        return em_comum
