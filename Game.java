//essa classe pertence ao pacote battlegame
package battlegame;

//uso de ArrayList
import java.util.ArrayList;

//classe Game
public class Game
{
    //instâncias são private
    private 
    int playerOneScore, playerTwoScore, nBattles;
    ArrayList <Character> playerOneDeck, playerTwoDeck, playerOneParty, playerTwoParty;
        final 
        ArrayList <Character> allCharacters;
        Death death;
        int maxBattles;
    //enumeração death    
    public enum Death
    {
        //valores possíveis
        No(0), Yes(1);
        
        private final int value;
        
        //construtor
        Death(int value)
        {
            this.value = value;
        }
        
        //getter
        int getDeath()
        {
            return this.value;
        }
    }
    
    //construtor
    public Game(int maxBattles, Death death)
    {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.nBattles = 0;
        this.maxBattles = maxBattles;
        this.death = death;
        //TO DO: ler um arquivo de texto para criar allCharacters e um método para gerar botDeck e playerDeck
        //só para não dar erro de compilação, vamos setar como null
        this.allCharacters = null;
        this.playerOneDeck = null;
        this.playerTwoDeck = null;
        this.playerOneParty = null;
        this.playerTwoParty = null;
    }
    
    //getters
    public int getPlayerOneScore()
    {
        return this.playerOneScore;
    }

    public int getPlayerTwoScore()
    {
        return this.playerTwoScore;
    }
    
    public int getNBattles()
    {
        return this.nBattles;
    }
    
    public int getMaxBattles()
    {
        return this.maxBattles;
    }
    
    public int getDeath()
    {
        return this.death.getDeath();
    }
    
    public ArrayList <Character> getPlayerOneDeck()
    {
        return this.playerOneDeck;
    }
    
    public ArrayList <Character> getPlayerTwoDeck()
    {
        return this.playerTwoDeck;
    }
    
    public ArrayList <Character> getPlayerOneParty()
    {
        return this.playerOneParty;
    }
    
    public ArrayList <Character> getPlayerTwoParty()
    {
        return this.playerTwoParty;
    }
    
    public ArrayList <Character> getAllCharacters()
    {
        return this.allCharacters;
    }
    
    //setters
    public void setPlayerOneScore(int playerOneScore)
    {
        this.playerScore += playerScore;
    }
    
    public void setPlayerTwoScore(int playerTwoScore)
    {
        this.botScore += botScore;
    }
    
    public void setNBattles()
    {
        this.nBattles += 1;
    }
    //outros métodos serão implementados posteriormente
}
