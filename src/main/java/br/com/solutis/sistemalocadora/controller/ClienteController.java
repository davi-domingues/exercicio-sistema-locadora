package br.com.solutis.sistemalocadora.controller;

import br.com.solutis.sistemalocadora.dto.request.ClienteRequest;
import br.com.solutis.sistemalocadora.dto.response.ClienteResponse;
import br.com.solutis.sistemalocadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(@Qualifier("cliente-service-imp") ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody ClienteRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(request));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }
}
