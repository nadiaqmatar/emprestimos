package com.github.nadia.emprestimo.resource.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ResumoEmprestimoDTO {
    private Long id;
    private BigDecimal valor;
    private Integer numeroParcelas;
}