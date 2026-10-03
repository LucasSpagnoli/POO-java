package pkg;

import java.util.ArrayList;
import java.util.List;

public abstract class Gerador {
    private List<Integer> sequencia;

    public Gerador() {
        sequencia = new ArrayList<>();
    }

    public abstract void gerar(int quantidade);

    public List<Integer> getSequencia() {
        return sequencia;
    }

    protected void adicionar(int valor) {
        sequencia.add(valor);
    }

    protected void limpar() {
        sequencia.clear();
    }

    protected int somaDivisores(int n) {
        if (n <= 1) {
            return 0;
        }
        int soma = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                soma += i;
                if (i != n / i) {
                    soma += n / i;
                }
            }
        }
        return soma;
    }
}
