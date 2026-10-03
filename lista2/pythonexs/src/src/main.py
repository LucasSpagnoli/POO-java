from instrumento import Instrumento
from musico import Musico
from escola_musica import EscolaMusica


def criar_musico(nome, idade, instrumento1, instrumento2):
    musico = Musico(nome, idade)
    musico.adicionar_instrumento(instrumento1)
    musico.adicionar_instrumento(instrumento2)
    return musico


escola = EscolaMusica()

escola.adicionar_musico(criar_musico("Ana", 17, Instrumento.GUITARRA, Instrumento.BAIXO))
escola.adicionar_musico(criar_musico("Bruno", 19, Instrumento.BATERIA, Instrumento.TECLADO))
escola.adicionar_musico(criar_musico("Carla", 22, Instrumento.VIOLAO, Instrumento.SAXOFONE))
escola.adicionar_musico(criar_musico("Diego", 16, Instrumento.GUITARRA, Instrumento.BATERIA))
escola.adicionar_musico(criar_musico("Elisa", 20, Instrumento.BAIXO, Instrumento.TECLADO))
escola.adicionar_musico(criar_musico("Felipe", 18, Instrumento.SAXOFONE, Instrumento.VIOLAO))
escola.adicionar_musico(criar_musico("Gabi", 21, Instrumento.GUITARRA, Instrumento.TECLADO))
escola.adicionar_musico(criar_musico("Hugo", 15, Instrumento.BATERIA, Instrumento.SAXOFONE))
escola.adicionar_musico(criar_musico("Iara", 23, Instrumento.BAIXO, Instrumento.VIOLAO))

escola.formar_bandas()

for banda in escola.get_bandas():
    print("===", banda.get_nome(), "===")
    for musico in banda.get_musicos():
        nomes_instrumentos = []
        for instrumento in musico.get_instrumentos():
            nomes_instrumentos.append(instrumento.value)
        print("-", musico.get_nome(), "(" + str(musico.get_idade()), "anos):", ", ".join(nomes_instrumentos))
    print()
