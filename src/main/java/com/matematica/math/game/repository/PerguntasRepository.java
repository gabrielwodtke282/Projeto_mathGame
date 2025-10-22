package com.matematica.math.game.repository;

import com.matematica.math.game.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntasRepository extends JpaRepository<Pergunta, Long> {
    Pergunta getPerguntaById(Long id);
}
