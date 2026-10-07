package dados;

import dados.enums.CategoriaItem;

import java.util.ArrayList;
import java.util.List;

public class ComboPromocional extends ItemCardapio {
    private List<ItemCardapio> itens;

    public ComboPromocional() {
        super();
        this.itens = new ArrayList<>();
    }

    public ComboPromocional(int codigo, String nome, String descricao, double preco, int tempoMedioPreparo, boolean disponivel, CategoriaItem categoria) {
        super(codigo, nome, descricao, preco, tempoMedioPreparo, disponivel, categoria);
        this.itens = new ArrayList<>();
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public void setItens(List<ItemCardapio> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public void removerItem(ItemCardapio item) {
        this.itens.remove(item);
    }
}