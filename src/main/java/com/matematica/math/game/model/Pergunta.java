package com.matematica.math.game.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "perguntas")
@Table(name = "perguntas")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pergunta", nullable = false)
    private String pergunta;

    @Column(name = "a", nullable = false)
    private String A;

    @Column(name = "b", nullable = false)
    private String B;

    @Column(name = "c", nullable = false)
    private String C;

    @Column(name = "d", nullable = false)
    private String D;

    @Column(name = "alternativa_certa", nullable = false)
    private String alternativaCerta;

    @Column(name = "dificuldade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Dificuldade dificuldade;

    public Pergunta(PerguntaRequest pergunta) {
        this.pergunta = pergunta.pergunta();
        this.A = pergunta.A();
        this.B = pergunta.B();
        this.C = pergunta.C();
        this.D = pergunta.D();
        this.alternativaCerta = pergunta.alternativaCerta();
        this.dificuldade = Dificuldade.valueOf(pergunta.dificuldade());
    }
}
