package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 */
public class DominoBrutalRepetido {

    public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
        int vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0;
        Map<String, List> pontuacoes;
        pontuacoes = new HashMap<>();

        pontuacoes.put("J1", new ArrayList());
        pontuacoes.put("J2", new ArrayList());

        EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new JogaCarrocaPrimeiro();

        for (int i = 0; i < 5000; i++) {
            Jogo j = new Jogo("J1", estrategia1, "J2", estrategia2, 12);
            HistoricoDeJogo historico = j.jogaJogoCompleto();
            if (historico.isEmpate()) {
                empates++;
            } else if (historico.getVencedor() == "J1") {
                vitoriasJ1++;
                pontuacoes.get("J1").add(j.getPontuacao());

            } else if (historico.getVencedor() == "J2") {
                vitoriasJ2++;
                pontuacoes.get("J2").add(j.getPontuacao());
            }
        }
        for (int i = 0; i < 5000; i++) {
            Jogo j = new Jogo("J2", estrategia2, "J1", estrategia1, 12);
            HistoricoDeJogo historico = j.jogaJogoCompleto();
            if (historico.isEmpate()) {
                empates++;
            } else if (historico.getVencedor() == "J1") {
                vitoriasJ1++;
                pontuacoes.get("J1").add(j.getPontuacao());
            } else if (historico.getVencedor() == "J2") {
                vitoriasJ2++;
                pontuacoes.get("J2").add(j.getPontuacao());
            }
        }
        System.out.println("Jogos:\t" + (empates + vitoriasJ1 + vitoriasJ2) + "\nJ1:\t" + vitoriasJ1 + " vitórias\nJ2:\t"
                + vitoriasJ2 + " vitórias\nEmpate:\t" + empates);
        System.out.println(pontuacoes("J1", pontuacoes));
        System.out.println(pontuacoes("J2", pontuacoes));
    }

    private static String pontuacoes(String jogador, Map<String, List> pontuacoes) {
        String saida = "\nPontuacao do jogador " + jogador + "\n";
        int pontuacaoTotalCalculada = 0;
        //lista q armazena oo tipo vitoria pra cada jogo.
        List<Integer> historicoPontuacoes = pontuacoes.get(jogador);
        //somatorio do tipo de vitoria.
        Map<String, Integer> pontuacaoTotal = new HashMap<>();

        //percorremos o historico
        for (int p : historicoPontuacoes) {
            if (p == 1) {
                if (pontuacaoTotal.containsKey("Batida Normal")) {
                    pontuacaoTotal.put("Batida Normal", pontuacaoTotal.get("Batida Normal") + 1);
                } else {
                    pontuacaoTotal.put("Batida Normal", 1);
                }
            }
            if (p == 2) {
                if (pontuacaoTotal.containsKey("Carroca")) {
                    pontuacaoTotal.put("Carroca", pontuacaoTotal.get("Carroca") + 2);
                } else {
                    pontuacaoTotal.put("Carroca", 2);
                }
            }
            if (p == 3) {
                if (pontuacaoTotal.containsKey("La e Lo")) {
                    pontuacaoTotal.put("La e Lo", pontuacaoTotal.get("La e Lo") + 3);
                } else {
                    pontuacaoTotal.put("La e Lo", 3);
                }
            }
            if (p == 6) {
                if (pontuacaoTotal.containsKey("Quadrada")) {
                    pontuacaoTotal.put("Quadrada", pontuacaoTotal.get("Quadrada") + 6);
                } else {
                    pontuacaoTotal.put("Quadrada", 6);
                }
            }
        }
        for (String chave : pontuacaoTotal.keySet()) {
            saida += chave + ": " + pontuacaoTotal.get(chave) + "\n";
            pontuacaoTotalCalculada += pontuacaoTotal.get(chave);
        }
        saida += "Pontuacao total: " + pontuacaoTotalCalculada;
        return saida;
    }

}

