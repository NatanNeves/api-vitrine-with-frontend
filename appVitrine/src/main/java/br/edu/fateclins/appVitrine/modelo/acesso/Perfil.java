package br.edu.fateclins.appVitrine.modelo.acesso;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 30)
    private String descricao;
    // relacionamento 0..* com a classe UsuarioADM
    // @OneToMany(mappedBy = "perfil")
    @Transient
    private List<UsuarioADM> usuariosPerfil;


    public Perfil() {
    }

    public Perfil(String descricao) {
        this.descricao = descricao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<UsuarioADM> getUsuariosPerfil() {
        return usuariosPerfil;
    }

    public void setUsuariosPerfil(List<UsuarioADM> usuariosPerfil) {
        this.usuariosPerfil = usuariosPerfil;
    }
}