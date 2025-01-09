package br.com.rodrigodev.sistemalivraria.domain.service;

import br.com.rodrigodev.sistemalivraria.domain.model.Cliente;
import br.com.rodrigodev.sistemalivraria.domain.model.Emprestimo;
import br.com.rodrigodev.sistemalivraria.domain.model.Livro;
import br.com.rodrigodev.sistemalivraria.domain.repository.ClienteRepository;
import br.com.rodrigodev.sistemalivraria.domain.repository.EmprestimoRepository;
import br.com.rodrigodev.sistemalivraria.domain.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final ClienteRepository clienteRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository, ClienteRepository clienteRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.clienteRepository = clienteRepository;
    }

    //Realizar um emprestimo
    @Transactional
    public Emprestimo realizarEmprestimo(Long livroId, Long clienteId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        //Verifica se o livro está disponível
        if (!livro.isDisponivel()) {
            throw new IllegalArgumentException("O livro já está emprestado e não está disponível");
        }

        //Atualiza o status do livro para "indisponivel"
        livro.setDisponivel(false);
        livroRepository.save(livro);

        //Registra o emprestimo

        Emprestimo novoEmprestimo = new Emprestimo();
        novoEmprestimo.setLivro(livro);
        novoEmprestimo.setCliente(cliente);

        return emprestimoRepository.save(novoEmprestimo);
    }

    //consulta historico de emprestimo por cliente
    public List<Emprestimo> consultarHistoricoPorCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado."));

        return emprestimoRepository.findAll().stream()
                .filter(emprestimo -> emprestimo.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    //consultar historico de emprestimos por livro
    public List<Emprestimo> consultarHistoricoPorLivro(Long livroId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(()-> new IllegalArgumentException("Livro não encontrado."));
        return emprestimoRepository.findAll().stream()
                .filter(emprestimo -> emprestimo.getLivro().equals(livro))
                .collect(Collectors.toList());
    }
}
