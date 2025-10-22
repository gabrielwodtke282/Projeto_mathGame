package com.matematica.math.game.service;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Ranking;
import com.matematica.math.game.repository.RankingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RankingService {

    private RankingRepository rankingRepository;

    public List<Ranking> buscarRanking(Dificuldade dificuldade) {
        return rankingRepository.getPerguntasByDificuldadeOrderByPosicaoDesc(dificuldade);
    }

    public void saveRanking(List<Ranking> rankings) {
        rankingRepository.saveAll(rankings);
    }
}
