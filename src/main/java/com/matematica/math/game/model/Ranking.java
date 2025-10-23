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

    @Column(name = "posicao", nullable = false)
    private int posicao;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "acertos", nullable = false)
    private int acertos;

    @Column(name = "tempo", nullable = false)
    private double tempo;

    @Column(name = "dificuldade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Dificuldade dificuldade;

    public Ranking(int posicao, RankingRequest rankingRequest) {
        this.posicao = posicao;
        this.nome = rankingRequest.nome();
        this.acertos = rankingRequest.acertos();
        this.tempo = rankingRequest.tempo();
        this.dificuldade = rankingRequest.dificuldade();
    }
}
