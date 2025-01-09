package br.com.rodrigodev.sistemalivraria.domain.repository;

import br.com.rodrigodev.sistemalivraria.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
