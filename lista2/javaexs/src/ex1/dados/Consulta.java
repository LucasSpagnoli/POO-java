package ex1.dados;

import java.time.*;

public class Consulta {

    private int codigo;
    private LocalDate data;
    private LocalTime horario;
    private Veterinario veterinario;
    private Animal paciente;

    public Consulta(int codigo, LocalDate data, LocalTime horario) {
        this.codigo = codigo;
        this.data = data;
        this.horario = horario;
    }

    public void alocarAnimal(Animal animal) {
        this.paciente = animal;
    }

    public void alocarVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public Animal getPaciente() {
        return paciente;
    }

    public String toString() {
        return "Consulta " + codigo + " - " + data + " às " + horario
                + " | Animal: " + paciente.getNome()
                + " | Veterinário: " + veterinario.getNome();
    }
}
