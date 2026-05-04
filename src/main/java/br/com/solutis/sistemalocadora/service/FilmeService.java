package br.com.solutis.sistemalocadora.service;

import br.com.solutis.sistemalocadora.dto.request.FilmeRequest;
import br.com.solutis.sistemalocadora.dto.response.FilmeResponse;

import java.util.List;

public interface FilmeService {

    FilmeResponse cadastrar(FilmeRequest request);

    List<FilmeResponse> listar();
}

