package dados;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    @Override
    public String toString() {
        return "Aquario{" +
                "altura=" + altura +
                ", temperatura=" + temperatura +
                ", animais=" + animais +
                '}';
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float calculaEspaco() {
        return this.getComprimento() * this.getLargura() * this.altura;
    }
}
