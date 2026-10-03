package ex1.negocio;

import java.time.*;
import java.util.ArrayList;

import ex1.dados.Animal;
import ex1.dados.Consulta;
import ex1.dados.Dono;
import ex1.dados.Veterinario;

public class Clinica {

    private ArrayList<Animal> animais;
    private ArrayList<Veterinario> veterinarios;
    private ArrayList<Dono> donos;
    private ArrayList<Consulta> consultas;

    public Clinica() {
        animais = new ArrayList<Animal>();
        veterinarios = new ArrayList<Veterinario>();
        donos = new ArrayList<Dono>();
        consultas = new ArrayList<Consulta>();
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public ArrayList<Dono> getDonos() {
        return donos;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void cadastrarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void cadastrarVeterinario(Veterinario veterinario) {
        veterinarios.add(veterinario);
    }

    public void cadastrarDono(Dono dono) {
        donos.add(dono);
    }

    public void marcarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void desmarcarConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    public ArrayList<Consulta> buscarConsultasPorData(LocalDate data) {
        ArrayList<Consulta> resultado = new ArrayList<Consulta>();

        for (int i = 0; i < consultas.size(); i++) {
            Consulta atual = consultas.get(i);

            if (atual.getData().equals(data)) {
                int pos = 0;
                while (pos < resultado.size()
                        && resultado.get(pos).getHorario().isBefore(atual.getHorario())) {
                    pos++;
                }
                resultado.add(pos, atual);
            }
        }

        return resultado;
    }
}
