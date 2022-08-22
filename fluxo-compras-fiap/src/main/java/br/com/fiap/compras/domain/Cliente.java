package br.com.fiap.compras.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @SequenceGenerator(name = "cliente", sequenceName = "cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nm_cliente", length = 50)
    private String nomeCliente;

    @Column(name = "ds_limite_cartao")
    private Double limiteCartao;

    @Column(name = "num_cartao")
    private Integer numeroCartao;

    @Column(name = "num_telefone")
    private Integer telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedido = new ArrayList<>();

    public Cliente(Long idCliente, String nomeCliente, Double limiteCartao, Integer numeroCartao, Integer telefone) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.limiteCartao = limiteCartao;
        this.numeroCartao = numeroCartao;
        this.telefone = telefone;
    }

    public Cliente() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getIdCliente(), cliente.getIdCliente()) && Objects.equals(getNomeCliente(), cliente.getNomeCliente()) && Objects.equals(getLimiteCartao(), cliente.getLimiteCartao()) && Objects.equals(getNumeroCartao(), cliente.getNumeroCartao()) && Objects.equals(getTelefone(), cliente.getTelefone()) && Objects.equals(pedido, cliente.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCliente(), getNomeCliente(), getLimiteCartao(), getNumeroCartao(), getTelefone(), pedido);
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(Double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
}