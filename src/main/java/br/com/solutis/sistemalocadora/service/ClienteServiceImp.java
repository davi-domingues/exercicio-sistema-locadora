package br.com.solutis.sistemalocadora.service;

import br.com.solutis.sistemalocadora.dto.request.ClienteRequest;
import br.com.solutis.sistemalocadora.dto.response.ClienteResponse;
import br.com.solutis.sistemalocadora.entity.Cliente;
import br.com.solutis.sistemalocadora.mapper.ClienteMapper;
import br.com.solutis.sistemalocadora.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }


    public ClienteResponse cadastrar(ClienteRequest request){
        Cliente cliente = ClienteMapper.toEntity(request);
        cliente = repository.save(cliente);
        return ClienteMapper.toResponse(cliente);
    }

    public List<ClienteResponse> listar(){
        List<Cliente> clientes = repository.findAll();
        return ClienteMapper.toResponse(clientes);
    }
}


