package br.com.solutis.sistemalocadora.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "filme")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;
    @Column
    private String genero;
    @Column
    private String diretor;
}
