package negocio;

import dados.ContaBancaria;
import dados.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    List<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();

    public void cadastrarConta(ContaBancaria conta) {
        contasBancarias.add(conta);
    }

    public void realizarSaque(ContaBancaria conta, float valor) {
        conta.sacar(valor);
    }

    public void realizarDeposito(ContaCorrente conta, float valor) {
        conta.sacar(valor);
    }
}
