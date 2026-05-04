package br.com.solutis.sistemalocadora.service;

import br.com.solutis.sistemalocadora.dto.request.FilmeRequest;
import br.com.solutis.sistemalocadora.dto.response.FilmeResponse;
import br.com.solutis.sistemalocadora.entity.Filme;
import br.com.solutis.sistemalocadora.mapper.FilmeMapper;
import br.com.solutis.sistemalocadora.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeServiceImp implements FilmeService {

    private final FilmeRepository repository;

    public FilmeServiceImp(FilmeRepository filmeRepository) {
        this.repository = filmeRepository;
    }

    public FilmeResponse cadastrar(FilmeRequest request) {
        Filme filme = FilmeMapper.toEntity(request);
        filme =  repository.save(filme);
        return FilmeMapper.toResponse(filme);
    }

    public List<FilmeResponse> listar() {
        List<Filme> filmes = repository.findAll();
        return FilmeMapper.toResponse(filmes);
    }
}


