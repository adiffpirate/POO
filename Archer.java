//essa classe pertence ao pacote battlegame
package battlegame;

//classe Archer, herdeira de Character
public class Archer extends Character
{
    //métodos
    //construtor
    public Archer(String name)
    {
        super(name);
        //os valores serão alterados posteriormente, é só para não deixar em branco
        this.maxPower = 20; 
        this.maxHp = 45;
        this.power = 20;
        this.hp = 45;
        this.level = 1;
        this.xp = 0;
        this.atk = 3;
        this.def = 4;
        this.speed = 2;
        this.intel = 1;
    }
    
    public void levelUp()
    {
        this.level +=1;
        //TO DO: esse método irá chamar outros setters indicando quais valores devem ser atualizados
    }
    //os outros métodos serão implementados posteriormente
}
