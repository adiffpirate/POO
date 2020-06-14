//essa classe pertence ao pacote battlegame
package battlegame;

//classe Warrior, herdeira de Character
public class Wizard extends Character
{
    //métodos
    //construtor
    public Wizard(String name)
    {
        super(name);
        //os valores serão alterados posteriormente, é só para não deixar em branco
        this.maxPower = 20; 
        this.maxHp = 35;
        this.power = 20;
        this.hp = 35;
        this.level = 1;
        this.xp = 0;
        this.atk = 1;
        this.def = 2;
        this.speed = 4;
        this.intel = 5;
    }
    
    public void levelUp()
    {
        this.level +=1;
        //TO DO: esse método irá chamar outros setters indicando quais valores devem ser atualizados
    }
    //os outros métodos serão implementados posteriormente
}
