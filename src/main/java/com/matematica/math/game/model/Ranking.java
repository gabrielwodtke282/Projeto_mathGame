package com.matematica.math.game.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ranking")
@Table(name = "ranking")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int posicao;

    private String nome;

    private int acertos;

    private double tempo;

    private Dificuldade dificuldade;

    public Ranking(int posicao, String nome, int acertos, double tempo,  Dificuldade dificuldade) {
        this.posicao = posicao;
        this.nome = nome;
        this.acertos = acertos;
        this.tempo = tempo;
        this.dificuldade = dificuldade;
    }
}
