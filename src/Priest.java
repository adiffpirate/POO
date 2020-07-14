import java.util.ArrayList;
import java.util.Random;
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
        Character target; // Variavel auxiliar que guarda o personagem que sera curado

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
            target = deck.get(index);
        }
        // Se for do inimigo
        else{
            ArrayList<Character> woundedChars = new ArrayList<>(); // Lista para guardar os personagens que podem ser curados (que sofreram dano)

            for (Character character : deck){
                // Se o personagem nao estiver de vida cheia
                if (character.getHp() < character.getMaxHp()) {
                    // Adiciona o personagem na lista
                    woundedChars.add(character);
                }
            }

            // Se nao houver personagens que podem ser curados
            if (woundedChars.isEmpty()){
                // Cura a si mesmo
                target = this;
            }
            else{
                Random randomNumberGen = new Random();
                // Escolhe um personagem aleatorio
                target = woundedChars.get(randomNumberGen.nextInt(woundedChars.size()));
            }
        }

        target.heal(this.faith); // Usa o metodo heal declarado na classe Character

        // Se o alvo for o proprio personagem
        if (target == this){
            System.out.println(this.getName()+" curou a si mesmo.");
        }
        else{
            System.out.println(this.getName()+" curou "+target.getName());
        }
        System.out.println();
    }
}