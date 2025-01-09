package br.com.rodrigodev.sistemalivraria.domain.service;

import br.com.rodrigodev.sistemalivraria.domain.model.Cliente;
import br.com.rodrigodev.sistemalivraria.domain.repository.ClienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //cadastrar um cliente
    public Cliente cadastrarCliente(Cliente cliente) {
       return clienteRepository.save(cliente);
    }

    //listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
