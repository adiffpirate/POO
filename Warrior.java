//essa classe pertence ao pacote battlegame
//package battlegame;

//classe Warrior, herdeira de Character
public class Warrior extends Character
{
    //métodos
    //construtor
    public Warrior(String name, int atk, int def)
    {
        super(name, atk, def);
        this.maxHp = 15;
        this.hp = 15;
    }
        
    public void levelUp()
    {
        this.level +=1;
        //TO DO: esse método irá chamar outros setters indicando quais valores devem ser atualizados
    }
    
    public void showActions(int power)
    {
        if(power > 9)
        {
            System.out.println("(0) Golpear (custo: 5");
            System.out.println("(1) Massacre (custo: 10");
        }
        else
        {
            System.out.println("(0) Golpear (custo: 5");
        }
    }
    //os outros métodos serão implementados posteriormente
}
