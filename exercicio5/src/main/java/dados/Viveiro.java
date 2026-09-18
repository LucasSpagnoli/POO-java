package dados;

import java.util.ArrayList;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected ArrayList<Animal> animais = new ArrayList<>();

    @Override
    public String toString() {
        return "Viveiro{" +
                "nome='" + nome + '\'' +
                ", comprimento=" + comprimento +
                ", largura=" + largura +
                ", animais=" + animais +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
    }

    public float calculaEspaco() {
        return comprimento * largura;
    }

    private float espacoOcupado() {
        float espacoOcupadoAnimais = 0;
        for (int i = 0; i < animais.toArray().length; i++) {
            espacoOcupadoAnimais += animais.get(i).calculaEspacoOcupado();
        }

        return espacoOcupadoAnimais;
    }

    private float espacoDisponivel() {
        return this.calculaEspaco() - this.espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal) {
        float espacoOcupadoPeloAnimal = animal.calculaEspacoOcupado();
        if (espacoDisponivel() > espacoOcupadoPeloAnimal * 0.7) {
            animais.add(animal);
            return true;
        }
        return false;
    }
}
