package br.com.solutis.sistemalocadora.mapper;

import br.com.solutis.sistemalocadora.dto.request.LocacaoRequest;
import br.com.solutis.sistemalocadora.dto.response.LocacaoResponse;
import br.com.solutis.sistemalocadora.entity.Cliente;
import br.com.solutis.sistemalocadora.entity.Filme;
import br.com.solutis.sistemalocadora.entity.Locacao;

import java.util.List;

public final class LocacaoMapper {

    private LocacaoMapper() {
    }

    public static Locacao toEntity(LocacaoRequest request) {
        Locacao locacao = new Locacao();

        Cliente cliente = new Cliente();
        cliente.setId(request.getIdCliente());
        locacao.setCliente(cliente);

        Filme filme = new Filme();
        filme.setId(request.getIdFilme());
        locacao.setFilme(filme);

        return locacao;
    }

    public static LocacaoResponse toResponse(Locacao locacao) {
        LocacaoResponse response = new LocacaoResponse();
        response.setId(locacao.getId());
        response.setDataLocacao(locacao.getDataLocacao());
        response.setDataDevolucao(locacao.getDataDevolucao());
        response.setDevolvido(locacao.getDevolvido());

        if (locacao.getCliente() != null) {
            LocacaoResponse.ClienteResponse clienteResponse = new LocacaoResponse.ClienteResponse();
            clienteResponse.setId(locacao.getCliente().getId());
            clienteResponse.setNome(locacao.getCliente().getNome());
            clienteResponse.setEmail(locacao.getCliente().getEmail());
            response.setCliente(clienteResponse);
        }

        if (locacao.getFilme() != null) {
            LocacaoResponse.FilmeResponse filmeResponse = new LocacaoResponse.FilmeResponse();
            filmeResponse.setId(locacao.getFilme().getId());
            filmeResponse.setTitulo(locacao.getFilme().getTitulo());
            filmeResponse.setGenero(locacao.getFilme().getGenero());
            filmeResponse.setDiretor(locacao.getFilme().getDiretor());
            response.setFilme(filmeResponse);
        }

        return response;
    }

    public static List<LocacaoResponse> toResponse(List<Locacao> locacoes) {
        return locacoes.stream().map(LocacaoMapper::toResponse).toList();
    }
}

