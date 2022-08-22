package br.com.fiap.compras.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido {

    @Id
    @SequenceGenerator(name = "itemPedido", sequenceName = "sq_tb_pedido", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemPedido")
    @Column(name = "id_item_pedido")
    private Long idItemPedido;

    @Column(name = "ds_quantidade")
    private Integer descricaoQuantidade;

    @Column(name = "ds_preco")
    private Double descricaoPreco;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;


    public ItemPedido(Long idItemPedido, Integer descricaoQuantidade, Double descricaoPreco, Pedido pedido) {
        this.idItemPedido = idItemPedido;
        this.descricaoQuantidade = descricaoQuantidade;
        this.descricaoPreco = descricaoPreco;
        this.pedido = pedido;
    }

    public ItemPedido() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(getIdItemPedido(), that.getIdItemPedido()) && Objects.equals(getDescricaoQuantidade(), that.getDescricaoQuantidade()) && Objects.equals(getDescricaoPreco(), that.getDescricaoPreco()) && Objects.equals(pedido, that.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdItemPedido(), getDescricaoQuantidade(), getDescricaoPreco(), pedido);
    }

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public Integer getDescricaoQuantidade() {
        return descricaoQuantidade;
    }

    public void setDescricaoQuantidade(Integer descricaoQuantidade) {
        this.descricaoQuantidade = descricaoQuantidade;
    }

    public Double getDescricaoPreco() {
        return descricaoPreco;
    }

    public void setDescricaoPreco(Double descricaoPreco) {
        this.descricaoPreco = descricaoPreco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}