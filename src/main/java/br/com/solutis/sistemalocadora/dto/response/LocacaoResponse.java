package br.com.solutis.sistemalocadora.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocacaoResponse {

    private Long id;
    private ClienteResponse cliente;
    private FilmeResponse filme;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private Boolean devolvido;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FilmeResponse {
        private Long id;
        private String titulo;
        private String genero;
        private String diretor;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClienteResponse {
        private Long id;
        private String nome;
        private String email;
    }
}
