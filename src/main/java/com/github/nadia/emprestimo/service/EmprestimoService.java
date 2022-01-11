package com.github.nadia.emprestimo.service;

import com.github.nadia.emprestimo.domain.Emprestimo;
import com.github.nadia.emprestimo.repository.EmprestimoRepository;
import com.github.nadia.emprestimo.resource.dto.DetalheEmprestimoDTO;
import com.github.nadia.emprestimo.resource.dto.ResumoEmprestimoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public Emprestimo salvar(Emprestimo emprestimo){
        if(emprestimo.getNumeroParcelas() > 60) {
            throw new IllegalArgumentException("Numero de parcelas deve ser menor que 60");
        }
        LocalDate dataLimite = LocalDate.now().plusMonths(3);
        if(emprestimo.getDataPrimeiraParcela().isAfter(dataLimite)){
            throw new IllegalArgumentException("A data da priemeira parcela deve ser no maximo 3 meses apos o dia atual");
        }
        return emprestimoRepository.save(emprestimo);
    }

    public List<ResumoEmprestimoDTO> listagemResumoEmprestimosPorCliente(Long clienteId){
        return this.emprestimoRepository
                .findAllEmprestimosByClientId(clienteId)
                .stream()
                .map(this::buildResumoEmprestimoDTOFromEmprestimo)
                .collect(Collectors.toList());
    }

    public DetalheEmprestimoDTO detalheEmprestimoPorId(Long id){
        Emprestimo detalhe = emprestimoRepository.findDetalheEmprestimoById(id);
        return DetalheEmprestimoDTO.builder()
                .id(detalhe.getId())
                .email(detalhe.getCliente().getEmail())
                .renda(detalhe.getCliente().getRenda())
                .primeiraParcela(detalhe.getDataPrimeiraParcela())
                .quantidadeParcelas(detalhe.getNumeroParcelas())
                .valor(detalhe.getValor())
                .build();
    }

    private ResumoEmprestimoDTO buildResumoEmprestimoDTOFromEmprestimo(Emprestimo emprestimo){
        return ResumoEmprestimoDTO.builder()
                .id(emprestimo.getId())
                .numeroParcelas(emprestimo.getNumeroParcelas())
                .valor(emprestimo.getValor())
                .build();
    }

}