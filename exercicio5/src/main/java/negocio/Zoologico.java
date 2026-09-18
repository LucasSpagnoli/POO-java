package negocio;

import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private List<Viveiro> viveiros = new ArrayList<>();
    private List<Animal> animais = new ArrayList<>();

    public void cadastrarViveiro(Viveiro viveiro) {
        this.viveiros.add(viveiro);
    }

    public void cadastrarAnimais(Animal animal) {
        this.animais.add(animal);
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro) {
        if (animal instanceof Peixe) {
            if (!(viveiro instanceof Aquario)) {
                return false; // peixe só entra em aquário
            }
            Peixe peixe = (Peixe) animal;
            Aquario aquario = (Aquario) viveiro;
            if (Math.abs(peixe.getTemperaturaIdeal() - aquario.getTemperatura()) > 3) {
                return false; // temperatura incompatível
            }
            return viveiro.adicionarAnimal(animal);
        } else {
            if (viveiro instanceof Aquario) {
                return false; // só peixe entra em aquário
            }
            return viveiro.adicionarAnimal(animal);
        }
    }
    public Aquario[] getAquarios() {
        List<Aquario> aquarios = new ArrayList<>();
        for (Viveiro viveiro : viveiros) {
            if (viveiro instanceof Aquario) {
                aquarios.add((Aquario) viveiro);
            }
        }
        return aquarios.toArray(new Aquario[0]);
    }

    public Viveiro[] getViveiro() {
        List<Viveiro> soViveiros = new ArrayList<>();
        for (Viveiro viveiro : viveiros) {
            if (!(viveiro instanceof Aquario)) {
                soViveiros.add(viveiro);
            }
        }
        return soViveiros.toArray(new Viveiro[0]);
    }
}
