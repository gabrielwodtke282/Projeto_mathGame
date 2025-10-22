package com.matematica.math.game.repository;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {

    List<Ranking> getPerguntasByDificuldadeOrderByPosicaoDesc(Dificuldade dificuldade);
}
