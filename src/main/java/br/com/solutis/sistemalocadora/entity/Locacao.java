package br.com.solutis.sistemalocadora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "locacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @Column
    private LocalDate dataLocacao;


    @Column
    private LocalDate dataDevolucao;

    @Column
    private Boolean devolvido;
}
