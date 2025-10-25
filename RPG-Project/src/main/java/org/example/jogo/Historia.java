package org.example.jogo;

import java.util.List;

public class Historia {

    // INTRODUÇÃO
    public static void printIntro() {
        Jogo.printHeading("Introdução");

        String[] introParts = {
                "Você caminha pelo deserto por horas, o sol castigando cada passo. " +
                        "O vento levanta pequenas ondas de areia dourada, até que algo chama sua atenção no horizonte...",

                "Entre as dunas, surge uma estrutura antiga, uma fortaleza de pedra, quase engolida pelo tempo. " +
                        "\nPortas imensas, cobertas por runas apagadas, marcam a entrada de uma antiga masmorra esquecida. " +
                        "\nUm frio estranho percorre sua espinha, mesmo sob o calor do deserto.",

                "Perto da entrada, há marcas de batalha antigas... " +
                        "\nEspadas quebradas, elmos enferrujados e ossos espalhados contam histórias de guerreiros que tentaram adentrar o lugar e nunca voltaram.",

                "Um sussurro ecoa em sua mente, uma voz rouca e distante:\n\"Quem ousa perturbar o sono dos mortos?\"",

                "Você sente que há algo poderoso lá dentro, algo que te observa... " +
                        "\nMas a curiosidade fala mais alto.",

                "Você se aproxima lentamente da entrada da Masmorra, e o ar fica pesado. " +
                        "\nAs sombras se movem. Algo desperta..."
        };

        for (String part : introParts) {
            System.out.println(part);
            System.out.println();
            Jogo.anythingToContinue();
            Jogo.clearConsole();
        }

        Jogo.printHeading("O destino o aguarda...");
        System.out.println("Você respira fundo e adentra a escuridão da Masmorra.\n");
        Jogo.anythingToContinue();
    }

    // PRIMEIRA EXPLORAÇÃO
    public static String getPrimeiraExploracaoDescricao() {
        return """
                Você dá seus primeiros passos dentro da masmorra...
                O ar é frio e pesado. Sons de correntes ecoam ao longe.
                De repente, uma sombra se move entre as colunas quebradas.

                O que você faz?
                """;
    }

    public static List<String> getPrimeiraExploracaoOpcoes() {
        return List.of(
                "Saco a arma e me preparo para lutar.",
                "Tento observar com cuidado, talvez não seja um inimigo.",
                "Corro de volta para a entrada — ainda dá tempo de desistir."
        );
    }

    public static String getRespostaPrimeiraExploracao(int escolha) {
        return switch (escolha) {
            case 1 -> "Você ergue sua arma, pronto para enfrentar o que vier! Seu coração acelera... ao chegar mais perto, percebe que era apenas um velho.";
            case 2 -> "Você observa com atenção... era apenas um velho enfraquecido! Você se aproxima cautelosamente.";
            case 3 -> "Você dá alguns passos para trás... mas sua coragem fala mais alto. Você respira fundo e decide seguir em frente e vê a figura de um velho.";
            default -> "";
        };
    }

    // ENCONTRO COM O IDOSO
    public static String getEncontroIdosoDescricao() {
        return """
                Você avança alguns passos e vê o velho mais claramente.
                O ar é úmido e o som das gotas ecoa pelas paredes de pedra.

                A voz rouca do homem quebra o silêncio:
                "Heh... há quanto tempo não vejo alguém vivo por aqui..."

                À frente, um idoso de barba longa e manto rasgado te observa com olhos cansados.
                """;
    }

    public static List<String> getEncontroIdosoOpcoes() {
        return List.of(
                "Perguntar quem ele é.",
                "Ignorar o velho e seguir em frente.",
                "Ameaçá-lo com sua arma."
        );
    }

    public static String getRespostaEncontroIdoso(int escolha) {
        return switch (escolha) {
            case 1 -> """
                    O velho sorri levemente.
                    "Quem eu sou não importa... o que importa é o que está à sua frente."
                    Ele te entrega um pequeno frasco vermelho.
                    "Vai precisar disso."
                    (Você recebeu uma Poção de Cura!)
                    """;
            case 2 -> """
                    Você passa direto, fingindo não ouvir.
                    Atrás de você, a voz ecoa:
                    "Ignorar o aviso de um sábio é um caminho sem volta..."
                    Você tropeça e acaba se machucando.
                    (Você perdeu 5 pontos de vida)
                    """;
            case 3 -> """
                    Você ergue a arma. O velho apenas ri.
                    "A pressa e o medo andam juntos... cuidado para não tropeçar neles."
                    Quando você pisca, ele desaparece.
                    Você sente o ar pesado, uma dor atinge seu corpo.
                    (Você perdeu 10 pontos de vida)
                    """;
            default -> "";
        };
    }

    // SEGUNDO ATO
    public static void printSecondAct() {
        Jogo.printHeading("Segundo Ato");
        System.out.println("Apenas testando...");
        Jogo.anythingToContinue();
    }
}
