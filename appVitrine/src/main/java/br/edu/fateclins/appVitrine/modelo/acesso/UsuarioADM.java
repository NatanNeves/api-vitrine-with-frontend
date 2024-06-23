package br.edu.fateclins.appVitrine.modelo.acesso;

import br.edu.fateclins.appVitrine.modelo.loja.Usuario;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "UsuarioADM")
public class UsuarioADM  extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    public UsuarioADM() {
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
