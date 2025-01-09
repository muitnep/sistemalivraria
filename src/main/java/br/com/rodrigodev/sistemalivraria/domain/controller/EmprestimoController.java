package br.com.rodrigodev.sistemalivraria.domain.controller;

import br.com.rodrigodev.sistemalivraria.domain.model.Emprestimo;
import br.com.rodrigodev.sistemalivraria.domain.service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    //Endpoint para realizar um emprestimo
    @PostMapping("/{livroId}")
    public ResponseEntity<Emprestimo> realizarEmprestimo(@PathVariable Long livroId, @RequestParam Long clienteId) {
        Emprestimo emprestimo = emprestimoService.realizarEmprestimo(livroId, clienteId);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
    }

    //Consulta historico de emprestimos por cliente
    @GetMapping("/historico/cliente/{clienteId}")
    public ResponseEntity<List<Emprestimo>> consultarHistoricoPorCliente(@PathVariable Long clienteId){
        List<Emprestimo> historicoCliente = emprestimoService.consultarHistoricoPorCliente(clienteId);
        return ResponseEntity.ok(historicoCliente);
    }

    //Consulta historico de emprestimos por livro
    @GetMapping("/historico/livro/{livroId}")
    public ResponseEntity<List<Emprestimo>> consultarHistoricoPorLivro(@PathVariable Long livroId){
        List<Emprestimo> historicoLivro = emprestimoService.consultarHistoricoPorLivro(livroId);
        return ResponseEntity.ok(historicoLivro);
    }

}
