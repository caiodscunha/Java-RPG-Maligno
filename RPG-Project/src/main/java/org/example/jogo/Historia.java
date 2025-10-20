package org.example.jogo;

public class Historia {

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
                        "\nMas a curiosidade fala mais alto. ",

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
}
