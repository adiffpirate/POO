import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Game {
    private final int charactersInBattleQnt;
    private final ArrayList<Character> playerDeck, enemyDeck;
    private final ArrayList<String> allCharactersName;
    private final Scanner stdin = new Scanner(System.in);
    private final Util util = new Util();
    private final Random randomNumberGen = new Random();
    private Character playerCharInCombat, enemyCharInCombat;

    // Construtor
    public Game() {
        playerDeck = new ArrayList<>();
        enemyDeck = new ArrayList<>();
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

        // Gera um numero aleatorio entre 2 e 10 para determinar a quantidade de personagens na batalha
        //charactersInBattleQnt = randomNumberGen.nextInt(9)+2;
        charactersInBattleQnt = 2;

        System.out.println("### Nesse combate "+charactersInBattleQnt+" personagens irão lutar ###");
        System.out.println("* Escolha a quantidade de personagens em cada classe *");

        // Declara variaveis auxiliares
        int warriorsQnt, archersQnt, wizardsQnt, priestsQnt;
        // #### Cria o deck do jogador ####
        // Determina a quantidade de personagens disponíveis
        int playerCharsAvailableQnt = charactersInBattleQnt;
        // Escolhe a quantidade de guerreires
        System.out.print("Guerreires: ");
        warriorsQnt = Integer.parseInt(stdin.nextLine());
        for (int i=0; i<warriorsQnt; i++){
            // Cria guerreire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
            playerDeck.add(new Warrior(allCharactersNameItr.next()));
        }
        // Atualiza a quantidade de personagens disponiveis
        playerCharsAvailableQnt -= warriorsQnt;
        // Se ainda houver personagens disponiveis para escolher
        if (playerCharsAvailableQnt >= 1) {
            // Escolhe a quantidade de arqueires
            System.out.print("Arqueires: ");
            archersQnt = Integer.parseInt(stdin.nextLine());
            for (int i=0; i<archersQnt; i++){
                // Cria arqueire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                playerDeck.add(new Archer(allCharactersNameItr.next()));
            }
            playerCharsAvailableQnt -= archersQnt;
        }
        // Se ainda houver personagens disponiveis para escolher
        if (playerCharsAvailableQnt >= 1) {
            // Escolhe a quantidade de bruxes
            System.out.print("Bruxes: ");
            wizardsQnt = Integer.parseInt(stdin.nextLine());
            for (int i=0; i<wizardsQnt; i++){
                // Cria bruxe usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                playerDeck.add(new Wizard(allCharactersNameItr.next()));
            }
            playerCharsAvailableQnt -= wizardsQnt;
        }
        // Se ainda houver personagens disponiveis para escolher
        if (playerCharsAvailableQnt >= 1) {
            // Escolhe a quantidade de bruxes
            System.out.print("Sacerdotes: ");
            priestsQnt = Integer.parseInt(stdin.nextLine());
            for (int i=0; i<priestsQnt; i++){
                // Cria sacerdote usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                playerDeck.add(new Priest(allCharactersNameItr.next()));
            }
        }

        // #### Cria o deck do inimigo ####
        // Determina a quantidade de personagens disponíveis
        int enemyCharsAvailableQnt = charactersInBattleQnt;
        // Escolhe quantidade aleatoria de guerreires
        warriorsQnt = randomNumberGen.nextInt(charactersInBattleQnt+1);
        for (int i=0; i<warriorsQnt; i++){
            // Cria guerreire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
            enemyDeck.add(new Warrior(allCharactersNameItr.next()));
        }
        // Atualiza a quantidade de personagens disponiveis
        enemyCharsAvailableQnt -= warriorsQnt;
        // Se ainda houver personagens disponiveis para escolher
        if (enemyCharsAvailableQnt >= 1) {
            // Escolhe quantidade aleatoria de arqueires
            archersQnt = randomNumberGen.nextInt(enemyCharsAvailableQnt+1);
            for (int i=0; i<archersQnt; i++){
                // Cria arqueire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                enemyDeck.add(new Archer(allCharactersNameItr.next()));
            }
            enemyCharsAvailableQnt -= archersQnt;
        }
        // Se ainda houver personagens disponiveis para escolher
        if (enemyCharsAvailableQnt >= 1) {
            // Escolhe quantidade aleatoria de arqueires
            wizardsQnt = randomNumberGen.nextInt(enemyCharsAvailableQnt+1);
            for (int i=0; i<wizardsQnt; i++){
                // Cria bruxe usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                enemyDeck.add(new Wizard(allCharactersNameItr.next()));
            }
            enemyCharsAvailableQnt -= wizardsQnt;
        }
        /*  Por ser o ultimo a ser criado, a quantidade de sacerdotes eh igual a quantidade de personagens
            disponiveis restantes, pois tirando a aleatoriedade aqui garantimos que o jogador
            e o inimigo tenham a mesma quantidade de personagens no inicio da batalha
            ( nao precisa do if aqui, pois se "priestsQnt == 0" ele nao entra no for ) */
        priestsQnt = enemyCharsAvailableQnt;
        for (int i=0; i<priestsQnt; i++){
            // Cria sacerdote usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
            enemyDeck.add(new Priest(allCharactersNameItr.next()));
        }
    }

    // Getters
    public int getCharactersInBattleQnt() { return charactersInBattleQnt; }
    public ArrayList<Character> getPlayerDeck() { return playerDeck; }
    public ArrayList<Character> getEnemyDeck() { return enemyDeck; }
    public ArrayList<String> getAllCharactersName() { return allCharactersName; }

    // Nao tem setters pois todas as variaveis sao final

    public void battle() {
        util.clearScreen();

        this.printPlayerDeck();
        this.printEnemyInfo();

        System.out.print("Insira o índice do personagem que deseja colocar em combate: ");
        int charIndex = Integer.parseInt(stdin.nextLine());
        /* Atualiza o personagem em combate do jogador.
        Eh importante notar que os indices dos personagens
        que aparecem para o jogador quando o deck eh impresso comeca em "1",
        por isso no get abaixo subtrai-se 1 do indice escolhido */
        playerCharInCombat = this.playerDeck.get(charIndex - 1);

        // Escolhe um personagem inimigo aleatorio
        enemyCharInCombat = this.enemyDeck.get(randomNumberGen.nextInt(enemyDeck.size()));

        util.clearScreen();
        System.out.println("################## SEU PERSONAGEM ##################");
        System.out.println();
        playerCharInCombat.printCharInformation();
        System.out.println();
        System.out.println("####################################################");
        System.out.println();
        System.out.println("                         VS                         ");
        System.out.println();
        System.out.println("################ PERSONAGEM INIMIGO ################");
        System.out.println();
        enemyCharInCombat.printCharInformation();
        System.out.println();
        System.out.println("####################################################");
        System.out.println();
        System.out.println();

        util.sleep(5); // Pequena pausa para leitura do usuario
        // Acontece o combate, aquele com maior agilidade faz sua acao primeiro
        // ( em caso de empate os dois fazem suas acoes ao mesmo tempo )
        if (playerCharInCombat.getAgi() > enemyCharInCombat.getAgi()){
            util.sleep(2); // Pequena pausa para leitura do usuario
            // To do: trocar essa frase generica por frases personalizadas de acordo a classe
            // ( talvez fazer um arquivo com varias frases pra cada classe e escolher uma aleatoria aqui )
            // Personagem do jogador faz sua acao
            System.out.println(playerCharInCombat.getName()+" faz sua ação");
            playerCharInCombat.action(enemyCharInCombat);
            // Se o inimigo ainda estiver vivo
            if (enemyCharInCombat.isAlive()){
                util.sleep(2); // Pequena pausa para leitura do usuario
                // Personagem do inimigo faz sua acao
                System.out.println(enemyCharInCombat.getName()+" faz sua ação");
                enemyCharInCombat.action(playerCharInCombat);
            }
        }
        else if (enemyCharInCombat.getAgi() > playerCharInCombat.getAgi()){
            util.sleep(2); // Pequena pausa para leitura do usuario
            // Personagem do inimigo faz sua acao
            System.out.println(enemyCharInCombat.getName()+" faz sua ação");
            enemyCharInCombat.action(playerCharInCombat);
            // Se o jogador ainda estiver vivo
            if (playerCharInCombat.isAlive()){
                util.sleep(2); // Pequena pausa para leitura do usuario
                // Personagem do jogador faz sua acao
                System.out.println(playerCharInCombat.getName()+" faz sua ação");
                playerCharInCombat.action(enemyCharInCombat);
            }
        }
        else{
            util.sleep(2); // Pequena pausa para leitura do usuario
            // Os dois personagens fazem suas acoes
            System.out.println(playerCharInCombat.getName()+" e "+ enemyCharInCombat.getName()+" fazem suas ações ao mesmo tempo");
            playerCharInCombat.action(enemyCharInCombat);
            enemyCharInCombat.action(playerCharInCombat);
        }

        // Parte final do combate onde os pontos de experiencia do morto sao roubados pelo vivo
        // e o morto eh removido do deck
        if (enemyCharInCombat.isDead()){
            if (playerCharInCombat.isAlive()){
                playerCharInCombat.stealXP(enemyCharInCombat);
            }
            this.removeFromEnemyDeck(enemyCharInCombat);
        }
        if (playerCharInCombat.isDead()){
            if (enemyCharInCombat.isAlive()){
                enemyCharInCombat.stealXP(playerCharInCombat);
            }
            this.removeFromPlayerDeck(playerCharInCombat);
        }

        util.sleep(3); // Pequena pausa para leitura do usuario

        // Recupera o HP dos personagens fora de batalha
        this.healCharsOutOffBattle();
    }
    public void printPlayerDeck(){
        System.out.println("################### SEU DECK #######################");
        System.out.println();
        for (Character character : this.playerDeck){
            // Imprime o personagem e seus indices comecando por "1"
            System.out.print("["+(this.playerDeck.indexOf(character)+1)+"] ");
            character.printCharInformation();
            System.out.println();
        }
        System.out.println("####################################################");
        System.out.println();
    }
    public void printEnemyInfo(){
        int warriorsQnt = 0, archersQnt = 0, wizardsQnt = 0, priestsQnt = 0;
        // Conta o numero de personagens em cada classe
        for (Character character : this.enemyDeck){
            if (character instanceof Warrior) warriorsQnt++;
            else if (character instanceof Archer) archersQnt++;
            else if (character instanceof Wizard) wizardsQnt++;
            else if (character instanceof Priest) priestsQnt++;
        }
        System.out.println("***** Personagens do inimigo *****");
        System.out.println();
        if (warriorsQnt > 0) System.out.println("           "+warriorsQnt+" guerreires");
        if (archersQnt > 0) System.out.println("           "+archersQnt+" arqueires");
        if (wizardsQnt > 0) System.out.println("           "+wizardsQnt+" bruxes");
        if (priestsQnt > 0) System.out.println("           "+priestsQnt+" sacerdotes");
        System.out.println();
        System.out.println("**********************************");
        System.out.println();
    }
    public void removeFromPlayerDeck(Character character){
        this.playerDeck.remove(character);
    }
    public void removeFromEnemyDeck(Character character){
        this.enemyDeck.remove(character);
    }
    public void healCharsOutOffBattle(){
        for (Character playerChar : this.playerDeck){
            if (playerChar != this.playerCharInCombat){
                playerChar.heal(playerChar.con);
            }
        }
        for (Character enemyChar : this.enemyDeck){
            if (enemyChar != this.enemyCharInCombat){
                enemyChar.heal(enemyChar.con);
            }
        }
    }
}