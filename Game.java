//essa classe pertence ao pacote battlegame
//package battlegame;

//uso de ArrayList
import java.util.ArrayList;
//uso da leitura do arquivo e embaralhamento das cartas
import java.util.*;
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
    public Game()
    {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.nBattles = 0;
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
                //lê-se um inteiro que indicará qual a classe do personagem
                int classID = sc.nextInt();
                if(classID == 1) aux.add(new Warrior(name, atk, def));
                else if(classID == 2) aux.add(new Wizard(name, atk, def));
                else aux.add(new Archer(name, atk, def));
            }
        }
        //caso o arquivo não seja encontrado, imprime-se "erro" e retorna-se um ArrayList nulo
        catch (FileNotFoundException error)
        {
            System.out.println("Error");
        }
        //atribui-se allCharacters a aux
        this.allCharacters = aux;
        //embaralha-se allCharacters
        Collections.shuffle(allCharacters);
        //distribui-se as cartas
        for(int i=0; i<3; i+=1) this.playerOneDeck.add(this.allCharacters.get(i));
        for(int i=3; i<6; i+=1) this.playerTwoDeck.add(this.allCharacters.get(i));
        //como as batalhas ainda não começaram, os times estão vazios
        this.playerOneParty = null;
        this.playerTwoParty = null;
        //pergunta-se o número máximo de batalhas
        System.out.println("Qual será o número máxima de batalhas?");
        Scanner input = new Scanner(System.in);
        this.maxBattles = input.nextInt();
        //pergunta-se se os personagens vão morrer ou ser transferidos
        System.out.println("Quando um personagem for derrotado, você quer que ele morra ou seja transferido para o oponente?");
        System.out.println("(0) Seja transferido para o oponente");
        System.out.println("(1) Morra");
        int auxDeath = input.nextInt();
        if(auxDeath==0)this.death=death.No;
        else this.death=death.Yes;
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
    public void battle()
    {
        if(this.nBattles % 2 == 0)
        {
            System.out.println("Jogador 1, monte seu time digitando o index e dando enter a cada personagem");
            System.out.println("Use quantos personagens quiser e termine digitando 6");
            System.out.println("Esses são seus personagens disponíveis:");
            for(int i=0; i < getPlayerOneDeck().size(); i+=1) 
            {
                System.out.println("(" + i + ") " + getPlayerOneDeck().get(i).getName() + " - Nível " + getPlayerOneDeck().get(i).getLevel() + ":");
                System.out.println("HP: " + getPlayerOneDeck().get(i).getHp() + "/" + getPlayerOneDeck().get(i).getMaxHp() + ", Ataque " +
                getPlayerOneDeck().get(i).getAttack() + ", Defesa " + getPlayerOneDeck().get(i).getDefense() + ", Poder " + getPlayerOneDeck().get(i).getPower());
            }
            Scanner deck = new Scanner(System.in);
            int index = 0;
            while(index != 6)
            {
                index = deck.nextInt();
                if(index!=6)getPlayerOneParty().add(getPlayerOneDeck().get(index));
            }
            System.out.println("Jogador 2, monte um time com " + getPlayerOneParty().size() + "personagens");
            System.out.println("Esses são seus personagens disponíveis:");
            for(int i=0; i < getPlayerTwoDeck().size(); i+=1) 
            {
                System.out.println("(" + i + ") " + getPlayerTwoDeck().get(i).getName() + " - Nível " + getPlayerTwoDeck().get(i).getLevel() + ":");
                System.out.println("HP: " + getPlayerOneDeck().get(i).getHp() + "/" + getPlayerOneDeck().get(i).getMaxHp() + ", Ataque " +
                getPlayerTwoDeck().get(i).getAttack() + ", Defesa " + getPlayerTwoDeck().get(i).getDefense() + ", Poder " + getPlayerTwoDeck().get(i).getPower());
            }
            for(int i = 0; i < getPlayerOneParty().size(); i+=1)
            {
                index = deck.nextInt();
                getPlayerTwoParty().add(getPlayerTwoDeck().get(index));
            }
        }
        else
        {
            System.out.println("Jogador 2, monte seu time digitando o index e dando enter a cada personagem");
            System.out.println("Use quantos personagens quiser e termine digitando 6");
            System.out.println("Esses são seus personagens disponíveis:");
            for(int i=0; i < getPlayerTwoDeck().size(); i+=1) 
            {
                System.out.println("(" + i + ") " + getPlayerTwoDeck().get(i).getName() + " - Nível " + getPlayerTwoDeck().get(i).getLevel() + ":");
                System.out.println("HP: " + getPlayerTwoDeck().get(i).getHp() + "/" + getPlayerTwoDeck().get(i).getMaxHp() + ", Ataque " +
                getPlayerTwoDeck().get(i).getAttack() + ", Defesa " + getPlayerTwoDeck().get(i).getDefense() + ", Poder " + getPlayerTwoDeck().get(i).getPower());
            }
            Scanner deck = new Scanner(System.in);
            int index=0;
            while(index != 6)
            {
                index = deck.nextInt();
                if(index!=6)getPlayerTwoParty().add(getPlayerTwoDeck().get(index));
            }
            System.out.println("Jogador 1, monte um time com " + getPlayerTwoParty().size() + "personagens");
            System.out.println("Esses são seus personagens disponíveis:");
            for(int i=0; i < getPlayerOneDeck().size(); i+=1) 
            {
                System.out.println("(" + i + ") " + getPlayerOneDeck().get(i).getName() + " - Nível " + getPlayerOneDeck().get(i).getLevel() + ":");
                System.out.println("HP: " + getPlayerOneDeck().get(i).getHp() + "/" + getPlayerOneDeck().get(i).getMaxHp() + ", Ataque " +
                getPlayerOneDeck().get(i).getAttack() + ", Defesa " + getPlayerOneDeck().get(i).getDefense() + ", Poder " + getPlayerOneDeck().get(i).getPower());
            }
            for(int i = 0; i < getPlayerTwoParty().size(); i+=1)
            {
                index = deck.nextInt();
                getPlayerOneParty().add(getPlayerOneDeck().get(index));
            }
        }
        System.out.println("A batalha começa!");
        int turn;
        if(getNBattles() % 2 == 0)turn = 0;
        else turn = 1;
        while(getPlayerOneParty().size()!=0 && getPlayerTwoParty().size()!=0)
        {
            if(turn%2==0)
            {
                if(getPlayerOneParty().get(turn/2).getPower() > 4)
                {
                    System.out.println("Vez do jogador 1 com " + getPlayerOneParty().get(turn/2).getName());
                    System.out.println("HP dos oponentes: ");
                    for(int i=0; i<getPlayerTwoParty().size();i+=1)
                    System.out.println("(" + i + ") " + getPlayerTwoDeck().get(i).getName() + ": " + getPlayerTwoDeck().get(i).getHp());
                    System.out.println("Digite o index da ação desejada");
                    getPlayerOneParty().get(turn/2).showActions(getPlayerOneParty().get(turn/2).getPower());
                    Scanner as = new Scanner(System.in);
                    int action = as.nextInt();
                    int opIndex;
                    if(action==0)
                    {
                        getPlayerOneParty().get(turn/2).setPower(5);
                        System.out.println("Digite o index do alvo");
                        opIndex = as.nextInt();
                        getPlayerOneParty().get(turn/2).individualAttack(getPlayerTwoParty().get(opIndex));
                    }
                    else 
                    {
                        getPlayerOneParty().get(turn/2).setPower(10);
                        getPlayerOneParty().get(turn/2).groupAttack();
                    }
                }
            else
            {
                System.out.println("Vez do jogador 2");
            }
        }
    }
}
}
