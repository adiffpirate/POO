import java.util.ArrayList;
import java.util.Scanner;

public class Priest extends Character {
    private int faith;
    public Priest(String name, String owner) {
        super(name, "Sacerdote", owner);
        this.maxHp = 75;
        this.hp = 75;
        this.atk = 0;
        this.faith = 50;
        this.def = 25;
        this.agi = 75;
        this.con = 5;
    }

    public void heal(ArrayList<Character> deck) {
        Scanner stdin = new Scanner(System.in);

        // Se o personagem for do jogador
        if (this.getOwner().equals("Jogador")) {
            System.out.println();
            // Imprime os personagens que podem ser curados
            for (Character character : deck) {
                // Se o personagem nao estiver de vida cheia
                if (character.getHp() < character.getMaxHp()) {
                    // Imprime o indice, nome e HP/MaxHP do personagem
                    int index = deck.indexOf(character)+1;
                    System.out.println("["+(index)+"] "+character.getName()+" ("+character.getCharClass()+") " +
                            "HP: "+character.getHp()+"/"+character.getMaxHp());
                }
            }
            System.out.println();
            System.out.print("Insira o índice do personagem que deseja curar: ");
            int index = Integer.parseInt(stdin.nextLine())-1;
            deck.get(index).heal(this.faith); // Usa o metodo heal declarado na classe Character
            System.out.println();
            System.out.println(this.getName()+" curou "+deck.get(index).getName());
        }
    }
}