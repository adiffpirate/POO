//essa classe pertence ao pacote battlegame
package battlegame;

//uso de ArrayList
import java.util.ArrayList;

//classe Game
public class Game
{
    //instâncias são private
    private 
    int playerScore, botScore, nBattles;
    ArrayList <Character> botDeck, playerDeck;
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
        this.playerScore = 0;
        this.botScore = 0;
        this.nBattles = 0;
        this.maxBattles = maxBattles;
        this.death = death;
        //TO DO: ler um arquivo de texto para criar allCharacters e um método para gerar botDeck e playerDeck
        //só para não dar erro de compilação, vamos setar como null
        this.allCharacters = null;
        this.botDeck = null;
        this.playerDeck = null;
    }
    
    //getters
    public int getPlayerScore()
    {
        return this.playerScore;
    }

    public int getBotScore()
    {
        return this.botScore;
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
    
    public ArrayList <Character> getPlayerDeck()
    {
        return this.playerDeck;
    }
    
    public ArrayList <Character> getBotDeck()
    {
        return this.botDeck;
    }
    
    public ArrayList <Character> getAllCharacters()
    {
        return this.allCharacters;
    }
    
    //setters
    public void setPlayerScore(int playerScore)
    {
        this.playerScore += playerScore;
    }
    
    public void setBotScore(int botScore)
    {
        this.botScore += botScore;
    }
    
    public void setNBattles()
    {
        this.nBattles += 1;
    }
}
