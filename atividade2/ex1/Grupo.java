package atividade2.ex1;

public class Grupo {
    Pessoa[] ps = new Pessoa[3];
    private int numPessoas = 0;

    public void setPessoa(Pessoa p) {
        if (this.numPessoas < ps.length) {
            ps[this.numPessoas] = p;
            this.numPessoas++;
        } else {
            System.out.println("Não há mais posições disponíveis no array.");
        }
    }

    public void ordenar() {
        for (int i = 0; i < numPessoas; i++) {
            for (int j = i + 1; j < ps.length; j++) {
                if (this.ps[i].getIMC() > this.ps[j].getIMC()) {
                    Pessoa temp = this.ps[i];
                    this.ps[i] = this.ps[j];
                    this.ps[j] = temp;
                }
            }
        }
    }

    public void imprimirPessoas() {
        System.out.println("Listagem de pessoas: ");
        this.ordenar();
        for (int i = 0; i < numPessoas; i++) {
            if (ps[i] != null)
                System.out.println("\n" + ps[i]);
        }
    }

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Lucas", 19, 1.70f, 58f);
        Pessoa p2 = new Pessoa("Murilo", 17, 1.60f, 50f);
        Pessoa p3 = new Pessoa("Tiago", 12, 1.50f, 40f);

        Grupo grupo = new Grupo();
        grupo.setPessoa(p1);
        grupo.setPessoa(p2);
        grupo.setPessoa(p3);

        grupo.imprimirPessoas();
    }
}
