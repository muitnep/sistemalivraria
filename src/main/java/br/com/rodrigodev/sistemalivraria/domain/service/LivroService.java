package br.com.rodrigodev.sistemalivraria.domain.service;

import br.com.rodrigodev.sistemalivraria.domain.model.Livro;
import br.com.rodrigodev.sistemalivraria.domain.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

//    public List<Livro> listarPorCategoria(String categoria) {
//        return livroRepository.findByCategoriaNome(categoria);
//    }

    public Livro cadastrar(Livro livro) {
        return livroRepository.save(livro);
    }
}
