package br.com.solutis.sistemalocadora.controller;

import br.com.solutis.sistemalocadora.dto.request.FilmeRequest;
import br.com.solutis.sistemalocadora.dto.response.FilmeResponse;
import br.com.solutis.sistemalocadora.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(@Qualifier("filme-service-imp") FilmeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FilmeResponse> cadastrar(@RequestBody @Valid FilmeRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(request));
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponse>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }
}
