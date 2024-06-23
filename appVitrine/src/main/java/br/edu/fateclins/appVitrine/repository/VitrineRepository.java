package br.edu.fateclins.appVitrine.repository;

import br.edu.fateclins.appVitrine.modelo.loja.Vitrine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitrineRepository extends JpaRepository<Vitrine, Integer> {
}
