import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Player {
    protected int warriorsQnt = 0, archersQnt = 0, wizardsQnt = 0, priestsQnt = 0;
    protected ArrayList<Character> deck;
    protected Character charInBattle;
    private final Scanner stdin = new Scanner(System.in);

    // Construtor
    public Player(int charsAvailableQnt, Iterator<String> allCharactersNameItr) {
        // Variavel utilizada nos construtores dos personagens para identificar de quem eh o personagem criado
        String owner = "Jogador";
        // #### Cria o deck do jogador ####
        // Inicializa a variavel
        deck = new ArrayList<>();
        // Escolhe a quantidade de guerreires
        warriorsQnt = readCharsQnt(charsAvailableQnt, "Guerreire");
        for (int i=0; i<warriorsQnt; i++){
            // Cria guerreire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
            deck.add(new Warrior(allCharactersNameItr.next(), owner));
        }
        // Atualiza a quantidade de personagens disponiveis
        charsAvailableQnt -= warriorsQnt;
        // Se ainda houver personagens disponiveis para escolher
        if (charsAvailableQnt >= 1) {
            // Escolhe a quantidade de arqueires
            archersQnt = readCharsQnt(charsAvailableQnt, "Arqueire");
            for (int i=0; i<archersQnt; i++){
                // Cria arqueire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                deck.add(new Archer(allCharactersNameItr.next(), owner));
            }
            charsAvailableQnt -= archersQnt;
        }
        // Se ainda houver personagens disponiveis para escolher
        if (charsAvailableQnt >= 1) {
            // Escolhe a quantidade de bruxes
            wizardsQnt = readCharsQnt(charsAvailableQnt, "Bruxe");
            for (int i=0; i<wizardsQnt; i++){
                // Cria bruxe usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                deck.add(new Wizard(allCharactersNameItr.next(), owner));
            }
            charsAvailableQnt -= wizardsQnt;
        }
        // Se ainda houver personagens disponiveis para escolher
        if (charsAvailableQnt >= 1) {
            // Escolhe a quantidade de sacerdotes
            priestsQnt = readCharsQnt(charsAvailableQnt, "Sacerdote");
            for (int i=0; i<priestsQnt; i++){
                // Cria sacerdote usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                deck.add(new Priest(allCharactersNameItr.next(), owner));
            }
        }
    }

    // Construtor sem argumento que eh chamado na classe Enemy, se faz isso pois nao faz sentido chamar o
    // construtor dessa classe na Enemy, ja que o sistema de criacao de deck eh completamente diferente
    public Player() {}

    public Character getCharInBattle(){ return charInBattle; }
    public ArrayList<Character> getDeck() { return deck; }

    public void printDeck(){
        System.out.println("################### SEU DECK #######################");
        System.out.println();
        for (Character character : this.deck){
            // Imprime o personagem e seus indices comecando por "1"
            System.out.print("["+(deck.indexOf(character)+1)+"] ");
            character.printCharInformation();
            System.out.println();
        }
        System.out.println("####################################################");
        System.out.println();
    }
    public void chooseCharToPutInBattle(){
        // Atualiza o personagem em combate do jogador
        this.charInBattle = readCharByIndex();
        this.charInBattle.putInBattle();
    }
    public void action(Character target){
        this.charInBattle.action(target, this.deck);
    }
    public void removeDeadChar(){
        // Atualiza os contadores
        if (this.charInBattle instanceof Warrior) warriorsQnt--;
        if (this.charInBattle instanceof Archer) archersQnt--;
        if (this.charInBattle instanceof Wizard) wizardsQnt--;
        if (this.charInBattle instanceof Priest) priestsQnt--;
        // Remove do deck
        this.deck.remove(this.charInBattle);
    }
    public void healCharsOutOfBattle(){
        for (Character character : deck){
            if (character != this.charInBattle){
                character.heal(character.con);
            }
        }
    }
    // Retorna a quantidade de personagens escolhida pelo usuario para determinada classe
    private int readCharsQnt(int charsAvailableQnt, String charClass){
        System.out.println();
        System.out.println("* Disponíveis = "+charsAvailableQnt+" *");
        // Aqui usa-se while para tratar o input do usuario,
        // quebrando o loop somente quando um valor permitido eh inserido
        while (true) {
            try {
                System.out.print(charClass+"s: ");
                int charsQnt = Integer.parseInt(stdin.nextLine());
                // Se a quantidade inserida esta dentro dos limites permitidos
                // (positiva e menor/igual que a quantidade disponiveis de personagens)
                if (charsQnt >= 0 && charsQnt <= charsAvailableQnt){
                    return charsQnt;
                }
                else{
                    throw new Exception();
                }
            }
            // Se a quantidade inserida nao for um numero inteiro
            catch (Exception exception){
                System.out.println();
                System.out.println("(ERRO) Por favor, insira um número entre 0 e "+charsAvailableQnt);
            }
        }
    }
    // Retorna personagem escolhido pelo usuario de acordo seu indice
    private Character readCharByIndex(){
        System.out.print("Insira o índice do personagem que deseja colocar em combate: ");
        // Aqui usa-se while para tratar o input do usuario,
        // quebrando o loop somente quando um indice permitido eh inserido
        while (true){

            // Tenta pegar o personagem do indice escolhido no deck
            try {
                /*  Eh importante notar que os indices dos personagens
                    que aparecem para o jogador quando o deck eh impresso comeca em "1",
                    por isso subtrai-se 1 do indice escolhido */
                int charIndex = Integer.parseInt(stdin.nextLine())-1;
                return deck.get((charIndex));
            }
            // Se o usuario escolheu um indice fora dos limites permitidos pelo deck
            catch (Exception exception){
                System.out.println();
                System.out.println("(ERRO) Não foi encontrado nenhum personagem com esse índice no deck.");
                System.out.print("Por favor, insira um índice válido (entre 1 e "+deck.size()+"): ");
            }
        }
    }
}
