public class Archer extends Character {
    public Archer(String name, String owner) {
        super(name, "Arqueire", owner);
        this.maxHp = this.hp = 75;
        this.atk = 70;
        this.def = 10;
        this.agi = 20;
        this.con = 5;
    }
}