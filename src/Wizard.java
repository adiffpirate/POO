public class Wizard extends Character {
    public Wizard(String name, String owner) {
        super(name, "Bruxe", owner);
        this.maxHp = 75;
        this.hp = 75;
        this.atk = 125;
        this.def = 10;
        this.agi = 25;
        this.con = 5;
    }
}