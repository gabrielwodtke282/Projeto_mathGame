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
        List<Pergunta> perguntasBase = perguntasRepository.findAllByDificuldade(dificuldade);
        List<Pergunta> perguntas = new ArrayList<>();
        List<Integer> nums = numsAleatorios();
        for (int i = 0; i < 10; i++) {
            perguntas.add(perguntasBase.get(nums.get(i)));
        }
        return perguntas;
    }

    public List<Integer> numsAleatorios() {
        Random random = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            boolean sucesso = true;
            while (sucesso) {
                int num = random.nextInt(29);
                if (!nums.contains(num)) {
                    nums.add(num);
                    sucesso = false;
                }
            }
        }
        return nums;
    }
}
