package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
    static Scanner scanner =  new Scanner(System.in);

    static Personagem jogador;

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

    public static void anithingToContinue(){
        System.out.print("Aperte qualquer coisa para continuar...");
        scanner.nextLine();
    }

    public static void startGame(){
        boolean nomeSetado = false;
        String nome;

        int input;

        clearConsole();
        printSeparator(40);
        System.out.println("N O M E   D O   J O G O");
        System.out.println("\nCriadoares: ");
        System.out.println("\tCaio Cunha\n\tGuilherme Piovezan");
        printSeparator(40);

        anithingToContinue();
        clearConsole();

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

        clearConsole();

    }
}
