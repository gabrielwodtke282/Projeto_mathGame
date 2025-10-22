package com.matematica.math.game.repository;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntasRepository extends JpaRepository<Pergunta, Long> {

    List<Pergunta> findAllByDificuldade(Dificuldade dificuldade);
}
