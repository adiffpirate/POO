//essa classe pertence ao pacote battlegame
package battlegame;

//classe Warrior, herdeira de Character
public class Warrior extends Character
{
    //métodos
    //construtor
    public Warrior(String name)
    {
        super(name);
        //os valores serão alterados posteriormente, é só para não deixar em branco
        this.maxPower = 20; 
        this.maxHp = 40;
        this.power = 20;
        this.hp = 40;
        this.level = 1;
        this.xp = 0;
        this.atk = 5;
        this.def = 3;
        this.speed = 1;
        this.intel = 1;
    }
        
    public void levelUp()
    {
        this.level +=1;
        //TO DO: esse método irá chamar outros setters indicando quais valores devem ser atualizados
    }
    //os outros métodos serão implementados posteriormente
}
