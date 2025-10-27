package org.example.jogo;

import org.example.models.efeitos.efeitos.EfeitoCura;
import org.example.models.efeitos.efeitos.EfeitoDano;
import org.example.models.inventario.Inventario;
import org.example.models.itens.Item;
import org.example.models.itens.itens.dano.Bomba;
import org.example.models.itens.itens.cura.PocaoCuraPequena;
import org.example.models.personagens.inimigos.comuns.*;
import org.example.models.personagens.inimigos.inimigo.Inimigo;
import org.example.models.personagens.players.classes.Arqueiro;
import org.example.models.personagens.players.classes.Guerreiro;
import org.example.models.personagens.players.classes.Mago;
import org.example.models.personagens.players.player.Player;
import org.example.save.Save;
import org.example.save.SaveManager;

import java.util.List;
import java.util.Scanner;

public class  Jogo {
    static Scanner scanner =  new Scanner(System.in);

    static Player jogador;

    private static boolean isRunning = false;

    private static int gameAct = 1;
    private static int place = 0;

    private static boolean primeiraExploracaoFeita = false;
    private static String[] places = {"Entrada da masmorra", "Profundezas da masmorra", "Escadaria da masmorra", "Saida assombrada"};

    private static String[] encontros = {"Esqueleto", "Zumbi", "Slime"};

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
        printSeparator(60);
        System.out.println(header);
        printSeparator(60);

    }

    public static void anythingToContinue(){
        System.out.print("\nAperte qualquer coisa para continuar...");
        scanner.nextLine();
    }

    public static void mainMenu(){
        int input = 0;

        while(input != 3){
            clearConsole();
            printSeparator(130);
            System.out.println("""
                     ▄████████    ▄████████ ▄██   ▄      ▄████████     ███        ▄████████  ▄█          ▄████████  ▄██████▄   ▄██████▄      ███    \s
                    ███    ███   ███    ███ ███   ██▄   ███    ███ ▀█████████▄   ███    ███ ███         ███    ███ ███    ███ ███    ███ ▀█████████▄\s
                    ███    █▀    ███    ███ ███▄▄▄███   ███    █▀     ▀███▀▀██   ███    ███ ███         ███    ███ ███    ███ ███    ███    ▀███▀▀██\s
                    ███         ▄███▄▄▄▄██▀ ▀▀▀▀▀▀███   ███            ███   ▀   ███    ███ ███        ▄███▄▄▄▄██▀ ███    ███ ███    ███     ███   ▀\s
                    ███        ▀▀███▀▀▀▀▀   ▄██   ███ ▀███████████     ███     ▀███████████ ███       ▀▀███▀▀▀▀▀   ███    ███ ███    ███     ███    \s
                    ███    █▄  ▀███████████ ███   ███          ███     ███       ███    ███ ███       ▀███████████ ███    ███ ███    ███     ███    \s
                    ███    ███   ███    ███ ███   ███    ▄█    ███     ███       ███    ███ ███▌    ▄   ███    ███ ███    ███ ███    ███     ███    \s
                    ████████▀    ███    ███  ▀█████▀   ▄████████▀     ▄████▀     ███    █▀  █████▄▄██   ███    ███  ▀██████▀   ▀██████▀     ▄████▀  \s
                                 ███    ███                                                 ▀           ███    ███                                  \s""");
            System.out.println("\nCriadoares: ");
            System.out.println("\tCaio Cunha\n\tGuilherme Piovezan");
            printSeparator(130);

            System.out.println("(1) Nova Jornada");
            System.out.println("(2) Carregar Save");
            System.out.println("(3) Sair");

            input = readInt("->", 3);
            scanner.nextLine();

            switch (input){
                case 1 -> {
                    startGame();
                    gameAct = 1;
                    primeiraExploracaoFeita = false;
                    gameLoop();
                }
                case 2 -> {
                    loadGame();
                    gameLoop();
                }
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
            System.out.printf("(%d) %s\n",
                    i + 1,
                    s.toString()
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
        primeiraExploracaoFeita = selectedSave.isPrimeiraExploracaoFeita();

        isRunning = true;
        loadInimigos();

        clearConsole();
        System.out.println("Save carregado com sucesso! Bem-vindo(a) de volta, " + jogador.getNome() + "!");
        anythingToContinue();
    }

    private static void loadInimigos(){
        switch (gameAct) {
            case 1 -> encontros = new String[]{"Slime", "Esqueleto", "Zumbi"};
            case 2 -> encontros = new String[]{"Morcego", "Fantasma", "Aranha"};
            case 3 -> encontros = new String[]{"Olho Demoníaco", "Demônio", "Ceifador"};
        }
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
            loadInimigos();
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

    }

    private static void checkAct() {
        if(jogador.getNivel() >= 5 && gameAct == 1){

            clearConsole();
            System.out.println("Você chegou em um trecho crítico da história, \ngostaria de salvar?");
            int option = readInt("(1)Sim\n(2)Não\n->", 2);
            if(option == 1){
                Save save = new Save(jogador, gameAct, primeiraExploracaoFeita);
                SaveManager.salvar(jogador.getNome(), save);

            }

            bossFight(1);

            primeiraExploracaoFeita = false;
            gameAct = 2;
            place = 1;

            loadInimigos();

            scanner.nextLine();
            Historia.printSecondAct();
            //mudar o ato da história e settar o array de encontros
        }else if(jogador.getNivel() >= 8 && gameAct == 2){


            clearConsole();
            System.out.println("Você chegou em um trecho crítico da história, \ngostaria de salvar?");
            int option = readInt("(1)Sim\n(2)Não\n->", 2);
            if(option == 1){
                Save save = new Save(jogador, gameAct, primeiraExploracaoFeita);
                SaveManager.salvar(jogador.getNome(), save);

            }

            bossFight(2);

            primeiraExploracaoFeita = false;
            gameAct = 3;
            place = 2;

            loadInimigos();
            scanner.nextLine();
            Historia.printThirdAct();
            //mudar o ato da história e settar o array de encontros
        }else if(jogador.getNivel() >= 12 && gameAct == 3){

            clearConsole();
            System.out.println("Você chegou em um trecho crítico da história, \ngostaria de salvar?");
            int option = readInt("(1)Sim\n(2)Não\n->", 2);
            if(option == 1){
                Save save = new Save(jogador, gameAct, primeiraExploracaoFeita);
                SaveManager.salvar(jogador.getNome(), save);
            }

            bossFight(3);

            primeiraExploracaoFeita = false;
            gameAct = 4;
            place = 3;

            scanner.nextLine();
            Historia.printFourthAct();

        } else if (gameAct == 4 && primeiraExploracaoFeita) {

            clearConsole();
            System.out.println("Você chegou em um trecho crítico da história, \ngostaria de salvar?");
            int option = readInt("(1)Sim\n(2)Não\n->", 2);
            if(option == 1){
                Save save = new Save(jogador, gameAct, primeiraExploracaoFeita);
                SaveManager.salvar(jogador.getNome(), save);
            }

            bossFight(4);

            historyEvent(
                    Historia.getEscolhaFinal(),
                    Historia.getEscolhaFinalOpcoes(),
                    Historia::getRespostaEscolhaFinal,
                    (escolha) -> {
                        if (escolha == 1) {
                            // FINAL BOM
                            Historia.printFinal(true);
                        } else {
                            // FINAL RUIM
                            Historia.printFinal(false);
                        }
                    }
            );
            isRunning = false;

        }
    }

    private static void continueJourney() {
        int tempAct = gameAct;
        checkAct();
        if (tempAct != gameAct) return;

        if (!primeiraExploracaoFeita) {
            primeiraExploracaoFeita = true;

            if(gameAct == 1) {
                historyEvent(
                        Historia.getPrimeiraEscolha(),
                        Historia.getPrimeiraEscolhaOpcoes(),
                        Historia::getRespostaPrimeiraEscolha,
                        null
                );

                historyEvent(
                        Historia.getEncontroIdosoDescricao(),
                        Historia.getEncontroIdosoOpcoes(),
                        Historia::getRespostaEncontroIdoso,
                        (escolha) -> {
                            switch (escolha) {
                                case 1 -> jogador.getInventario().adicionarItem(new PocaoCuraPequena(1));
                                case 2 -> jogador.aplicarVida(-5);
                                case 3 -> jogador.aplicarVida(-10);
                            }
                        }
                );
            }

            if(gameAct == 2){
                historyEvent(
                        Historia.getEncontroBifurcacao(),
                        Historia.getEncontroBifurcacaoOpcoes(),
                        Historia::getRespostaEncontroBifurcacao,
                        (escolha) -> {
                            switch (escolha) {
                                case 1 -> jogador.getInventario().adicionarItem(new Bomba(1));
                                case 2 -> jogador.aplicarVida(-100);
                            }
                        }
                );
            }

            if(gameAct == 3){
                historyEvent(
                        Historia.getVoltarEscadaria(),
                        Historia.getVoltarEscadariaOpcoes(),
                        Historia::getRespostaVoltarEscadaria,
                        (escolha) -> {
                            if (escolha == 1) {
                                jogador.aplicarVida(-30);
                            }
                        }
                );
            }

            if(gameAct == 4){
                historyEvent(
                        Historia.getVelhoPerguntaFinal(),
                        Historia.getVelhoPerguntaFinalOpcoes(),
                        Historia::getRespostaVelhoPerguntaFinal,
                        (escolha) -> {
                            switch (escolha) {
                                case 1 -> jogador.aplicarVida(100);
                                case 3 -> jogador.aplicarVida(-100);
                            }
                        }
                );
            }

            return;
        }

        if (gameAct != 4) {
            randomEncounter();
        }
    }

    private static void historyEvent(
            String descricao,
            List<String> opcoes,
            java.util.function.Function<Integer, String> resposta,
            java.util.function.Consumer<Integer> consequencia // pode ser null
    ) {
        Jogo.clearConsole();
        System.out.println(descricao);
        Jogo.printSeparator(40);

        for (int i = 0; i < opcoes.size(); i++) {
            System.out.printf("(%d) %s%n", i + 1, opcoes.get(i));
        }

        int escolha = Jogo.readInt("-> ", opcoes.size());
        Jogo.clearConsole();

        System.out.println(resposta.apply(escolha));

        if (consequencia != null) {
            consequencia.accept(escolha);
        }
        scanner.nextLine();
        Jogo.anythingToContinue();
    }

    private static Inimigo createEnemy(String type, int level) {
        // Retorna a nova instância da subclasse com o nível escalonado
        return switch (type) {
            case "Esqueleto" -> new Esqueleto(level);
            case "Slime" -> new Slime(level);
            case "Zumbi" -> new Zumbi(level);
            case "Aranha" -> new Aranha(level);
            case "Fantasma" -> new Fantasma(level);
            case "Morcego" -> new Morcego(level);
            case "Demônio" -> new Demonio(level);
            case "Olho Demoníaco" -> new OlhoDemoniaco(level);
            case "Ceifador" -> new Ceifador(level);
            default -> new Inimigo("Inimigo Desconhecido", level, 22+2*level, 5, 5);
        };
    }

    private static void randomEncounter() {
        int chance = (int)(Math.random() * 100); // 0 a 99

        // Encontro com inimigo
        if (chance < 70) { // 70% de chance
            int enemyIndex = (int)(Math.random() * encontros.length);
            Inimigo inimigo = createEnemy(encontros[enemyIndex], jogador.getNivel());
            battle(inimigo, false);
        } else {
            // Evento aleatório: 70% baú, 30% fogueira
            double eventoChance = Math.random(); // 0.0 a 1.0

            if (eventoChance < 0.7) { // 70% chance de baú
                System.out.println("Você encontra um baú no caminho...");
                System.out.println("(1) Abrir o baú\n(2) Ignorar");
                int escolha = readInt("-> ", 2);
                if (escolha == 1) {
                    boolean isArmadilha = Math.random() < 0.5; // 50% mimico ou armadilha
                    if (isArmadilha) {
                        boolean isMimico = Math.random() < 0.7;
                        if (isMimico) {
                            int dano = 10 + (int) (Math.random() * 11); // 10-20
                            System.out.println("Era um mimico! Você é atacado e perde " + dano + " pontos de vida.");
                            jogador.aplicarVida(-dano);
                        } else {
                            int dano = 20 + (int) (Math.random() * 21); // 20-40
                            System.out.println("Era uma armadilha! Uma grande explosão acontece, você perde " + dano + " pontos de vida.");
                            jogador.aplicarVida(-dano);
                        }
                    } else {
                        System.out.println("O baú continha algo útil! Você encontra uma Poção de Cura.");
                        jogador.getInventario().adicionarItem(new PocaoCuraPequena(1));
                    }
                } else {
                    System.out.println("Você decide ignorar o baú e segue em frente.");
                }
            } else { // 30% chance de fogueira
                System.out.println("Você encontra uma fogueira de descanso.");
                System.out.println("Você descansa e recupera 50 pontos de vida!");
                jogador.aplicarVida(50);
            }

            scanner.nextLine();
            Jogo.anythingToContinue();
        }
    }

    private static void battle(Inimigo inimigo, boolean isBossBattle) {
        int input, xp;

        do{
            clearConsole();
            printBattleHud(inimigo);

            input = readInt("->", 3);

            switch (input){
                case 1 -> {
                    inimigo.tomarDano(jogador);
                    scanner.nextLine();
                    anythingToContinue();
                    if(!inimigo.isVivo()) break;
                    jogador.tomarDano(inimigo);
                    anythingToContinue();
                }
                case 2 -> {
                    boolean usedItem = usarItemEmCombate(inimigo);
                    if(!usedItem) continue;
                    jogador.tomarDano(inimigo);
                    anythingToContinue();
                }
                default -> {
                    if(isBossBattle) {
                        System.out.println("Você Não Tem Para Onde Fugir...");
                        scanner.nextLine();
                        anythingToContinue();
                        jogador.tomarDano(inimigo);
                        anythingToContinue();
                        break;
                    }
                    if(Math.random()*20 < 10){
                        System.out.println("Você Fugiu...");
                        scanner.nextLine();
                        anythingToContinue();
                        return;
                    }
                    System.out.println("Você falha ao fugir...");
                    scanner.nextLine();
                    anythingToContinue();
                    jogador.tomarDano(inimigo);
                }
            }



        }while (inimigo.isVivo() && jogador.isVivo());

        if(!jogador.isVivo()) {
            jogadorMorreu();
            return;
        }

        xp = inimigo.getDropedXp();

        System.out.println("Você Venceu! +"+xp+"XP");
        jogador.upar(xp);
        pilharInimigo(inimigo);
        anythingToContinue();


    }

    private static void pilharInimigo(Inimigo inimigo) {
        try{
            jogador.getInventario().pilhar(inimigo);
        }catch (Exception e){System.err.println("Erro ao pilhar inimigo.");}
    }

    private static boolean usarItemEmCombate(Inimigo inimigo) {
        Inventario inventario = jogador.getInventario();

        clearConsole();
        inventario.listarItens();

        if (inventario.isVazio()) {
            anythingToContinue();
            return false;
        }

        int opcoes = inventario.quantidadeItens()+1;
        System.out.println("("+opcoes+") Voltar");

        System.out.println("\nDigite o número item que deseja usar: ");
        int indexItem = readInt("->", opcoes);
        scanner.nextLine();

        if (opcoes == indexItem) return false;

        Item item = inventario.buscarItem(indexItem);

        // Decide o alvo com base no tipo de efeito
        if (item.getEfeito() instanceof EfeitoCura) {
            System.out.println("\nVocê usou " + item.getNome() + " em si mesmo!");
            inventario.usarItem(indexItem, jogador);
        } else if (item.getEfeito() instanceof EfeitoDano) {
            System.out.println("\nVocê usou " + item.getNome() + "!");
            inventario.usarItem(indexItem, inimigo);
        } else {
            System.out.println("O item não possui um efeito utilizável neste momento!");
        }

        // Remove ou decrementa a quantidade
        anythingToContinue();
        return true;
    }

    private static void jogadorMorreu() {
        clearConsole();
        printHeading("V O C Ê   M O R R E U !");
        System.out.println("Sua jornada termina aqui, " + jogador.getNome() + ".");
        printSeparator(30);
        System.out.println("Você lutou bravamente.");
        printSeparator(30);

        isRunning = false;

        anythingToContinue();
    }

    private static void printBattleHud(Inimigo inimigo) {
        printHeading("BATALHA - " + places[place]);
        System.out.println(inimigo.toString());
        printSeparator(60);
        System.out.println(inimigo.inimigoAsciiArt());

        printSeparator(60);
        System.out.println(jogador.toString());
        printSeparator(60);
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
                case 2 -> {
                    clearConsole();
                    Inventario inventario = jogador.getInventario();

                    inventario.listarItens();

                    if (inventario.isVazio()) {
                        anythingToContinue();
                        continue;
                    }
                    int opcoes = inventario.quantidadeItens()+1;
                    System.out.println("("+opcoes+") Voltar");

                    System.out.println("\nDigite o número item que deseja usar: ");
                    int indexItem = readInt("->", opcoes);
                    scanner.nextLine();

                    if (opcoes == indexItem) continue;

                    inventario.usarItem(indexItem,  jogador);
                    anythingToContinue();

                }//usar itens;
                case 3 -> {

                    Save save = new Save(jogador, gameAct, primeiraExploracaoFeita);
                    boolean isSaved = SaveManager.salvar(jogador.getNome(), save);
                    anythingToContinue();


                }
                case 4 -> {
                    isRunning = false;
                }
            }

        }
    }

    private static void bossFight(int act) {
        Inimigo boss = switch (act) {
            case 1 -> new org.example.models.personagens.inimigos.boss.ReiSlime(jogador.getNivel());
            case 2 -> new org.example.models.personagens.inimigos.boss.OlhoDoCthulhu(jogador.getNivel());
            case 3 -> new org.example.models.personagens.inimigos.boss.DevoradorDeMundos(jogador.getNivel());
            default -> new org.example.models.personagens.inimigos.boss.Skeleton(jogador.getNivel());
        };

        clearConsole();
        printHeading("⚔️ BATALHA CONTRA O BOSS ⚔️");

        // Exibe o nome e o nível do boss, igual aos inimigos normais
        System.out.println(boss.toString());
        printSeparator(60);

        // Mostra arte ASCII do boss
        System.out.println(boss.inimigoAsciiArt());
        printSeparator(60);

        System.out.println("Se prepare para a batalha!");
        scanner.nextLine();
        anythingToContinue();

        battle(boss, true);

    }

}
