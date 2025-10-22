package com.matematica.math.game.service;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Pergunta;
import com.matematica.math.game.model.PerguntaRequest;
import com.matematica.math.game.repository.PerguntasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class PerguntasService {

    private PerguntasRepository perguntasRepository;

    public Pergunta createPergunta(PerguntaRequest pergunta) {
        return perguntasRepository.save(new Pergunta(pergunta));
    }

    public List<Pergunta> buscar10PerguntasDificuldade(Dificuldade dificuldade) {
        List<Pergunta> perguntas = new ArrayList<>();
        List<Long> perguntasId = idsPerguntas(dificuldade);
        for (int i = 0; i < 10; i++) {
            perguntas.add(perguntasRepository.getPerguntaById(perguntasId.get(i)));
        }
        return perguntas;
    }

    public List<Long> idsPerguntas(Dificuldade dificuldade) {
        Random random = new Random();
        List<Long> ids = new ArrayList<>();
        if (dificuldade.equals(Dificuldade.FACIL)) {
            for (int i = 0; i < 10; i++) {
                boolean repete = true;
                while (repete){
                    long num = random.nextLong(1,30);

                    if (!ids.contains(num)) {
                        ids.add(num);
                        repete = false;
                    }
                }
            }
        } else if (dificuldade.equals(Dificuldade.MEDIO)) {
            for (int i = 0; i < 10; i++) {
                boolean repete = true;
                while (repete){
                    long num = random.nextLong(31, 60);
                    if (!ids.contains(num)) {
                        ids.add(num);
                        repete = false;
                    }
                }
            }
        } else if (dificuldade.equals(Dificuldade.DIFICIL)){
            for (int i = 0; i < 10; i++) {
                boolean repete = true;
                while (repete){
                    long num = random.nextLong(61, 90);
                    if (!ids.contains(num)) {
                        ids.add(num);
                        repete = false;
                    }
                }
            }
        }  else {
            System.out.println("ERRO");
            System.exit(0);
        }
        return ids;
    }
}
