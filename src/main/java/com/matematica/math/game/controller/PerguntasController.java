package com.matematica.math.game.controller;

import com.matematica.math.game.model.Pergunta;
import com.matematica.math.game.model.PerguntaRequest;
import com.matematica.math.game.service.PerguntasService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/perguntas")
@AllArgsConstructor
public class PerguntasController {

    private PerguntasService perguntasService;

    @PostMapping
    public List<Pergunta> createPergunta(@RequestBody @Valid List<PerguntaRequest> pergunta) {
        List<Pergunta> perguntaLista = new ArrayList<>();
        for (PerguntaRequest p : pergunta) {
            perguntaLista.add(perguntasService.createPergunta(p));
        }
        return perguntaLista;
    }
}
