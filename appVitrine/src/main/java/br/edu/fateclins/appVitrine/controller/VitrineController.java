package br.edu.fateclins.appVitrine.controller;

import br.edu.fateclins.appVitrine.dto.VitrineDTO;
import br.edu.fateclins.appVitrine.modelo.loja.Vitrine;
import br.edu.fateclins.appVitrine.repository.VitrineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vitrines")
public class VitrineController {

    @Autowired
    private VitrineRepository repository;


    @GetMapping
    public ResponseEntity<List<Vitrine>> vitrines(){
        List<Vitrine> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vitrine>> vitrineById(@PathVariable Integer id){
        Optional<Vitrine> vitrine = repository.findById(id);
        return ResponseEntity.ok(vitrine);
    }

    @PostMapping
    public ResponseEntity<Vitrine> createVitrine(@RequestBody VitrineDTO vitrineDTO){
        var vitrine = new Vitrine();
        BeanUtils.copyProperties(vitrineDTO, vitrine);
        return ResponseEntity.status((HttpStatus.CREATED)).body(repository.save(vitrine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVitrine(@PathVariable Integer id) {
        Optional<Vitrine> optionalVitrine = repository.findById(id);

        if (optionalVitrine.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se a vitrine não for encontrada
        }

        repository.deleteById(id); // Deleta a vitrine

        return ResponseEntity.noContent().build(); // Retorna 204 No Content em caso de sucesso
    }
}
