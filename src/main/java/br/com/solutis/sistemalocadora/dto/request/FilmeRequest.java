package br.com.solutis.sistemalocadora.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmeRequest {

	private String titulo;
	private String genero;
	private String diretor;
}
