package com.matematica.math.game.model;

public record RankingRequest(String nome, Dificuldade dificuldade, int acertos, double tempo) {
}
