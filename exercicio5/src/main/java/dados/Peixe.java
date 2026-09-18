package dados;

public class Peixe extends Animal {
    private float temperaturaIdeal;

    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    @Override
    public float calculaEspacoOcupado(){
        return this.getAltura() * this.getComprimento() * this.getLargura();
    }
}
