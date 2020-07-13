public class Warrior extends Character {
    public Warrior(String name, String owner) {
        super(name, "Guerreire", owner);
        this.maxHp = 100;
        this.hp = 100;
        this.atk = 75;
        this.def = 25;
        this.agi = 50;
        this.con = 10;
    }
}