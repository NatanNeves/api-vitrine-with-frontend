package br.edu.fateclins.appVitrine.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class ItensComprados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(length = 4)
    private int quantidade;
    @Column(precision = 2)
    private double valor;
    // relacionamento 1 com a classe Compra
    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public ItensComprados() {
    }

    public ItensComprados(int quantidade, double valor, Compra compra, Produto produto) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.compra = compra;
        this.produto = produto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
