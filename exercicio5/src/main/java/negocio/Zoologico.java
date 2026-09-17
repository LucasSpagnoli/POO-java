package negocio;

import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private List<Viveiro> viveiros;
    private List<Animal> animais;

    public void cadastrarViveiro(Viveiro viveiro) {
        this.viveiros.add(viveiro);
    }

    public void cadastrarAnimais(Animal animal) {
        this.animais.add(animal);
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro) {
        if (animal instanceof Peixe) {
            if (viveiro instanceof Aquario) {
                if (Math.abs(((Peixe) animal).getTemperaturaIdeal() - ((Aquario) viveiro).getTemperatura())>3) {
                    return viveiro.adicionarAnimal(animal);
                }
            }
            return false;
        } else if (viveiro instanceof Aquario) {
            return false;
        } else {
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
