package br.com.fiap.compras.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @SequenceGenerator(name = "produto", sequenceName = "produto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "nm_produto", length = 100)
    private String nomeProduto;

    @Column(name = "ds_peso")
    private Double descricaoPeso;

    @Column(name = "qtd_disponivel")
    private Integer quantidadeDisponivel;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> idItemPedido = new ArrayList<>();

    public Produto(Long idProduto, String nomeProduto, Double descricaoPeso, Integer quantidadeDisponivel) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoPeso = descricaoPeso;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Produto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getIdProduto(), produto.getIdProduto()) && Objects.equals(getNomeProduto(), produto.getNomeProduto()) && Objects.equals(getDescricaoPeso(), produto.getDescricaoPeso()) && Objects.equals(getQuantidadeDisponivel(), produto.getQuantidadeDisponivel()) && Objects.equals(idItemPedido, produto.idItemPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProduto(), getNomeProduto(), getDescricaoPeso(), getQuantidadeDisponivel(), idItemPedido);
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getDescricaoPeso() {
        return descricaoPeso;
    }

    public void setDescricaoPeso(Double limiteCartao) {
        this.descricaoPeso = limiteCartao;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public List<ItemPedido> getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(List<ItemPedido> itemPedido) {
        this.idItemPedido = itemPedido;
    }
}
