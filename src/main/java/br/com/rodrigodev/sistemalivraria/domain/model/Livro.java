package br.com.rodrigodev.sistemalivraria.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "livro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    private Boolean disponivel = true;
    private LocalDateTime dataCadastro = LocalDateTime.now();
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @PreUpdate
    public void atualizarDataAtualizacao() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String toString() {
        return titulo + " (autor: " + autor.getNome() + ")";
    }

    public boolean isDisponivel() {
        return true;
    }

    public void setDisponivel(boolean b) {
    }
}
