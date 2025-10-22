package com.matematica.math.game;

import com.matematica.math.game.calculo.CalculoRanking;
import com.matematica.math.game.model.Dificuldade;
import com.matematica.math.game.model.Pergunta;
import com.matematica.math.game.model.Ranking;
import com.matematica.math.game.model.RankingRequest;
import com.matematica.math.game.service.PerguntasService;
import com.matematica.math.game.service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@AllArgsConstructor
public class Application {

    private static Scanner SC =  new Scanner(System.in);
    private static PerguntasService perguntasService;
    private static RankingService rankingService;
    private static CalculoRanking calculoRanking;
    private static String nome;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

        while (true) {
            System.out.println("=== MENU PRINCIPAL ===\nOpções:\n1 - DIFICULDADE Fácil\n2 - DIFICULDADE Médio\n3 - DIFICULDADE Difícil\n4 - Sair do Sistema\nEscolha:");
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

    public static void facil(){
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

    public static void medio(){
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

    public static void dificil(){
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

    public static void jogar(Dificuldade dificuldade){
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
                String alternativaCorreta = SC.next().trim();
                switch (alternativaCorreta) {
                    case "A" -> {
                        if ("A".equals(pergunta.getAlternativaCerta())){
                            acertos++;
                        }
                        feito = true;
                    }
                    case "B" -> {
                        if ("B".equals(pergunta.getAlternativaCerta())){
                            acertos++;
                        }
                        feito = true;
                    }
                    case "C" -> {
                        if ("C".equals(pergunta.getAlternativaCerta())){
                            acertos++;
                        }
                        feito = true;
                    }
                    case "D" -> {
                        if ("D".equals(pergunta.getAlternativaCerta())){
                            acertos++;
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

    public static void ranking(Dificuldade dificuldade){
        List<Ranking> rankings = rankingService.buscarRanking(dificuldade);
        System.out.println("Ranking Dificuldade "+dificuldade+":\nPosição\tNome\tAcertos\nTempo");
        for (Ranking ranking : rankings) {
            System.out.println(ranking.getPosicao()+"\t"+ranking.getNome()+"\t"+ ranking.getAcertos()+"/10\t"+ranking.getTempo()/1000+"s");
        }
    }

    public static String entrada(){
        return SC.next().trim();
    }
}
