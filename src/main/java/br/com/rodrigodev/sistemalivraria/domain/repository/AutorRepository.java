package br.com.rodrigodev.sistemalivraria.domain.repository;

import br.com.rodrigodev.sistemalivraria.domain.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
