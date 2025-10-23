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
        return rankingRepository.getAllByDificuldadeOrderByPosicaoAsc(dificuldade);
    }

    public Ranking saveRanking(Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    public Ranking updateRanking(int posicao, Ranking ranking) {
        ranking.setPosicao(posicao);
        return rankingRepository.save(ranking);
    }

    public void deleteRanking(Ranking ranking) {
        rankingRepository.delete(ranking);
    }

    public void saveListRanking(List<Ranking> listRanking) {
        rankingRepository.saveAll(listRanking);
    }
}
