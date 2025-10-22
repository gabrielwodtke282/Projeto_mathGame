package com.matematica.math.game.service;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Perguntas;
import com.matematica.math.game.repository.PerguntasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PerguntasService {

    private PerguntasRepository perguntasRepository;

    public List<Perguntas> buscar10PerguntasDificuldade(Dificuldade dificuldade) {
        List<Perguntas> perguntas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {

        }
        return perguntas;
    }
}
