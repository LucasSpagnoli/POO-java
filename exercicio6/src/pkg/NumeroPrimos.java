package pkg;

public class NumeroPrimos extends Gerador {
    @Override
    public void gerar(int quantidade) {
        limpar();
        int numero = 1;
        int encontrados = 0;
        while (encontrados < quantidade) {
            numero++;
            if (ehPrimo(numero)) {
                adicionar(numero);
                encontrados++;
            }
        }
    }

    private boolean ehPrimo(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
