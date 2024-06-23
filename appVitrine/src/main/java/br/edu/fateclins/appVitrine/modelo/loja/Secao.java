package br.edu.fateclins.appVitrine.modelo.loja;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
@Entity
public class Secao  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 60)
    private String nome;
    // relacionamento 0..* com a classe Produto
    //@OneToMany(mappedBy ="secao" )
    @Transient
    private List<Produto> produtos;

    public Secao() {
    }

    public Secao(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
