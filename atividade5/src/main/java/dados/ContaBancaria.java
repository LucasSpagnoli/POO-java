package dados;

public class ContaBancaria {
    protected String cpf;
    protected float saldo;

    public float sacar(float valor){
        if(saldo>=valor){
            saldo-=valor;
            return valor;
        }
        return 0;
    }

    public String gerarExtrato(){

    }
}

