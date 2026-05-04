package br.com.solutis.sistemalocadora.repository;

import br.com.solutis.sistemalocadora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

