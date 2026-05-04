package br.com.solutis.sistemalocadora.service;

import br.com.solutis.sistemalocadora.dto.request.ClienteRequest;
import br.com.solutis.sistemalocadora.dto.response.ClienteResponse;

import java.util.List;

public interface ClienteService {

    ClienteResponse cadastrar(ClienteRequest request);

    List<ClienteResponse> listar();
}

