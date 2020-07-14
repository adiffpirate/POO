import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Enemy extends Player{
    private final Random randomNumberGen = new Random();

    // Construtor
    public Enemy(int charsAvailableQnt, Iterator<String> allCharactersNameItr) {
        // Variavel utilizada nos construtores dos personagens para identificar de quem eh o personagem criado
        String owner = "Inimigo";
        // #### Cria o deck do inimigo ####
        // Inicializa a variavel
        deck = new ArrayList<>();
        // Escolhe quantidade aleatoria de guerreires
        warriorsQnt = randomNumberGen.nextInt(charsAvailableQnt + 1);
        for (int i = 0; i < warriorsQnt; i++) {
            // Cria guerreire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
            deck.add(new Warrior(allCharactersNameItr.next(), owner));
        }
        // Atualiza a quantidade de personagens disponiveis
        charsAvailableQnt -= warriorsQnt;
        // Se ainda houver personagens disponiveis para escolher
        if (charsAvailableQnt >= 1) {
            // Escolhe quantidade aleatoria de arqueires
            archersQnt = randomNumberGen.nextInt(charsAvailableQnt + 1);
            for (int i = 0; i < archersQnt; i++) {
                // Cria arqueire usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                deck.add(new Archer(allCharactersNameItr.next(), owner));
            }
            charsAvailableQnt -= archersQnt;
        }
        // Se ainda houver personagens disponiveis para escolher
        if (charsAvailableQnt >= 1) {
            // Escolhe quantidade aleatoria de arqueires
            wizardsQnt = randomNumberGen.nextInt(charsAvailableQnt + 1);
            for (int i = 0; i < wizardsQnt; i++) {
                // Cria bruxe usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
                deck.add(new Wizard(allCharactersNameItr.next(), owner));
            }
            charsAvailableQnt -= wizardsQnt;
        }
        /*  Por ser o ultimo a ser criado, a quantidade de sacerdotes eh igual a quantidade de personagens
            disponiveis restantes, pois tirando a aleatoriedade aqui garantimos que o jogador
            e o inimigo tenham a mesma quantidade de personagens no inicio da batalha
            ( nao precisa do if aqui, pois se "priestsQnt == 0" ele nao entra no for ) */
        priestsQnt = charsAvailableQnt;
        for (int i = 0; i < priestsQnt; i++) {
            // Cria sacerdote usando o proximo nome disponivel na lista de nomes de personagens atraves do iterador
            deck.add(new Priest(allCharactersNameItr.next(), owner));
        }
    }

    public void printInfo(){
        System.out.println("***** Personagens do inimigo *****");
        System.out.println();
        if (warriorsQnt > 0) System.out.println("           "+this.warriorsQnt+" guerreires");
        if (archersQnt > 0) System.out.println("           "+this.archersQnt+" arqueires");
        if (wizardsQnt > 0) System.out.println("           "+this.wizardsQnt+" bruxes");
        if (priestsQnt > 0) System.out.println("           "+this.priestsQnt+" sacerdotes");
        System.out.println();
        System.out.println("**********************************");
        System.out.println();
    }
    @Override
    public void chooseCharToPutInBattle(){
        // Escolhe um personagem aleatorio no deck
        this.charInBattle = this.deck.get(randomNumberGen.nextInt(deck.size()));
        this.charInBattle.putInBattle();
    }
}