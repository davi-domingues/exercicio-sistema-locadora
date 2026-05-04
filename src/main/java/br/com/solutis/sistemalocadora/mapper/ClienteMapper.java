package br.com.solutis.sistemalocadora.mapper;

import br.com.solutis.sistemalocadora.dto.request.ClienteRequest;
import br.com.solutis.sistemalocadora.dto.response.ClienteResponse;
import br.com.solutis.sistemalocadora.entity.Cliente;

import java.util.List;

public final class ClienteMapper {

    private ClienteMapper() {
    }

    public static Cliente toEntity(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        return cliente;
    }

    public static ClienteResponse toResponse(Cliente cliente) {
        ClienteResponse response = new ClienteResponse();
        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setEmail(cliente.getEmail());
        return response;
    }

    public static List<ClienteResponse> toResponse(List<Cliente> clientes) {
        return clientes.stream().map(ClienteMapper::toResponse).toList();
    }
}


