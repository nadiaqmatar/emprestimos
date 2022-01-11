package com.github.nadia.emprestimo.resource;

import com.github.nadia.emprestimo.domain.Emprestimo;
import com.github.nadia.emprestimo.resource.dto.DetalheEmprestimoDTO;
import com.github.nadia.emprestimo.resource.dto.ResumoEmprestimoDTO;
import com.github.nadia.emprestimo.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoResource {

    private final EmprestimoService emprestimoService;

    @PostMapping
    public Emprestimo salvar(@RequestBody Emprestimo emprestimo){
        return emprestimoService.salvar(emprestimo);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<ResumoEmprestimoDTO> listagemEmprestimosPorCliente(@PathVariable("clienteId") Long clienteId){
        return emprestimoService.listagemResumoEmprestimosPorCliente(clienteId);
    }

    @GetMapping("/{id}/detalhe")
    public DetalheEmprestimoDTO detalheEmprestimos(@PathVariable("id") Long id){
        return emprestimoService.detalheEmprestimoPorId(id);
    }
}