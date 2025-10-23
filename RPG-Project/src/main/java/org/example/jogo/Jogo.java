package org.example.jogo;

import org.example.models.personagens.inimigos.Inimigo;
import org.example.models.personagens.players.classes.Arqueiro;
import org.example.models.personagens.players.classes.Guerreiro;
import org.example.models.personagens.players.classes.Mago;
import org.example.models.personagens.personagem.Personagem;
import org.example.models.personagens.players.player.Player;
import org.example.save.Save;
import org.example.save.SaveManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class  Jogo {
    static Scanner scanner =  new Scanner(System.in);

    static Player jogador;

    private static boolean isRunning = false;

    private static int gameAct = 1;
    private static int place = 0;
    private static String[] places = {"Cela do caps", "Everhood Stream", "Labubu land", "Saida assombrada"};

    private static Inimigo[] encontros = {new Inimigo("teste", 1)};

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
                case 2 -> loadGame();
                default -> System.out.println("Saindo...");
            }
        }


    }

    private static void loadGame() {
        clearConsole();

        List<Save> allSaves = SaveManager.listAllSaves();

        if (allSaves.isEmpty()) {
            printHeading("Nenhum Save Encontrado!");
            anythingToContinue();
            return;
        }

        printHeading("Escolha um Save para Carregar:");

        for (int i = 0; i < allSaves.size(); i++) {
            Save s = allSaves.get(i);
            System.out.printf("(%d) %s | Ato %d\n",
                    i + 1,
                    s.getJogador().toString(),
                    s.getGameAct()
            );
        }
        System.out.printf("(%d) Voltar\n", allSaves.size() + 1);

        int input = readInt("->", allSaves.size() + 1);
        scanner.nextLine();

        if (input == allSaves.size() + 1) {
            return;
        }

        Save selectedSave = allSaves.get(input - 1);

        jogador = selectedSave.getJogador();
        gameAct = selectedSave.getGameAct();

        isRunning = true;
        clearConsole();
        System.out.println("Save carregado com sucesso! Bem-vindo(a) de volta, " + jogador.getNome() + "!");
        anythingToContinue();
        gameLoop();
    }

    public static void startGame(){
        boolean nomeSetado = false;
        String nome;

        int input;

        do {
            clearConsole();
            printHeading("Qual é seu nome?");
            System.out.print("->");

            nome = scanner.nextLine();
            clearConsole();

            List<Save> existingSaves = SaveManager.listAllSaves();

            boolean nomeEmUso = false;
            for (Save s : existingSaves) {
                if (s.getJogador().getNome().equalsIgnoreCase(nome)) {
                    nomeEmUso = true;
                    break;
                }
            }

            if (nomeEmUso) {
                printHeading("Erro: O nome '" + nome + "' já está em uso em um save existente.");
                anythingToContinue();
                continue;
            }

            printHeading("Seu nome é "+ nome + "?");
            input = readInt("(1)Sim.\n(2)Não, gostaria de mudar.\n->", 2);

            if (input == 1) {
                nomeSetado = true;
            }
            clearConsole();
            scanner.nextLine();


        }while(!nomeSetado);


        printHeading("Escolha Sua Classe:");
        input = readInt("(1)Guerreiro.\n(2)Arqueiro\n(3)Mago\n->", 3);

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

    private static void checkAct() {
        if(jogador.getNivel() >= 5 && gameAct == 1){
            clearConsole();
            System.out.println("Você chegou em um trecho crítico da história, \ngostaria de salvar?");
            int option = readInt("(1)Sim\n(2)Não\n->", 2);
            if(option == 1){
                Save save = new Save(jogador, gameAct);
                SaveManager.salvar(jogador.getNome(), save);

            }

            //TODO: Antes de trocar de ato, tocar a boss fight

            gameAct = 2;
            place = 1;
            encontros = new Inimigo[]{new Inimigo("teste", jogador.getNivel())};
            scanner.nextLine();
            Historia.printSecondAct();
            //mudar o ato da história e settar o array de encontros
        }else if(jogador.getNivel() >= 8 && gameAct == 2){
            clearConsole();
            System.out.println("Você chegou em um trecho crítico da história, \ngostaria de salvar?");
            int option = readInt("(1)Sim\n(2)Não\n->", 2);
            if(option == 1){
                Save save = new Save(jogador, gameAct);
                SaveManager.salvar(jogador.getNome(), save);

            }


            gameAct = 3;
            place = 2;
            //mudar o ato da história e settar o array de encontros
        }
    }

    private static void continueJourney() {
        int tempAct = gameAct;
        checkAct();
        if(tempAct != gameAct) return;
        if(gameAct != 4){
            randomEncounter();
            return;
        }
    }

    private static void randomEncounter() {
        int random = (int) (Math.random() * (encontros.length*1.5));

        if(encontros.length <= random){
            System.out.println("Descanso?");
            anythingToContinue();
            //sortear algo bom(Rest ou Achar item)
        }else{
            Inimigo inimigo = encontros[random].clone();
            battle(inimigo);

            //batalha com inimigo
        }
    }

    private static void battle(Inimigo inimigo) {
        int input, xp;

        do{
            clearConsole();
            printBattleHud(inimigo);

            input = readInt("->", 3);

            switch (input){
                case 1 -> {
                    inimigo.tomarDano(jogador);
                    if(!inimigo.isVivo()) break;
                    jogador.tomarDano(inimigo);
                }
                case 2 -> {
                    //n feito ainda
                }
                default -> {
                    if(Math.random()*20 < 10){
                        System.out.println("Você Fugiu...");
                        anythingToContinue();
                        return;
                    }
                    System.out.println("Você falha ao fugir...");
                    anythingToContinue();
                    jogador.tomarDano(inimigo);
                }
            }

            scanner.nextLine();

        }while (inimigo.isVivo() && jogador.isVivo());

        if(!jogador.isVivo()) jogadorMorreu();

        xp = inimigo.getDropedXp();

        System.out.println("Você Venceu! +"+xp+"XP");
        jogador.upar(xp);
        anythingToContinue();


    }

    private static void jogadorMorreu() {
        System.out.println("Jogador Morreu!");
    }

    private static void printBattleHud(Inimigo inimigo) {
        printHeading("BATALHA - " + places[place]);
        System.out.println(inimigo.toString());
        printSeparator(30);
        System.out.println(inimigo.inimigoAsciiArt());

        printSeparator(30);
        System.out.print(
                """
                (1) Lutar
                (2) Usar Item
                (3) Fugir
                """);


    }

    private static void printMenu() {
        clearConsole();

        printHeading("M E N U");
        System.out.println(jogador);
        printSeparator(10);

        System.out.println("""
                (1) Explorar
                (2) Usar itens
                (3) Salvar
                (4) Sair""");

    }

    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("->", 4);
            switch (input) {
                case 1 -> continueJourney();
                case 2 -> continueJourney();//usar itens;
                case 3 -> {

                    Save save = new Save(jogador, gameAct);
                    boolean isSaved = SaveManager.salvar(jogador.getNome(), save);
                    anythingToContinue();


                }
                case 4 -> {
                    isRunning = false;
                }
            }

        }
    }


}
