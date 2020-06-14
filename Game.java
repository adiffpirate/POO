//essa classe pertence ao pacote battlegame
package battlegame;

//uso de ArrayList
import java.util.ArrayList;
//uso da leitura do arquivo
import java.util.Scanner;
import java.io.*;

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
        //TO DO: ler um arquivo de texto para criar allCharacters e um método para gerar playerOneDeck e playerTwoDeck
        //cria-se um ArrayList auxiliar
        ArrayList<Character> aux = new ArrayList<Character>();
        //é preciso considerar a exceção de o arquivo não ser encontrado, então tenta se executar o código e 
        //caso não se encontre o arquivo, imprime-se mensagem de erro e retorna-se um ArrayList nulo
        try
        {
            //usa-se um objeto Scanner para ler o arquivo, que é acessado por um objeto File, que acessa o arquivo CharactersFile.txt
            Scanner sc = new Scanner(new File("CharactersFile.txt"));
            //os dados serão lidos enquanto não se chegar ao fim do arquivo
            while (sc.hasNextLine())
            {
                //lê-se uma string que será o nome
                String name = sc.nextLine();
                //lê-se um inteiro que será o valor inicial de ataque
                int atk = sc.nextInt();
                //como o próximo dado está na próxima linha e o método nextInt() não considera quebra de linha, 
                //o fazemos chamando o método nextLine() sem atribuí-lo a variável alguma
                sc.nextLine();
                //lê-se um inteiro que será o valor inicial de defesa
                int def = sc.nextInt();
                //como o próximo dado está na próxima linha e o método nextInt() não considera quebra de linha, 
                //o fazemos chamando o método nextLine() sem atribuí-lo a variável alguma
                sc.nextLine();
                //lê-se um inteiro que será o valor inicial de velocidade
                int speed = sc.nextInt();
                //como o próximo dado está na próxima linha e o método nextInt() não considera quebra de linha, 
                //o fazemos chamando o método nextLine() sem atribuí-lo a variável alguma
                sc.nextLine();
                //lê-se um inteiro que será o valor inicial de inteligência
                int intel = sc.nextInt();
                //como o próximo dado está na próxima linha e o método nextInt() não considera quebra de linha, 
                //o fazemos chamando o método nextLine() sem atribuí-lo a variável alguma
                sc.nextLine();
                //lê-se um inteiro que indicará qual a classe do personagem
                int classID = sc.nextInt();
                if(classID == 1) aux.add(new Warrior(name, atk, def, speed, intel));
                else if(classID == 2) aux.add(new Wizard(name, atk, def, speed, intel));
                else if(classID == 3) aux.add(new Archer(name, atk, def, speed, intel));
                else aux.add(new Healer(name, atk, def, speed, intel));
            }
        }
        //caso o arquivo não seja encontrado, imprime-se "erro" e retorna-se um ArrayList nulo
        catch (FileNotFoundException error)
        {
            System.out.println("Error");
        }
        this.allCharacters = aux;
        //só para não dar erro de compilação, vamos setar como null
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
        this.playerOneScore += playerOneScore;
    }
    
    public void setPlayerTwoScore(int playerTwoScore)
    {
        this.playerTwoScore += playerTwoScore;
    }
    
    public void setNBattles()
    {
        this.nBattles += 1;
    }
    //outros métodos serão implementados posteriormente
}
