package br.com.rodrigodev.sistemalivraria.domain.controller;

import br.com.rodrigodev.sistemalivraria.domain.model.Cliente;
import br.com.rodrigodev.sistemalivraria.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //endpoint para cadastrar um cliente
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
        Cliente novoCliente = clienteService.cadastrarCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    //endpoint para listar todos os cliente
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }
}
