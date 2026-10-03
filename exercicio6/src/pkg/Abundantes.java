package pkg;

public class Abundantes extends Gerador {
    @Override
    public void gerar(int quantidade) {
        limpar();
        int numero = 1;
        int encontrados = 0;
        while (encontrados < quantidade) {
            numero++;
            if (somaDivisores(numero) > numero) {
                adicionar(numero);
                encontrados++;
            }
        }
    }
}
