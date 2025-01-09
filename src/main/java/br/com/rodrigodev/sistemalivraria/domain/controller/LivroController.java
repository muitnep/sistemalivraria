package br.com.rodrigodev.sistemalivraria.domain.controller;

import br.com.rodrigodev.sistemalivraria.domain.model.Livro;
import br.com.rodrigodev.sistemalivraria.domain.repository.LivroRepository;
import br.com.rodrigodev.sistemalivraria.domain.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livroRepository.save(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Livro>> listarDisponiveis() {
        return ResponseEntity.ok(livroRepository.findByDisponivelTrue());
    }
}
