package com.matematica.math.game.controller;

import com.matematica.math.game.service.PerguntasService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perguntas")
@AllArgsConstructor
public class PerguntasController {

    private PerguntasService perguntasService;


}
