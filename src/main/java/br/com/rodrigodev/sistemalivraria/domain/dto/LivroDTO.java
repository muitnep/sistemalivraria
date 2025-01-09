package br.com.rodrigodev.sistemalivraria.domain.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;
    private String titulo;
    private Long categoriaId;
    private Double preco;
}
