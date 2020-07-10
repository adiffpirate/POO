import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Game {
    private
    final int charactersInBattleQnt;
    ArrayList<Character> playerOneDeck, playerTwoDeck;
    final ArrayList<String> allCharactersName = new ArrayList<>();

    // Construtor
    public Game() {
        playerOneDeck = new ArrayList<>();
        playerTwoDeck = new ArrayList<>();

        /*  Le a lista de nomes disponiveis no arquivo CharactersName.txt. Eh preciso considerar a
            excecao do arquivo nao ser encontrado, entao tenta-se executar o codigo e
            caso não se encontre o arquivo, imprime a mensagem de erro e retorna um ArrayList nulo */
        try {
            // Usa um objeto Scanner para ler o arquivo, que eh acessado por um objeto File, que acessa o arquivo CharactersName.txt
            Scanner file = new Scanner(new File("CharactersName.txt"));
            // Os dados serao lidos enquanto nao se chegar ao fim do arquivo
            while (file.hasNextLine()) {
                // Le uma string que será o nome
                String name = file.nextLine();
                // Adiciona nome a lista
                allCharactersName.add(name);
            }
        } catch (FileNotFoundException error) {
            System.out.println("Error");
        }
        // Embaralha-se allCharactersName
        Collections.shuffle(allCharactersName);
        // Cria iterador
        Iterator<String> allCharactersNameItr = allCharactersName.iterator();

        // Gera um numero aleatorio entre 2 e 10 para determinar a quantidade de personagens na batalha
        Random randomNumberGen = new Random();
        charactersInBattleQnt = randomNumberGen.nextInt(9)+2;

        Scanner stdin = new Scanner(System.in);
        System.out.println("### Nesse combate " + charactersInBattleQnt + " personagens irão lutar ###");
        System.out.println("* Escolha a quantidade de personagens em cada classe *");

        // Escolhe a quantidade de guerreiros
        System.out.print("Guerreiros: ");
        int warriorsQnt = Integer.parseInt(stdin.nextLine());
        for (int i=0; i<warriorsQnt; i++){
            // Cria guerreiro usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
            playerOneDeck.add(new Warrior(allCharactersNameItr.next()));
        }
        // Atualiza a quantidade de personagens disponiveis
        int charactersAvailableQnt = charactersInBattleQnt - warriorsQnt;

        // Se ainda houver personagens disponiveis para escolher
        if (charactersAvailableQnt >= 1) {
            // Escolhe a quantidade de arqueiros
            System.out.print("Arqueiros: ");
            int archersQnt = Integer.parseInt(stdin.nextLine());
            for (int i=0; i<archersQnt; i++){
                // Cria arqueiro usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                playerOneDeck.add(new Archer(allCharactersNameItr.next()));
            }
            charactersAvailableQnt -= archersQnt;
        }

        // Se ainda houver personagens disponiveis para escolher
        if (charactersAvailableQnt >= 1) {
            System.out.print("Bruxos: ");
            int wizardsQnt = Integer.parseInt(stdin.nextLine());
            for (int i=0; i<wizardsQnt; i++){
                // Cria bruxo usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                playerOneDeck.add(new Wizard(allCharactersNameItr.next()));
            }
            charactersAvailableQnt -= wizardsQnt;
        }
    }

    public ArrayList<Character> getPlayerOneDeck() {
        return playerOneDeck;
    }

    public void battle() {
    }
}