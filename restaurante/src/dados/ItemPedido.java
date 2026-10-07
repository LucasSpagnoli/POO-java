package dados;

import dados.enums.StatusItemPedido;

public class ItemPedido {
    private int quantidade;
    private String observacao;
    private StatusItemPedido statusItem;
    private ItemCardapio itemCardapio;

    public ItemPedido() {
        this.statusItem = StatusItemPedido.AGUARDANDO_PREPARO;
    }

    public ItemPedido(ItemCardapio itemCardapio, int quantidade, String observacao) {
        this();
        this.itemCardapio = itemCardapio;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusItemPedido getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusItemPedido statusItem) {
        this.statusItem = statusItem;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }
}