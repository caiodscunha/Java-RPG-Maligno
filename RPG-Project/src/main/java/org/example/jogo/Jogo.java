package org.example.jogo;

import org.example.players.Arqueiro;
import org.example.players.Guerreiro;
import org.example.players.Mago;
import org.example.models.Personagem;

import java.util.Scanner;

public class Jogo {
    static Scanner scanner =  new Scanner(System.in);

    static Personagem jogador;

    private static boolean isRunning = false;

    //Metodo estático para printar opções e ler a selecionada
    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.print(prompt);
            try{
                input = scanner.nextInt();
            }catch(Exception e){
                input = -1;
                System.out.println("\nPor favor, digite um número inteiro...");
                scanner.nextLine();
            }
        }while (input < 1|| input > userChoices);

        return input;
    }

    //Metodo para "limpar" o console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    // printa um separador de linha na tela
    public static void printSeparator(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    //Metodo para printar os títulos
    public static void printHeading(String header){
        printSeparator(30);
        System.out.println(header);
        printSeparator(30);

    }

    public static void anythingToContinue(){
        System.out.print("Aperte qualquer coisa para continuar...");
        scanner.nextLine();
    }

    public static void mainMenu(){
        int input = 0;

        while(input != 3){
            clearConsole();
            printSeparator(40);
            System.out.println("N O M E   D O   J O G O");
            System.out.println("\nCriadoares: ");
            System.out.println("\tCaio Cunha\n\tGuilherme Piovezan");
            printSeparator(40);

            System.out.println("(1) Nova Jornada");
            System.out.println("(2) Carregar Save");
            System.out.println("(3) Sair");

            input = readInt("->", 3);
            scanner.nextLine();

            switch (input){
                case 1 -> startGame();
                case 2 -> loadSave();
                default -> System.out.println("Saindo...");
            }
        }


    }

    private static void loadSave() {

    }

    public static void startGame(){
        boolean nomeSetado = false;
        String nome;

        int input;

        do {
            printHeading("Qual é seu nome?");
            System.out.print("->");

            nome = scanner.nextLine();
            clearConsole();

            printHeading("Seu nome é "+ nome + "?");
            input = readInt("(1)Sim.\n(2)Não, gostaria de mudar.\n->", 2);

            if (input == 1) {
                nomeSetado = true;
            }
            clearConsole();
            scanner.nextLine();


        }while(!nomeSetado);


        printHeading("Escolha Sua Classe:");
        input = readInt("(1)Guerreiro.\n(2)Arqueiro\n(3)Mago\n->", 2);

        if (input == 1) {
            jogador = new Guerreiro(nome);
        } else if (input == 2) {
            jogador = new Arqueiro(nome);
        }else{
            jogador = new Mago(nome);
        }
        scanner.nextLine();
        clearConsole();

        Historia.printIntro();
        clearConsole();
        isRunning = true;
        gameLoop();
    }

    private static void continueJourney() {

    }

    private static void printMenu() {
        clearConsole();

        printHeading("M E N U");

        System.out.println("(1) Explorar");
        System.out.println("(2) Usar itens");
        System.out.println("(3) Salvar e Sair");

    }

    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("->", 3);
            switch (input) {
                case 1 -> continueJourney();
                case 2 -> continueJourney();//usar itens;
                case 3 -> isRunning = false;
            }
            if (input == 1) {
                continueJourney();
            }

        }
    }


}
