package com.matematica.math.game.calculo;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Ranking;
import com.matematica.math.game.model.RankingRequest;
import com.matematica.math.game.repository.RankingRepository;
import com.matematica.math.game.service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalculoRanking {

    @Autowired
    private RankingService rankingService;

    public List<Ranking> calculoRankings(Dificuldade dificuldade, RankingRequest rankingRequest) {
        List<Ranking> rankings = rankingService.buscarRanking(dificuldade);
        for (Ranking ranking : rankings) {

        }
        return rankings;
    }
}
