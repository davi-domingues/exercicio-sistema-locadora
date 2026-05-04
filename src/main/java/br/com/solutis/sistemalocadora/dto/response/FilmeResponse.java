package br.com.solutis.sistemalocadora.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmeResponse {

	private Long id;
	private String titulo;
	private String genero;
	private String diretor;
}
