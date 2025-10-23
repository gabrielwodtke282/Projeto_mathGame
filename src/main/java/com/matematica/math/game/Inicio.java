package com.matematica.math.game;

import com.matematica.math.game.calculo.Calculo;
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
    private final Calculo calculo;

    @Autowired
    public Inicio(PerguntasService perguntasService, RankingService rankingService, Calculo calculo) {
        this.perguntasService = perguntasService;
        this.rankingService = rankingService;
        this.calculo = calculo;
    }

    public void start() {
        String nome = definirNome();
        while (true) {
            System.out.println("=== MENU PRINCIPAL ===\nOpções:\n1 - Dificuldade Fácil\n2 - Dificuldade Médio\n3 - Dificuldade Difícil\n4 - Sair do Sistema\nEscolha:");
            switch (entrada()) {
                case "1" -> facil(nome);
                case "2" -> medio(nome);
                case "3" -> dificil(nome);
                case "4" -> System.exit(0);
                default -> System.out.println("Entrada Inválida!");
            }
        }
    }

    public String definirNome() {
        boolean valido = true;
        String nome = "";
        while (valido) {
            System.out.println("Digite seu nome:");
            nome = SC.nextLine().trim();
            if (!nome.isEmpty()) {
                valido = false;
            }
        }
        return nome;
    }

    public void facil(String nome){
        while (true) {
            Dificuldade dificuldade = Dificuldade.FACIL;
            System.out.println("=== MENU DIFICULDADE FÁCIL ===\nEscolha a Opção:\n1 - Jogar\n2 - Ranking\n3 - Voltar ao Menu Principal\nEscolha:");
            switch (entrada()) {
                case "1" -> jogar(dificuldade, nome);
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

    public void medio(String nome){
        while (true) {
            Dificuldade dificuldade = Dificuldade.MEDIO;
            System.out.println("=== MENU DIFICULDADE MÉDIA ===\nEscolha a Opção:\n1 - Jogar\n2 - Ranking\n3 - Voltar ao Menu Principal\nEscolha:");
            switch (entrada()) {
                case "1" -> jogar(dificuldade, nome);
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

    public void dificil(String nome){
        while (true) {
            Dificuldade dificuldade = Dificuldade.DIFICIL;
            System.out.println("=== MENU DIFICULDADE DIFÍCIL ===\nEscolha a Opção:\n1 - Jogar\n2 - Ranking\n3 - Voltar ao Menu Principal\nEscolha:");
            switch (entrada()) {
                case "1" -> jogar(dificuldade, nome);
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

    public void jogar(Dificuldade dificuldade, String nome){
        List<Pergunta> perguntas = perguntasService.buscar10PerguntasDificuldade(dificuldade);

        int acertos = 0;
        int numeroPergunta = 0;
        long inicio = System.currentTimeMillis();
        for (Pergunta pergunta : perguntas) {
            boolean feito = false;
            numeroPergunta++;
            while (!feito) {
                System.out.println("\n");
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
        System.out.println("Processando as Respostas...");
        calculo.calculoRankings(dificuldade, new RankingRequest(nome, dificuldade, acertos, tempo));
        System.out.println("\n");
        System.out.println("Acertos: " + acertos+"/10; Tempo: " + tempo/1000 + "s");
        System.out.println("\n");
    }

    public void ranking(Dificuldade dificuldade){
        List<Ranking> rankings = rankingService.buscarRanking(dificuldade);
        if (rankings.isEmpty()){
            System.out.println("Nenhuma tentativa de Jogo registrada");
        } else {
            System.out.println("Ranking Dificuldade "+dificuldade+":\nP°\tNome\tAcertos\tTempo");
            for (Ranking ranking : rankings) {
                System.out.println(ranking.getPosicao()+"\t"+ranking.getNome()+"\t"+ ranking.getAcertos()+"/10\t"+ranking.getTempo()/1000+"s");
            }
        }
        System.out.println("\n");
    }

    public static String entrada(){
        return SC.next().trim();
    }

    @Override
    public void run(String... args) throws Exception {
        start();
    }
}
