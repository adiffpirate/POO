import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Priest extends Character {
    protected int faith;
    public Priest(String name, String owner) {
        super(name, "Sacerdote", owner);
        this.maxHp = this.hp = 100;
        this.atk = 0;
        this.faith = 100;
        this.def = 0;
        this.agi = 20;
        this.con = 5;
    }

    public void heal(ArrayList<Character> deck) {
        // Variavel auxiliar que guarda o personagem que sera curado, inicia com o this pois
        // se nao houver personagens disponiveis para curar, cura a si mesmo
        Character target = this;
        // Lista para guardar os personagens que podem ser curados (que sofreram dano)
        ArrayList<Character> woundedChars = new ArrayList<>();

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
                    woundedChars.add(character);
                }
            }

            // Se houver personagens disponiveis para curar
            if( ! woundedChars.isEmpty()){
                target = readTarget(woundedChars, deck);
            }
        }
        // Se for do inimigo
        else{

            for (Character character : deck){
                // Se o personagem nao estiver de vida cheia
                if (character.getHp() < character.getMaxHp()) {
                    // Adiciona o personagem na lista
                    woundedChars.add(character);
                }
            }

            // Se houver personagens que podem ser curados
            if( ! woundedChars.isEmpty()){
                Random randomNumberGen = new Random();
                // Escolhe um personagem aleatorio
                target = woundedChars.get(randomNumberGen.nextInt(woundedChars.size()));
            }
        }

        target.heal(this.faith); // Usa o metodo heal declarado na classe Character

        // Se o alvo for o proprio personagem
        if (target == this){
            System.out.println(this.getName()+" curou a si mesmo");
        }
        else{
            System.out.println(this.getName()+" curou "+target.getName());
        }
        util.sleep(2); // Pequena pausa para leitura do usuario
    }
    // Retorna o personagem escolhido da lista de personagens machucados
    private Character readTarget(ArrayList<Character> woundedChars, ArrayList<Character> deck){
        Scanner stdin = new Scanner(System.in);

        System.out.println();
        System.out.print("Insira o índice do personagem que deseja curar: ");
        // Aqui usa-se while para tratar o input do usuario,
        // quebrando o loop somente quando um indice permitido eh inserido
        while (true){
            try{
                /*  Eh importante notar que os indices dos personagens
                    que aparecem para o jogador quando o deck eh impresso comeca em "1",
                    por isso subtrai-se 1 do indice escolhido */
                int charIndex = Integer.parseInt(stdin.nextLine())-1;
                // Pega o personagem com aquele indice no deck
                Character target = deck.get(charIndex);
                // Retorna-o se estiver na lista de personagens machucados
                if (woundedChars.contains(target)){
                    System.out.println();
                    return target;
                }
                else {
                    throw new Exception();
                }
            }
            catch (Exception exception){
                System.out.println();
                System.out.println("(ERRO) Não foi encontrado nenhum personagem possível de ser curado com esse índice.");
                System.out.print("Por favor, insira um índice válido ( ");
                // Imprime os indice permitidos
                for (Character character : woundedChars){
                    System.out.print("["+(deck.indexOf(character)+1)+"] ");
                }
                System.out.print("): ");
            }
        }
    }
}