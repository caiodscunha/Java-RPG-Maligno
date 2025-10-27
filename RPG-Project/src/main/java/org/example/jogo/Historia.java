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
    public static String getPrimeiraEscolha() {
        return """
                Você dá seus primeiros passos dentro da masmorra...
                O ar é frio e pesado. Sons de correntes ecoam ao longe.
                De repente, uma sombra se move entre as colunas quebradas.

                O que você faz?
                """;
    }

    public static List<String> getPrimeiraEscolhaOpcoes() {
        return List.of(
                "Saco a arma e me preparo para lutar.",
                "Tento observar com cuidado, talvez não seja um inimigo.",
                "Corro de volta para a entrada — ainda dá tempo de desistir."
        );
    }

    public static String getRespostaPrimeiraEscolha(int escolha) {
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
        Jogo.clearConsole();
        Jogo.printHeading("Segundo Ato");
        System.out.println("Você encontra uma escada que leva para as profundezas da masmorra.");
        Jogo.anythingToContinue();

        Jogo.clearConsole();
        Jogo.printHeading("Profundezas da Masmorra");
        System.out.println("Ao descer a escada, o ar fica mais frio e úmido. Você percebe que está em um corredor estreito, iluminado por tochas antigas nas paredes.");
        System.out.println("Ao avançar, você ouve o som de passos ecoando à distância. Algo se move nas sombras...");
        Jogo.anythingToContinue();
    }

    // ENCONTRA BIFURCACAO
    public static String getEncontroBifurcacao() {
        return """
                Você se aproxima de uma bifurcação no corredor. Para onde deseja ir?
                """;
    }

    public static List<String> getEncontroBifurcacaoOpcoes() {
        return List.of(
                "Seguir pelo corredor à esquerda, onde o som é mais intenso.",
                "Seguir pelo corredor à direita, que está em completo silencio."
        );
    }

    public static String getRespostaEncontroBifurcacao(int escolha) {
        return switch (escolha) {
            case 1 -> """
                   Você decide seguir pelo corredor à esquerda. 
                   Conforme se aproxima, um pequeno esqueleto surge.
                   Todo aquele barulho vinha apenas dele.
                   Você o derrota com facilidade.
                   (Você pega uma bomba)
                    """;
            case 2 -> """
                   Você decide seguir pelo corredor à direita. 
                   Ao caminhar ouve um barulho intenso vindo do chão.
                   Sem que você possa reagir o chão se quebra totalmente.
                   Você cai e se machuca muito.
                   (Você perde 100 pontos de vida)
                    """;
            default -> "";
        };
    }

    public static void printThirdAct() {
        Jogo.clearConsole();
        Jogo.printHeading("Terceiro Ato");
        System.out.println("Você sente que andou em circulos, você encontra o que aparenta ser a mesma escada que usou para descer");
        Jogo.anythingToContinue();

        Jogo.clearConsole();
        Jogo.printHeading("Escadaria da Masmorra");
        System.out.println("Você tenta entender como chegou a escada novamente, o caminho em sua cabeça não faz sentido.");
        System.out.println("Antes de subir as escadas você decide dar uma olhada no local, será que realmente aquela é a mesma escada?");
        System.out.println("O único caminho realmente é subir as escadas, você começa a subir e agora tem certeza, aquela não é a mesma escadaria.");
        System.out.println("Você sente um alivio inicial de saber que aquelas escadas provavelmente levam a saída, um sentimento de missão cumprida preenche seu ser.");
        Jogo.anythingToContinue();
    }

    public static String getVoltarEscadaria() {
        return """
                O sentimento de missão cumprida não dura muito, seu corpo é tomado por medo. O que você deseja fazer?
                """;
    }

    public static List<String> getVoltarEscadariaOpcoes() {
        return List.of(
                "Descer as escadas e buscar uma nova saída.",
                "Seguir pelas escadas e enfrentar o medo que sente."
        );
    }

    public static String getRespostaVoltarEscadaria(int escolha) {
        return switch (escolha) {
            case 1 -> """
                   Você decide descer as escadas. 
                   Conforme se vira para descer, um ser misterioso surge.
                   Ele tem uma velocidade assustadora.
                   Você desvia no ultimo segundo.
                   Aquele golpe teria sido fatal, ele some na escuridão.
                   Aquele é o aviso que o único caminho é subir as escadas.
                   Você desiste de descer e sai apenas com um arranhão.
                   (Você perde 30 pontos de vida)
                    """;
            case 2 -> """
                   Você decide continuar subindo as escadas. 
                   A cada passo o medo aumenta, mas voltar significa desistir de sair.
                   Você se prepara para o combate.
                   (Nada acontece)
                    """;
            default -> "";
        };
    }

    public static void printFourthAct() {
        Jogo.clearConsole();
        Jogo.printHeading("Quarto Ato");
        System.out.println("Você chegou a saída da masmorra, um ser familiar espreita a saída");
        Jogo.anythingToContinue();

        Jogo.clearConsole();
        Jogo.printHeading("Saida assombrada");
        System.out.println("Você olha bem e percebe, é o mesmo velho que estava na entrada.");
        System.out.println("Você repara e ve que a saída não é o memsmo local de entrada.");
        System.out.println("Como ele foi parar ali?");
        System.out.println("Ele olha pra você, você sente um calafrio que nunca antes sentiu.");
        System.out.println("Nada naquela masmorra te fez sentir tanto medo quanto o olhar do velho.");
        Jogo.anythingToContinue();
    }

    public static String getVelhoPerguntaFinal() {
        return """
            O velho encara você em silêncio por alguns segundos.
            Então, com uma voz rouca e profunda, ele pergunta:
            
            "O que você realmente buscava ao desafiar esta masmorra?"
            """;
    }

    public static List<String> getVelhoPerguntaFinalOpcoes() {
        return List.of(
                "Melhorar minhas habilidades para proteger aqueles que são importantes para mim.",
                "Queria apenas uma aventura, mas agora o único desejo é sair vivo daqui.",
                "Riquezas e glória! Nada nesse mundo importa mais que riquezas!"

        );
    }

    public static String getRespostaVelhoPerguntaFinal(int escolha) {
        return switch (escolha) {
            case 1 -> """
                O velho observa você em silêncio... e um leve sorriso aparece em seu rosto.
                "Talvez ainda haja esperança em você."
                Um brilho dourado envolve seu corpo.
                (Você é abençoado e recupera 100 pontos de vida)
                
                Eu realmente não queria ter que fazer isso com você...
                (O velho se transforma em um esqueleto gigante!)
                """;

            case 2 -> """
                O velho abaixa a cabeça lentamente.
                "A força sem propósito é destruição."
                Ele levanta o cajado — o chão treme, e uma energia sombria toma conta do local.
                (O velho se transforma em um esqueleto gigante!)
                """;

            case 3 -> """
                O velho começa a rir, alto e sinistro.
                "Hahaha... então você entendeu menos do que eu pensava!"
                As chamas da masmorra o envolvem.
                Uma dor intensa invade seu corpo.
                (Você perde 100 pontos de vida)
                
                Você escolheu isso!
                (O velho se transforma em um esqueleto gigante!)
                """;

            default -> "";
        };
    }

    public static String getEscolhaFinal() {
        return """
            O corpo do Skeleton se desfaz em pó, 
            revelando um estranho cristal flutuando diante de você.
            
            Ele pulsa com uma energia antiga... 
            a mesma energia que dominava toda a masmorra.
            
            A voz do velho ecoa em sua mente uma última vez:
            "O poder que você buscava agora é seu... 
             Mas... saberá usá-lo?"
            
            Você sente duas forças dentro de si: 
            uma pede para destruir o cristal, 
            a outra, para aceitá-lo.
            
            O que você faz?
            """;
    }

    public static List<String> getEscolhaFinalOpcoes() {
        return List.of(
                "Destruir o cristal.",
                "Absorver o poder."
        );
    }

    public static String getRespostaEscolhaFinal(int escolha) {
        return switch (escolha) {
            case 1 -> """
                Você levanta sua arma e golpeia o cristal com toda sua força.
                Uma luz intensa explode pelo salão.
                
                Quando a claridade se dissipa, o cristal desapareceu...
                e com ele, a maldição da masmorra.
                
                Você cai de joelhos, exausto, mas vivo.
                O ar ao seu redor está leve. A paz finalmente voltou.
                
                (O ciclo foi encerrado)
                """;
            case 2 -> """
                Você estende a mão e toca o cristal.
                Uma energia sombria percorre seu corpo — dor e poder se misturam.
                
                Sua visão escurece... você sente o mundo ao seu redor desaparecer.
                Quando abre os olhos novamente, tudo é escuridão.
                
                Sua consciência está presa.
                Agora, você é o novo Devorador de Mundos.
                
                (O ciclo recomeça)
                """;
            default -> "";
        };
    }

    public static void printFinal(boolean finalBom) {
        Jogo.clearConsole();

        if (finalBom) {
            Jogo.printHeading("O Último Suspiro");

            System.out.println("""
                O brilho do cristal desaparece...
                A energia sombria que antes dominava o salão se dissipa lentamente.
                O silêncio toma conta — um silêncio diferente, cheio de paz.

                As paredes da masmorra começam a ruir, mas agora não há medo.
                Você sente que cumpriu seu destino.
                """);

            Jogo.anythingToContinue();
            Jogo.clearConsole();

            Jogo.printHeading("O Fim da Maldição");

            System.out.println("""
                Conforme corre para fora, o ar se torna leve.
                O sol toca sua pele e você sente, pela primeira vez, o peso da vida — e não da luta.
                Atrás de você, a masmorra se desfaz, como poeira levada pelo vento.
                
                O velho, ou talvez apenas sua memória, sussurra:
                "Você escolheu o caminho certo..."
                """);

            Jogo.anythingToContinue();
            Jogo.clearConsole();

            Jogo.printHeading("O Novo Amanhecer");

            System.out.println("""
                O deserto volta ao silêncio.
                Nenhuma sombra, nenhum sussurro, apenas o som do vento e da areia.

                Você olha para o horizonte e entende:
                o poder não está mais preso — nem você.
                
                Talvez o ciclo tenha realmente chegado ao fim.
                """);

            Jogo.anythingToContinue();
            Jogo.clearConsole();

            Jogo.printHeading("FIM - O CICLO FOI ENCERRADO");
            System.out.println("""
                Obrigado por jogar.
                
                Esta jornada chegou ao fim...
                Mas heróis como você sempre encontrarão novos caminhos.

                (Desenvolvido por Caio Cunha e Guilherme Piovezan)
                """);
            Jogo.printSeparator(50);
            Jogo.anythingToContinue();

        } else {
            // 🔥 Final Ruim
            Jogo.printHeading("O Novo Skeleton");

            System.out.println("""
                A energia do cristal invade seu corpo.
                A dor é insuportável, mas dentro dela, há poder... e prazer.
                
                As paredes da masmorra tremem e, por um instante, tudo se apaga.
                Quando seus olhos se abrem, não há mais corpo — apenas escuridão.
                
                Você sente cada grão de areia, cada pedra... 
                a masmorra respira com você.
                """);

            Jogo.anythingToContinue();
            Jogo.clearConsole();

            Jogo.printHeading("O Ciclo Recomeça");

            System.out.println("""
                Vozes antigas ecoam em sua mente:
                "Você destruiu o portador... para se tornar o próximo."

                Lá fora, o deserto silencia novamente.
                A entrada da masmorra se ergue da areia, intacta.

                Em breve, outro aventureiro chegará.
                E quando o fizer...
                você estará esperando.
                """);

            Jogo.anythingToContinue();
            Jogo.clearConsole();

            Jogo.printHeading("FIM - O CICLO CONTINUA");
            System.out.println("""
                A maldição nunca foi quebrada.
                Ela apenas mudou de nome.

                (Desenvolvido por Caio Cunha e Guilherme Piovezan)
                """);
            Jogo.printSeparator(50);
            Jogo.anythingToContinue();
        }
    }

}
