package org.example.jogo;

public class Historia {

    public static void printIntro(){
        Jogo.printHeading("Introdução");

        String intro = """
                Era uma vez, um homem muito autista e sei lá porra
                kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
                
                """;
        System.out.println(intro);
        Jogo.anythingToContinue();

    }
}
