public class Wizard extends Character {
    public Wizard(String name, String owner) {
        super(name, "Bruxe", owner);
        this.maxHp = this.hp = 50;
        this.atk = 100;
        this.def = 5;
        this.agi = 5;
        this.con = 5;
    }
}