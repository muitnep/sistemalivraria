package br.com.rodrigodev.sistemalivraria.domain.service;

import br.com.rodrigodev.sistemalivraria.domain.model.Autor;
import br.com.rodrigodev.sistemalivraria.domain.model.Emprestimo;
import br.com.rodrigodev.sistemalivraria.domain.model.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BibliotecaService {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarTodosLivros() {
        return livros;
    }

    public List<Livro> listarLivrosDisponiveis() {
        return livros.stream()
                .filter(Livro::isDisponivel)
                .collect(Collectors.toList());
    }

    public void registrarEmprestimo(Livro livro) {
        if(!livro.isDisponivel()) {
            throw new IllegalArgumentException("O livro já está emprestado");
        }
        livro.setDisponivel(false);
    }

}
