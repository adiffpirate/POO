import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Game {
    private final ArrayList<String> allCharactersName;
    private final Scanner stdin = new Scanner(System.in);
    private final Util util = new Util();
    private final Random randomNumberGen = new Random();
    private final Player player;
    private final Enemy enemy;

    // Construtor
    public Game() {
        allCharactersName = new ArrayList<>();

        /*  Le a lista de nomes disponiveis no arquivo CharactersName.txt. Eh preciso considerar a
            excecao do arquivo nao ser encontrado, entao tenta-se executar o codigo e
            caso não se encontre o arquivo, imprime a mensagem de erro e retorna um ArrayList nulo */
        try {
            // Usa um objeto Scanner para ler o arquivo, que eh acessado por um objeto File, que acessa o arquivo CharactersName.txt
            Scanner file = new Scanner(new File("src/CharactersName.txt"));
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

        // Gera um numero aleatorio entre 5 e 10 para determinar a quantidade de personagens na batalha
        //int charactersInBattleQnt = randomNumberGen.nextInt(6)+5;
        int charactersInBattleQnt = 2;

        System.out.println("### Nesse combate "+charactersInBattleQnt+" personagens irão lutar ###");
        System.out.println("* Escolha a quantidade de personagens em cada classe *");

        // Cria jogador
        player = new Player(charactersInBattleQnt, allCharactersNameItr);
        // Cria inimigo
        enemy = new Enemy(charactersInBattleQnt, allCharactersNameItr);
    }

    public Player getPlayer() { return player; }
    public Enemy getEnemy() { return enemy; }

    public void battle() {
        util.clearScreen();

        this.player.printDeck();
        this.enemy.printInfo();

        this.player.chooseCharToPutInBattle();
        this.enemy.chooseCharToPutInBattle();

        util.clearScreen();
        System.out.println("################## SEU PERSONAGEM ##################");
        System.out.println();
        this.player.getCharInBattle().printCharInformation();
        System.out.println();
        System.out.println("####################################################");
        System.out.println();
        System.out.println("                         VS                         ");
        System.out.println();
        System.out.println("################ PERSONAGEM INIMIGO ################");
        System.out.println();
        this.enemy.getCharInBattle().printCharInformation();
        System.out.println();
        System.out.println("####################################################");
        System.out.println();
        System.out.println();
        util.sleep(5); // Pequena pausa para leitura do usuario

        // Decide quem comeca atacando de acordo os valores de agilidade de cada um
        // ( em caso de empate um cara ou coroa virtual decide quem ataca primeiro )
        boolean playerStartsTheBattle = false, enemyStartsTheBattle = false; // Variaveis auxiliares
        // Se o personagem do jogador tiver mais agilidade
        if (this.player.getCharInBattle().getAgi() > this.enemy.getCharInBattle().getAgi()){
            playerStartsTheBattle = true;
        }
        // Se o personagem do inimigo tiver mais agilidade
        else if (this.enemy.getCharInBattle().getAgi() > this.player.getCharInBattle().getAgi()){
            enemyStartsTheBattle = true;
        }
        // Se empatar
        else{
            // Gera um numero aleatorio entre 0 e 1
            int number = randomNumberGen.nextInt(2);
            System.out.println(this.player.getCharInBattle().getName()+" e "+this.enemy.getCharInBattle().getName()+" tem os mesmos valores de agilidade,");
            util.sleep(2); // Pequena pausa para leitura do usuario
            System.out.println("então jogarão um cara ou coroa para decidir quem faz a ação primeiro:");
            util.sleep(2); // Pequena pausa para leitura do usuario
            System.out.println();
            if (number == 0){
                System.out.println("("+this.player.getCharInBattle().getOwner()+")"+" "+this.player.getCharInBattle().getName()+" foi o vencedor.");
                playerStartsTheBattle = true;
            }else{
                System.out.println("("+this.enemy.getCharInBattle().getOwner()+")"+" "+this.enemy.getCharInBattle().getName()+" foi o vencedor.");
                enemyStartsTheBattle = true;
            }
            util.sleep(2); // Pequena pausa para leitura do usuario
            System.out.println();
        }

        if (playerStartsTheBattle){
            // Personagem do jogador faz sua acao
            this.player.action(this.enemy.getCharInBattle());
            // Se o inimigo ainda estiver vivo
            if (this.enemy.getCharInBattle().isAlive()){
                // Personagem do inimigo faz sua acao
                this.enemy.action(this.player.getCharInBattle());
            }
        }
        else if (enemyStartsTheBattle){
            // Personagem do inimigo faz sua acao
            this.enemy.action(this.player.getCharInBattle());
            // Se o jogador ainda estiver vivo
            if (this.player.getCharInBattle().isAlive()){
                // Personagem do jogador faz sua acao
                this.player.action(this.enemy.getCharInBattle());
            }
        }

        // Parte final do combate, onde o vivo rouba XP do morto (caso haja)
        if(enemy.getCharInBattle().isDead()){ // Se o personagem do inimigo estiver morto
            // Personagem do jogador rouba a XP do inimigo
            this.player.getCharInBattle().stealXP(this.enemy.getCharInBattle());
            // Remove personagem do inimigo
            this.enemy.removeDeadChar();
        }
        else if(player.getCharInBattle().isDead()){ // Se o personagem do jogador estiver morto
            // Personagem do inimigo rouba a XP do jogador
            this.enemy.getCharInBattle().stealXP(this.player.getCharInBattle());
            // Remove personagem do jogador
            this.player.removeDeadChar();
        }

        util.sleep(2); // Pequena pausa para leitura do usuario

        // Recupera o HP dos personagens que nao lutaram
        player.healCharsOutOfBattle();
        enemy.healCharsOutOfBattle();

        // Retira os personagens da batalha
        player.getCharInBattle().putOutOffBattle();
        enemy.getCharInBattle().putOutOffBattle();
    }
}