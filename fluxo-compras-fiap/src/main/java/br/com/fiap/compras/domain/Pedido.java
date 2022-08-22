package br.com.fiap.compras.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @SequenceGenerator(name = "pedido", sequenceName = "sq_tb_pedido", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
    @Column(name = "id_pedido")
    private Long idPedido;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_pedido")
    private Calendar dataPedido;

    @Column(name = "nm_vendedor", length = 60)
    private String nomeVendedor;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> idItemPedido = new ArrayList<>();

    public Pedido(Long idPedido, Calendar dataPedido, String nomeVendedor, Cliente cliente, List<ItemPedido> idItemPedido) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.nomeVendedor = nomeVendedor;
        this.cliente = cliente;
        this.idItemPedido = idItemPedido;
    }

    public Pedido() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getIdPedido(), pedido.getIdPedido()) && Objects.equals(getDataPedido(), pedido.getDataPedido()) && Objects.equals(getNomeVendedor(), pedido.getNomeVendedor()) && Objects.equals(cliente, pedido.cliente) && Objects.equals(idItemPedido, pedido.idItemPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPedido(), getDataPedido(), getNomeVendedor(), cliente, idItemPedido);
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(List<ItemPedido> idItemPedido) {
        this.idItemPedido = idItemPedido;
    }
}