package br.com.rodrigodev.sistemalivraria.domain.repository;

import br.com.rodrigodev.sistemalivraria.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
