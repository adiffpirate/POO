public class Priest extends Character {
    private int faith;
    public Priest(String name)
    {
        super(name, "Sacerdote");
        this.hp = 75;
        this.atk = 0;
        this.faith = 50;
        this.def = 25;
        this.agi = 75;
        this.con = 5;
    }
}