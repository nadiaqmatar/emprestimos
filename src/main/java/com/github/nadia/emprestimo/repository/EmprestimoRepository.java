package com.github.nadia.emprestimo.repository;

import com.github.nadia.emprestimo.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query(value = "SELECT e FROM Emprestimo e where e.cliente.id = :clienteId")
    List<Emprestimo> findAllEmprestimosByClientId(@Param("clienteId") Long clienteId);

    @Query(value = "SELECT e FROM Emprestimo e JOIN FETCH e.cliente where e.id = :id")
    Emprestimo findDetalheEmprestimoById(@Param("id") Long id);

}