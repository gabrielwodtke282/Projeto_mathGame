package com.matematica.math.game;

import com.matematica.math.game.calculo.CalculoRanking;
import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Pergunta;
import com.matematica.math.game.model.Ranking;
import com.matematica.math.game.model.RankingRequest;
import com.matematica.math.game.service.PerguntasService;
import com.matematica.math.game.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Inicio implements CommandLineRunner {

    private static final Scanner SC =  new Scanner(System.in);
    private final PerguntasService perguntasService;
    private final RankingService rankingService;
    private final CalculoRanking calculoRanking;
    private final String nome;

    @Autowired
    public Inicio(PerguntasService perguntasService, RankingService rankingService, CalculoRanking calculoRanking) {
        this.perguntasService = perguntasService;
        this.rankingService = rankingService;
        this.calculoRanking = calculoRanking;
        this.nome = inserirNome();
    }

    public String inserirNome(){
        while(true) {
            System.out.println("Insira seu Nome:");
            String nome = SC.nextLine().trim();
            if (!nome.isEmpty()) {
                return nome;
            }
        }
    }

    public void start() {
        while (true) {
            System.out.println("=== MENU PRINCIPAL ===\nOpções:\n1 - Dificuldade Fácil\n2 - Dificuldade Médio\n3 - Dificuldade Difícil\n4 - Sair do Sistema\nEscolha:");
            switch (entrada()) {
                case "1" -> facil();
                case "2" -> medio();
                case "3" -> dificil();
                case "4" -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Entrada Inválida!");
                }
            }
        }
    }

    public void facil(){
        while (true) {
            Dificuldade dificuldade = Dificuldade.FACIL;
            System.out.println("=== MENU DIFICULDADE FÁCIL ===\nEscolha a Opção:\n1 - Jogar\n2 - Ranking\n3 - Voltar ao Menu Principal\nEscolha:");
            switch (entrada()) {
                case "1" -> jogar(dificuldade);
                case "2" -> ranking(dificuldade);
                case "3" -> {
                    return;
                }
                default -> {
                    System.out.println("Entrada Inválida!");
                }
            }
        }
    }

    public void medio(){
        while (true) {
            Dificuldade dificuldade = Dificuldade.MEDIO;
            System.out.println("=== MENU DIFICULDADE MÉDIA ===\nEscolha a Opção:\n1 - Jogar\n2 - Ranking\n3 - Voltar ao Menu Principal\nEscolha:");
            switch (entrada()) {
                case "1" -> jogar(dificuldade);
                case "2" -> ranking(dificuldade);
                case "3" -> {
                    return;
                }
                default -> {
                    System.out.println("Entrada Inválida!");
                }
            }
        }
    }

    public void dificil(){
        while (true) {
            Dificuldade dificuldade = Dificuldade.DIFICIL;
            System.out.println("=== MENU DIFICULDADE DIFÍCIL ===\nEscolha a Opção:\n1 - Jogar\n2 - Ranking\n3 - Voltar ao Menu Principal\nEscolha:");
            switch (entrada()) {
                case "1" -> jogar(dificuldade);
                case "2" -> ranking(dificuldade);
                case "3" -> {
                    return;
                }
                default -> {
                    System.out.println("Entrada Inválida!");
                }
            }
        }
    }

    public void jogar(Dificuldade dificuldade){
        List<Pergunta> perguntas = perguntasService.buscar10PerguntasDificuldade(dificuldade);

        int acertos = 0;
        int numeroPergunta = 1;
        long inicio = System.currentTimeMillis();
        for (Pergunta pergunta : perguntas) {
            boolean feito = false;
            while (!feito) {
                System.out.println("Pergunta " + numeroPergunta);
                System.out.println(pergunta.getPergunta());
                System.out.println("Alternativas:");
                System.out.println("A) " + pergunta.getA());
                System.out.println("B) " + pergunta.getB());
                System.out.println("C) " + pergunta.getC());
                System.out.println("D) " + pergunta.getD());
                System.out.println("Insira a Alternativa Correta:");
                String alternativaCorreta = SC.next().trim().toUpperCase();
                switch (alternativaCorreta) {
                    case "A" -> {
                        if ("A".equals(pergunta.getAlternativaCerta())){
                            acertos++;
                            System.out.println("Resposta Certa!");
                        } else {
                            System.out.println("Resposta Errada! A resposta certa era: " + pergunta.getAlternativaCerta());
                        }
                        feito = true;
                    }
                    case "B" -> {
                        if ("B".equals(pergunta.getAlternativaCerta())){
                            acertos++;
                            System.out.println("Resposta Certa!");
                        } else {
                            System.out.println("Resposta Errada! A resposta certa era: " + pergunta.getAlternativaCerta());
                        }
                        feito = true;
                    }
                    case "C" -> {
                        if ("C".equals(pergunta.getAlternativaCerta())){
                            acertos++;
                            System.out.println("Resposta Certa!");
                        } else {
                            System.out.println("Resposta Errada! A resposta certa era: " + pergunta.getAlternativaCerta());
                        }
                        feito = true;
                    }
                    case "D" -> {
                        if ("D".equals(pergunta.getAlternativaCerta())){
                            acertos++;
                            System.out.println("Resposta Certa!");
                        } else {
                            System.out.println("Resposta Errada! A resposta certa era: " + pergunta.getAlternativaCerta());
                        }
                        feito = true;
                    }
                    default -> {
                        System.out.println("Entrada Inválida!");
                    }
                }
            }
        }
        long fim =  System.currentTimeMillis();
        long tempo = fim - inicio;
        calculoRanking.calculoRankings(dificuldade, new RankingRequest(nome, dificuldade, acertos, tempo));
        System.out.println("\n");
    }

    public void ranking(Dificuldade dificuldade){
        List<Ranking> rankings = rankingService.buscarRanking(dificuldade);
        System.out.println("Ranking Dificuldade "+dificuldade+":\nPosição\tNome\tAcertos\nTempo");
        for (Ranking ranking : rankings) {
            System.out.println(ranking.getPosicao()+"\t"+ranking.getNome()+"\t"+ ranking.getAcertos()+"/10\t"+ranking.getTempo()/1000+"s");
        }
    }

    public static String entrada(){
        return SC.next().trim();
    }

    @Override
    public void run(String... args) throws Exception {
        start();
    }
}
