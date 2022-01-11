package com.github.nadia.emprestimo.service;

import com.github.nadia.emprestimo.domain.Cliente;
import com.github.nadia.emprestimo.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente buscaPorId(Long id){
        Optional<Cliente> clienteOpcional = clienteRepository.findById(id);
        if (clienteOpcional.isPresent()){
            return clienteOpcional.get();
        }else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente){
        Cliente clienteNoBanco = buscaPorId(id);
        cliente.setId(clienteNoBanco.getId());
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }

}