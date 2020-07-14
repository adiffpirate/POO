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
        System.out.print("Guerreires: ");
        warriorsQnt = Integer.parseInt(stdin.nextLine());
        for (int i=0; i<warriorsQnt; i++){
            // Cria guerreire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
            deck.add(new Warrior(allCharactersNameItr.next(), owner));
        }
        // Atualiza a quantidade de personagens disponiveis
        charsAvailableQnt -= warriorsQnt;
        // Se ainda houver personagens disponiveis para escolher
        if (charsAvailableQnt >= 1) {
            // Escolhe a quantidade de arqueires
            System.out.print("Arqueires: ");
            archersQnt = Integer.parseInt(stdin.nextLine());
            for (int i=0; i<archersQnt; i++){
                // Cria arqueire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                deck.add(new Archer(allCharactersNameItr.next(), owner));
            }
            charsAvailableQnt -= archersQnt;
        }
        // Se ainda houver personagens disponiveis para escolher
        if (charsAvailableQnt >= 1) {
            // Escolhe a quantidade de bruxes
            System.out.print("Bruxes: ");
            wizardsQnt = Integer.parseInt(stdin.nextLine());
            for (int i=0; i<wizardsQnt; i++){
                // Cria bruxe usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                deck.add(new Wizard(allCharactersNameItr.next(), owner));
            }
            charsAvailableQnt -= wizardsQnt;
        }
        // Se ainda houver personagens disponiveis para escolher
        if (charsAvailableQnt >= 1) {
            // Escolhe a quantidade de bruxes
            System.out.print("Sacerdotes: ");
            priestsQnt = Integer.parseInt(stdin.nextLine());
            for (int i=0; i<priestsQnt; i++){
                // Cria sacerdote usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                deck.add(new Priest(allCharactersNameItr.next(), owner));
            }
        }
    }

    // Construtor sem argumento que eh chamado na classe Enemy, se faz isso pois nao faz sentido chamar o
    // construtor dessa classe na Enemy, pois o sistema de criacao de deck eh completamente diferente
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
        System.out.print("Insira o índice do personagem que deseja colocar em combate: ");
        int charIndex = Integer.parseInt(stdin.nextLine());
        /* Atualiza o personagem em combate do jogador.
        Eh importante notar que os indices dos personagens
        que aparecem para o jogador quando o deck eh impresso comeca em "1",
        por isso no get abaixo subtrai-se 1 do indice escolhido */
        this.charInBattle = this.deck.get(charIndex - 1);
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
}
