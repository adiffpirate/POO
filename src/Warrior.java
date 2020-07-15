public class Warrior extends Character {
    public Warrior(String name, String owner) {
        super(name, "Guerreire", owner);
        this.maxHp = this.hp = 100;
        this.atk = 50;
        this.def = 20;
        this.agi = 10;
        this.con = 10;
    }
}