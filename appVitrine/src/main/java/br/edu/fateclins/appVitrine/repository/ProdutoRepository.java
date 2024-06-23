package br.edu.fateclins.appVitrine.repository;

import br.edu.fateclins.appVitrine.modelo.loja.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
