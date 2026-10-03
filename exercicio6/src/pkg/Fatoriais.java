package pkg;

public class Fatoriais extends Gerador {
    @Override
    public void gerar(int quantidade) {
        limpar();
        int fatorial = 1;
        for (int i = 1; i <= quantidade; i++) {
            fatorial *= i;
            adicionar(fatorial);
        }
    }
}
