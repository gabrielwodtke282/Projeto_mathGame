package com.matematica.math.game.model;

import jakarta.validation.constraints.NotBlank;

public record PerguntaRequest(@NotBlank String pergunta,@NotBlank String A,@NotBlank String B,@NotBlank String C,@NotBlank String D,@NotBlank String alternativaCerta,@NotBlank String dificuldade) {
}
