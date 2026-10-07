package dados;

import dados.enums.CategoriaItem;

public class ItemCardapio {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int tempoMedioPreparo;
    private boolean disponivel;
    private CategoriaItem categoria;

    public ItemCardapio() {}

    public ItemCardapio(int codigo, String nome, String descricao, double preco, int tempoMedioPreparo, boolean disponivel, CategoriaItem categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tempoMedioPreparo = tempoMedioPreparo;
        this.disponivel = disponivel;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTempoMedioPreparo() {
        return tempoMedioPreparo;
    }

    public void setTempoMedioPreparo(int tempoMedioPreparo) {
        this.tempoMedioPreparo = tempoMedioPreparo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public CategoriaItem getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaItem categoria) {
        this.categoria = categoria;
    }
}