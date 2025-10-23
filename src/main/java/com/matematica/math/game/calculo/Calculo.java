package com.matematica.math.game.calculo;

import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Ranking;
import com.matematica.math.game.model.RankingRequest;
import com.matematica.math.game.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Calculo {

    private final RankingService rankingService;

    @Autowired
    public Calculo(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    public void calculoRankings(Dificuldade dificuldade, RankingRequest rankingRequest) {
        List<Ranking> rankings = rankingService.buscarRanking(dificuldade);
        if (rankings.isEmpty()) {
            rankings.add(new Ranking(1, rankingRequest));
        } else {
            int numeroLugares = 0;
            boolean feito = false;
            for (Ranking ranking : rankings) {
                numeroLugares++;

                if (ranking.getAcertos() == rankingRequest.acertos()) {
                    if (ranking.getTempo() > rankingRequest.tempo()) {
                        int posicao = ranking.getPosicao();
                        rankings = reorganizarLista(posicao, rankings, rankingRequest);
                        feito = true;
                        break;
                    }
                } else if (ranking.getAcertos() < rankingRequest.acertos()) {
                    int posicao = ranking.getPosicao();
                    rankings = reorganizarLista(posicao, rankings, rankingRequest);
                    feito = true;
                    break;
                }
            }
            if (!feito) {
                if (numeroLugares < 10){
                    rankings.add(new Ranking(numeroLugares+1, rankingRequest));
                }
            }
        }
        rankingService.saveListRanking(rankings);
    }

    public List<Ranking> reorganizarLista(int posicao, List<Ranking> rankings, RankingRequest rankingRequest) {
        List<Ranking> reorganizarLista = new ArrayList<>();
        for (Ranking ranking : rankings) {
            if (ranking.getPosicao() >= posicao){
                if (ranking.getPosicao()+1 > 10) {
                    rankingService.deleteRanking(ranking);
                    break;
                }
                reorganizarLista.add(rankingService.updateRanking(ranking.getPosicao()+1, ranking));
            } else {
                reorganizarLista.add(ranking);
            }
        }
        reorganizarLista.add(rankingService.saveRanking(new Ranking(posicao, rankingRequest)));
        return reorganizarLista;
    }
}
