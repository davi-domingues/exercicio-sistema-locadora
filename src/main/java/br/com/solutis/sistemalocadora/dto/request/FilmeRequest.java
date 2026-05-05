package br.com.solutis.sistemalocadora.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmeRequest {

	@NotBlank
	@Min(3)
	private String titulo;

	@NotBlank
	@Min(3)
	private String genero;

	@NotBlank
	@Min(3)
	private String diretor;
}
