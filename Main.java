public class Main
{
    public static void main(String[] args) 
    {
    	Game game = new Game();
    	while(game.getNBattles() != game.getMaxBattles()) game.battle();
    }
}
