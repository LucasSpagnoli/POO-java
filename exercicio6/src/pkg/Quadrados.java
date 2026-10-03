package pkg;

public class Quadrados extends Gerador {
    @Override
    public void gerar(int quantidade) {
        limpar();
        for (int i = 1; i <= quantidade; i++) {
            adicionar(i * i);
        }
    }
}
