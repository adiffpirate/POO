public class Main
{
    public static void main(String[] args) {
        Util util = new Util();
        Game game = new Game();
        boolean playerWon=false, enemyWon=false, maxBattlesReached=false;
        // Enquanto houver personagens em um dos decks (os dois decks nao forem vazios)
        // e o numero de batalhas nao estiver no maximo
        while(true){
            // Se o deck do inimigo estiver vazio
            if (game.getEnemy().getDeck().isEmpty()){
                // Determina o jogador como vencedor
                playerWon = true;
                break;
            }
            // Se o deck do jogador estiver vazio
            else if(game.getPlayer().getDeck().isEmpty()){
                // Determina o inimigo como vencedor
                enemyWon = true;
                break;
            }
            // Se o numero maximo de batalhas foi atingido
            else if(game.getBattlesCounter() == game.getMaxBattlesQnt()){
                maxBattlesReached = true;
                break;
            }

            // Se nenhuma das condicoes acima forem atingidas, inicia uma batalha
            game.battle();
        }

        util.clearScreen();
        if (maxBattlesReached){
            System.out.println("O número máximo de batalhas foi alcançado,");
            util.sleep(3); // Pausa para leitura do usuario
            System.out.println("aguarde um momento enquanto é somada a XP dos jogadores");
            util.sleep(5); // Pausa para leitura do usuario
            System.out.println();

            // Calcula a soma da XP do player
            int playerXpSum=0;
            for (Character character : game.getPlayer().getDeck()){
                playerXpSum += character.getXp();
            }
            System.out.println("Você acumulou "+playerXpSum+" pontos.");
            util.sleep(3); // Pausa para leitura do usuario

            // Calcula a soma da XP do inimigo
            int enemyXpSum=0;
            for (Character character : game.getEnemy().getDeck()){
                enemyXpSum += character.getXp();
            }
            System.out.println("O inimigo acumulou "+enemyXpSum+" pontos.");
            util.sleep(3); // Pausa para leitura do usuario

            // Determina o vencedor
            if (playerXpSum > enemyXpSum){
                playerWon = true;
            }else if (enemyXpSum > playerXpSum){
                enemyWon = true;
            }
        }


        util.clearScreen();
        if (playerWon){
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println();
            System.out.println("                                Parabéns!");
            System.out.println("                           Você venceu o jogo!");
            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
        else if (enemyWon){
            // Anuncia a derrota :(
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println();
            System.out.println("                        Aaaaah :( Chorastes???");
            System.out.println("               Sucumba diante o poder da aleatoriedade!");
            System.out.println("                        Melhor sorte na próxima");
            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
        else{
            // Anuncia um empate
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println();
            System.out.println("                    Eita... Bem... Isso eh embaraçoso.");
            System.out.println("               Rolou um empate... Mas é aquela história né...");
            System.out.println("                Quem ganhar ou quem perder, nem quem ganhar");
            System.out.println("                  nem quem perder, vai ganhar ou perder.");
            System.out.println("                         Vai todo mundo perder!");
            System.out.println();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
        System.out.println("\r\n\r\n\r\n");
    }
}
