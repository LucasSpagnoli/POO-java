package pkg;

public class Fibonacci extends Gerador {
    @Override
    public void gerar(int quantidade) {
        limpar();
        int anterior = 0;
        int atual = 1;
        for (int i = 0; i < quantidade; i++) {
            adicionar(anterior);
            int proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }
    }
}
