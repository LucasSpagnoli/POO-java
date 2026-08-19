package dados;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo;
    private float preco;
    private String classeVoo;
    private boolean idaEvolta;
    private int poltrona;

    @Override
    public String toString() {
        return "Reserva{" +
                "numReserva=" + numReserva +
                ", dataVoo='" + dataVoo + '\'' +
                ", horaVoo='" + horaVoo + '\'' +
                ", preco=" + preco +
                ", classeVoo='" + classeVoo + '\'' +
                ", idaEvolta=" + idaEvolta +
                ", poltrona=" + poltrona +
                '}';
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public String getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public String getHoraVoo() {
        return horaVoo;
    }

    public void setHoraVoo(String horaVoo) {
        this.horaVoo = horaVoo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }

    public boolean isIdaEvolta() {
        return idaEvolta;
    }

    public void setIdaEvolta(boolean idaEvolta) {
        this.idaEvolta = idaEvolta;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }
}
