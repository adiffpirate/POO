public class Main
{
    public static void main(String[] args) {
        Util util = new Util();
        Game game = new Game();
        // Enquanto houver personagens em um dos decks (os dois decks nao forem vazios)
        while (!game.getPlayer().getDeck().isEmpty() && !game.getEnemy().getDeck().isEmpty()){
            game.battle();
        }

        util.clearScreen();

        // Se o deck do inimigo estiver vazio
        if (game.getEnemy().getDeck().isEmpty()){
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
        else {
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
