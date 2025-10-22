package com.matematica.math.game.repository;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Perguntas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntasRepository extends JpaRepository<Perguntas, Long> {

    Perguntas findByIdAndDificuldade(long id, Dificuldade dificuldade);
}
