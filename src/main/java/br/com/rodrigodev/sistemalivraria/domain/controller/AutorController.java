package br.com.rodrigodev.sistemalivraria.domain.controller;

import br.com.rodrigodev.sistemalivraria.domain.model.Autor;
import br.com.rodrigodev.sistemalivraria.domain.repository.AutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(autorRepository.save(autor));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodosAutores() {
        return ResponseEntity.ok(autorRepository.findAll());
    }
}
