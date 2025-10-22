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

    @Column
    private String pergunta;

    private String A;
    private String B;
    private String C;
    private String D;

    private String alternativaCerta;
    private Dificuldade dificuldade;

    public Pergunta(PerguntaRequest pergunta) {
        this.pergunta = pergunta.pergunta();
        this.A = pergunta.A();
        this.B = pergunta.B();
        this.C = pergunta.C();
        this.D = pergunta.D();
        this.alternativaCerta = pergunta.alternativaCerta();
        Dificuldade dificuldade1 = Dificuldade.valueOf(pergunta.dificuldade());
        this.dificuldade = dificuldade1;
    }
}
