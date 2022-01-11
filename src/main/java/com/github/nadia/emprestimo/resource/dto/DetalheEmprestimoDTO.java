package com.github.nadia.emprestimo.resource.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalheEmprestimoDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private BigDecimal valor;
    private Integer quantidadeParcelas;
    private LocalDate primeiraParcela;
    private String email;
    private BigDecimal renda;

}