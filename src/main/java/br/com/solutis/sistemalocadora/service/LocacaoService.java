package br.com.solutis.sistemalocadora.service;

import br.com.solutis.sistemalocadora.dto.request.LocacaoRequest;
import br.com.solutis.sistemalocadora.dto.response.LocacaoResponse;
import br.com.solutis.sistemalocadora.entity.Locacao;
import br.com.solutis.sistemalocadora.exception.ClienteAlreadyInUseException;
import br.com.solutis.sistemalocadora.exception.EntityNotFoundException;
import br.com.solutis.sistemalocadora.exception.FilmeAlreadyInUseException;
import br.com.solutis.sistemalocadora.mapper.LocacaoMapper;
import br.com.solutis.sistemalocadora.repository.ClienteRepository;
import br.com.solutis.sistemalocadora.repository.FilmeRepository;
import br.com.solutis.sistemalocadora.repository.LocacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    private final LocacaoRepository repository;
    private final ClienteRepository clienteRepository;
    private final FilmeRepository filmeRepository;

    public LocacaoService(LocacaoRepository repository, ClienteRepository clienteRepository, FilmeRepository filmeRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.filmeRepository = filmeRepository;
    }

    public LocacaoResponse cadastrar(LocacaoRequest locacaoRequest){
        if (!clienteRepository.existsById(locacaoRequest.getIdCliente()) || !filmeRepository.existsById(locacaoRequest.getIdFilme())) {
            throw new EntityNotFoundException("Cliente ou filme não encontrado");
        }

        if(repository.existsByFilmeIdAndDevolvidoEquals(locacaoRequest.getIdFilme(), false)){
            throw new FilmeAlreadyInUseException("Filme já está locado");
        }

        if(repository.existsByClienteIdAndDevolvidoEquals(locacaoRequest.getIdCliente(), false)){
            throw new ClienteAlreadyInUseException("Cliente já está locando um filme");
        }

        Locacao locacao = LocacaoMapper.toEntity(locacaoRequest);
        locacao.setDataLocacao(LocalDate.now());
        locacao.setDevolvido(false);
        locacao = repository.save(locacao);
        return LocacaoMapper.toResponse(locacao);
    }

    public LocacaoResponse devolver(Long id) {
        Optional<Locacao> locacaoOpt = repository.findById(id);
        if (locacaoOpt.isEmpty()) {
            throw new EntityNotFoundException("Locação não encontrada");
        }
        Locacao locacao = locacaoOpt.get();
        locacao.setDataDevolucao(LocalDate.now());
        locacao.setDevolvido(true);
        locacao = repository.save(locacao);
        return LocacaoMapper.toResponse(locacao);
    }

    public List<LocacaoResponse> listar(){
        List<Locacao> locacoes = repository.findAll();
        return LocacaoMapper.toResponse(locacoes);
    }
}

