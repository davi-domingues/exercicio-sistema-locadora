package br.com.solutis.sistemalocadora.repository;

import br.com.solutis.sistemalocadora.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    Boolean existsByFilmeIdAndDevolvidoEquals(Long idFilme, Boolean devolvido);
    Boolean existsByClienteIdAndDevolvidoEquals(Long idCliente, Boolean devolvido);
}

