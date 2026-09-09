package dados;

public class ContaSalario extends ContaBancaria {
    private String cnpjEmpresa;

    public ContaSalario(String cnpj) {
        this.cnpjEmpresa = cnpj;
    }

    public boolean depositar(float valor, String cnpj) {
        if (cnpjEmpresa.equals(cnpj) && valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public String gerarExtrato(){
        return "";
    }
}
