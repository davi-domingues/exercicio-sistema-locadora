package br.com.solutis.sistemalocadora.service;

import br.com.solutis.sistemalocadora.dto.request.LocacaoRequest;
import br.com.solutis.sistemalocadora.dto.response.LocacaoResponse;

import java.util.List;

public interface LocacaoService {

    LocacaoResponse cadastrar(LocacaoRequest locacaoRequest);

    LocacaoResponse devolver(Long id);

    List<LocacaoResponse> listar();
}

