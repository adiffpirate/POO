import java.util.Scanner;

public abstract class Character implements Cloneable {
    // Atributos sao protected pois precisam ser acessados pelas classes filhas
    protected int maxHp, hp, level, xp, atk, def, agi, con;
    // Instância que não será modificada
    private final String name, charClass;
    // Util
    private final Util util = new Util();

    // Construtor (recebe o nome do personagem e o nome da classe que ira aparecer na "interface" do jogo)
    public Character(String name, String charClass) {
        this.name = name;
        this.charClass = charClass;
        // Valores iniciais que sao fixos para todos os personagens
        this.xp = 100;
        this.level = 1;
    }

    // Getters
    public int getMaxHp() { return this.maxHp; }
    public int getHp() { return this.hp; }
    public int getLv() { return this.level; }
    public int getXp() { return this.xp; }
    public int getAtk() { return this.atk; }
    public int getDef() { return this.def; }
    public int getAgi() { return this.agi; }
    public int getCon() { return this.con; }
    public String getName() { return this.name; }
    public String getCharClass() { return this.charClass; }

    // Setters
    public void setMaxHp(int maxHp) { this.maxHp = maxHp; }
    public void setHp(int hp) { this.hp = hp; }
    public void setLevel(int level) { this.level = level; }
    public void setXp(int xp) { this.xp = xp; }
    public void setAtk(int atk) { this.atk = atk; }
    public void setDef(int def) { this.def = def; }
    public void setAgi(int agi) { this.agi = agi; }
    public void setCon(int con) { this.con = con; }

    public boolean isAlive(){
        return this.hp > 0;
    }
    public boolean isDead(){
        return this.hp <= 0;
    }
    public void action(Character target){
        if (this instanceof Priest){
            // Por enquanto o sacerdote cura a si mesmo, isso sera mudado futuramente
            // para permitir o usuario escolher
            ((Priest) this).heal(this);
        }
        else{
            this.attack(target);
        }
    }
    public void attack(Character target) {
        // Calcula o dano
        int damage = this.atk - target.def;
        // Aplica dano no alvo
        target.takeDamage(damage);
    }
    public void heal(int amount){
        // Se nao ultrapassar o valor maximo
        if (this.hp+amount <= this.maxHp){
            this.hp += amount;
        }
        else{
            this.hp = this.maxHp;
        }
    }
    public void takeDamage(int damage){
        util.sleep(2); // Pequena pausa para leitura do usuario
        this.hp -= damage;
        if (this.isAlive()){
            System.out.println(this.name+" sofreu "+damage+" de dano, ficando com "+this.hp+" de HP");
        }else{
            System.out.println(this.name+" morreu");
        }
    }
    public void printCharInformation(){
        System.out.println(this.name+" ("+this.charClass+") Lv: "+this.level+"    XP: "+this.xp);
        System.out.println("HP: "+this.hp+"/"+this.maxHp+"    Atk: " +this.atk+"    Def: "+this.def+"    Agi: "+this.agi+"    Con: "+this.con);
    }
    public void levelUp(){
        this.level++;
        this.maxHp *= 1.5;
        this.hp = this.maxHp;
        this.atk *= 1.5;
        this.def *= 1.5;
        this.con *= 2;
        this.agi *= 1.5;
        util.sleep(2); // Pequena pausa para leitura do usuario
        System.out.println();
        System.out.println(this.name+" subiu para o nível "+this.level+"!");
        System.out.println();
    }
    public void stealXP(Character target){
        this.xp += target.xp;
        /*  Sobe o personagem de level, de acordo a formula
            100 * (2 ^ (level atual do personagem - 1)), ou seja:
            level 2 = 200 de xp necessarios;
            level 3 = 400 de xp necessarios;
            level 4 = 800 de xp necessarios;... */
        if (this.xp >= Math.pow(2,this.level-1)*100) this.levelUp();
    }
}