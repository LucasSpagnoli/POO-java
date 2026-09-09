package dados;

public class ContaCorrente extends ContaBancaria {
    public boolean depositar(float valor) {
        if (saldo > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }
}
