public class Main
{
    public static void main(String[] args) {
        Util util = new Util();
        Game game = new Game();
        // Enquanto houver personagens em um dos decks (os dois decks nao forem vazios)
        while (!game.getPlayerDeck().isEmpty() && !game.getEnemyDeck().isEmpty()){
            game.battle();
        }

        util.clearScreen();

        // Se os dois decks estiverem vazios
        if (game.getPlayerDeck().isEmpty() && game.getEnemyDeck().isEmpty()){
            // Anuncia o empate
            System.out.println("\r\n\r\n\r\n");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println();
            System.out.println("Eita... Parabéns... pelo empate");
            System.out.println("É aquela história né...");
            System.out.println("Quem ganhar ou perder, nem quem ganhar nem perder, vai ganhar ou perder.");
            System.out.println("Vai todo mundo perder.");
            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("\r\n\r\n\r\n");
        }
        // Se o deck do inimigo estiver vazio
        else if (game.getEnemyDeck().isEmpty()){
            // Anuncia o jogador como vencedor
            System.out.println("\r\n\r\n\r\n");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println();
            System.out.println("                                Parabéns!");
            System.out.println("                           Você venceu o jogo!");
            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("\r\n\r\n\r\n");
        }
        // Se o deck do jogador estiver vazio
        else if (game.getPlayerDeck().isEmpty()){
            // Anuncia a derrota :(
            System.out.println("\r\n\r\n\r\n");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println();
            System.out.println("                        Aaaaah :( Chorastes???");
            System.out.println("               Sucumba diante o poder da aleatoriedade!");
            System.out.println("                        Melhor sorte na próxima");
            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("\r\n\r\n\r\n");
        }
    }
}
