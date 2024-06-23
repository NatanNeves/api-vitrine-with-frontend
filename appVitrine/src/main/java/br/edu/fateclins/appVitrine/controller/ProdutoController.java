package br.edu.fateclins.appVitrine.controller;

import br.edu.fateclins.appVitrine.dto.ProdutoDTO;
import br.edu.fateclins.appVitrine.modelo.loja.Produto;
import br.edu.fateclins.appVitrine.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repositorioProduto;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(
            @RequestBody ProdutoDTO prodDTO){
        // instancia um objeto do modelo
        var prodModelo = new Produto();
        // copia os dados do DTO para o Modelo
        BeanUtils.copyProperties(prodDTO, prodModelo);
        return ResponseEntity.status((HttpStatus.CREATED))
                .body(repositorioProduto.save(prodModelo));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> produtos(){

        List<Produto> lista = repositorioProduto.findAll();
        return ResponseEntity.ok(lista);
    }
}
