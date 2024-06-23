package br.edu.fateclins.appVitrine.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private UUID id;
    @Column
    private boolean concluida;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;
    @Column(precision = 2)
    private double valorFrete;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @OneToMany(mappedBy = "compra")
    private List<ItensComprados> itens;

    public Compra() {
    }

    public double calcularValorFinal(){
        double valorCompra = 0.0;
        for (ItensComprados item:itens ) {
            valorCompra += item.getQuantidade()* item.getValor();
        }
        return valorCompra;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensComprados> getItens() {
        return itens;
    }

    public void setItens(List<ItensComprados> itens) {
        this.itens = itens;
    }
}
