package br.com.solutis.sistemalocadora.controller;

import br.com.solutis.sistemalocadora.dto.request.LocacaoRequest;
import br.com.solutis.sistemalocadora.dto.response.LocacaoResponse;
import br.com.solutis.sistemalocadora.service.LocacaoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    private final LocacaoService service;

    public LocacaoController(@Qualifier("locacao-service-imp") LocacaoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LocacaoResponse> cadastrar(@RequestBody LocacaoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(request));
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<LocacaoResponse> devolver(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.devolver(id));
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponse>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }
}
