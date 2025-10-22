package com.matematica.math.game.service;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Pergunta;
import com.matematica.math.game.model.PerguntaRequest;
import com.matematica.math.game.repository.PerguntasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PerguntasService {

    private PerguntasRepository perguntasRepository;

    public Pergunta createPergunta(PerguntaRequest pergunta) {
        return perguntasRepository.save(new Pergunta(pergunta));
    }

    public List<Pergunta> buscar10PerguntasDificuldade(Dificuldade dificuldade) {
        List<Pergunta> perguntas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {

        }
        return perguntas;
    }
}
