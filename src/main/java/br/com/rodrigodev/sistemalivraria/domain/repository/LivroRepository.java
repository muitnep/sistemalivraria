package br.com.rodrigodev.sistemalivraria.domain.repository;

import br.com.rodrigodev.sistemalivraria.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByAutorNome(String nomeAutor);

    List<Livro> findByDisponivelTrue();
}
