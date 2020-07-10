public abstract class Character implements Cloneable {
    // Instâncias são protected pois precisam ser acessadas pelas classes herdeiras
    protected int maxHp, hp, level, xp, atk, def, agi, con;
    // Instância que não será modificada
    final String name, charClass;

    // Construtor
    public Character(String name, String charClass) {
        this.name = name;
        this.charClass = charClass;
        // Valores iniciais que sao fixos para todos os personagens
        this.xp = 0;
        this.level = 1;
    }

    // Construtor de clone
    public Character clone() throws CloneNotSupportedException {
        try
        {
            return (Character)super.clone();
        }
        catch(CloneNotSupportedException error)
        {
            System.out.println("Ocorreu um erro ao tentar iniciar o jogo.");
            return null;
        }
    }

    public int getMaxHp()
    {
        return this.maxHp;
    }
    public int getHp()
    {
        return this.hp;
    }
    public int getLv()
    {
        return this.level;
    }
    public int getXp()
    {
        return this.xp;
    }
    public int getAtk() { return this.atk; }
    public int getDef() { return this.def; }
    public int getAgi() { return this.agi; }
    public int getCon() { return this.con; }
    public String getName()
    {
        return this.name;
    }

    public void setMaxHp(int maxHp)
    {
        this.maxHp += maxHp;
    }
    public void setHp(int hp) {
        if(this.hp + hp > this.maxHp) this.hp = this.maxHp;
        else if(this.hp + hp < 0) this.hp = 0;
        else this.hp += hp;
    }
    public void setXp(int xp) {
        this.xp += xp;
        //TO DO: esse método irá chamar levelUp dependendo do valor de xp
    }

    public boolean isAlive(){
        return this.hp > 0;
    }
    public void levelUp(){
        // To do
    }
    public void attack(Character target) {
        // To do
    }
    public void printCharInformation(){
        System.out.println(this.name + " (" + this.charClass + ") Lv: " + this.level + "    XP: " + this.xp);
        System.out.println("HP: " + this.hp + "    Atk: "  + this.atk + "    Def: " + this.def + "    Agi: " + this.agi + "    Con: " + this.con);
    }
}
