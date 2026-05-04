package br.com.solutis.sistemalocadora.mapper;

import br.com.solutis.sistemalocadora.dto.request.FilmeRequest;
import br.com.solutis.sistemalocadora.dto.response.FilmeResponse;
import br.com.solutis.sistemalocadora.entity.Filme;

import java.util.List;

public final class FilmeMapper {

    private FilmeMapper() {
    }

    public static Filme toEntity(FilmeRequest request) {
        Filme filme = new Filme();
        filme.setTitulo(request.getTitulo());
        filme.setGenero(request.getGenero());
        filme.setDiretor(request.getDiretor());
        return filme;
    }

    public static FilmeResponse toResponse(Filme filme) {
        FilmeResponse response = new FilmeResponse();
        response.setId(filme.getId());
        response.setTitulo(filme.getTitulo());
        response.setGenero(filme.getGenero());
        response.setDiretor(filme.getDiretor());
        return response;
    }

    public static List<FilmeResponse> toResponse(List<Filme> filmes) {
        return filmes.stream().map(FilmeMapper::toResponse).toList();
    }
}


