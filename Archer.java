//essa classe pertence ao pacote battlegame
//package battlegame;

//classe Archer, herdeira de Character
public class Archer extends Character
{
    //métodos
    //construtor
    public Archer(String name, int atk, int def)
    {
        super(name, atk, def);
        this.hp = 20;
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
            System.out.println("(0) Mirar (custo: 5");
            System.out.println("(1) Horda de flechas (custo: 10");
        }
        else
        {
            System.out.println("(0) Mirar (custo: 5");
        }
    }
    
    //os outros métodos serão implementados posteriormente
}
