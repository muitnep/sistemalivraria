package br.com.rodrigodev.sistemalivraria.domain.exceptions;

public class LivroNotFoundExceprtion extends RuntimeException {
    public LivroNotFoundExceprtion(String message) {
        super(message);
    }
}
