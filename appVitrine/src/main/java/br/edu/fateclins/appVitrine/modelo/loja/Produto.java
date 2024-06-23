package br.edu.fateclins.appVitrine.modelo.loja;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "Produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column(length = 500)
    private String descricao;
    @Column(precision = 2)
    private Double valor;
    @Column(length = 5)
    private int qtdeEstoque;
    @Column(length = 5)
    private int estoqueMinimo;
    @Column(length = 255)
    private String imagem;
    @ManyToOne
    @JoinColumn(name = "id_secao")
    private Secao secao;
    @Transient
    private List<ItensComprados> listaComprados;
    @Transient
    private List<ItensVitrine> vitrines;

    public Produto() {
    }

    public List<Produto> pesquisarProdutosBaixoEstoque(List<Produto> listaEstoque){
        List<Produto> listaBaixoEstoque = new ArrayList<>();
        for (Produto prod:listaEstoque) {
            if(prod.getEstoqueMinimo() > prod.getQtdeEstoque()){
                listaBaixoEstoque.add(prod);
            }
        }
        return listaBaixoEstoque;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public List<ItensVitrine> getVitrines() {
        return vitrines;
    }

    public void setVitrines(List<ItensVitrine> vitrines) {
        this.vitrines = vitrines;
    }

    public List<ItensComprados> getListaComprados() {
        return listaComprados;
    }

    public void setListaComprados(List<ItensComprados> listaComprados) {
        this.listaComprados = listaComprados;
    }


}
