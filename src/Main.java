public class Main
{
    public static void main(String[] args)
    {
        Game game = new Game();
        for (Character character : game.getPlayerOneDeck()){
            character.printCharInformation();
        }
    }
}
