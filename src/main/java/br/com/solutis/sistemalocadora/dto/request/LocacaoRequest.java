package br.com.solutis.sistemalocadora.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocacaoRequest {

    @NotNull
    private Long idCliente;

    @NotNull
    private Long idFilme;
}
