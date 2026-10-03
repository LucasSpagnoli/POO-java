from banda import Banda


class EscolaMusica:

    def __init__(self):
        self.__bandas = []
        self.__alunos = []

    def get_bandas(self):
        return self.__bandas

    def get_alunos(self):
        return self.__alunos

    def adicionar_musico(self, musico):
        self.__alunos.append(musico)

    def formar_bandas(self):
        self.__bandas = [Banda("Banda 1"), Banda("Banda 2"), Banda("Banda 3")]

        for musico in self.__alunos:
            melhor = self.__bandas[0]
            melhor_comum = melhor.quantidade_em_comum(musico)

            for banda in self.__bandas:
                comum = banda.quantidade_em_comum(musico)

                if comum < melhor_comum:
                    melhor = banda
                    melhor_comum = comum
                elif comum == melhor_comum and len(banda.get_musicos()) < len(melhor.get_musicos()):
                    melhor = banda

            melhor.adicionar_musico(musico)
