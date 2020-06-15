//essa classe pertence ao pacote battlegame
//package battlegame;
import java.util.Random;

//classe abstrata Character, implementa Cloneable
public abstract class Character implements Cloneable
{
    //instâncias são protected pois precisam ser acessadas pelas classes herdeiras
    protected int maxPower, maxHp, power, hp, level, xp, atk, def;
    //instância que não será modificada
    final String name;
        
    //métodos
    //construtor
    public Character(String name, int atk, int def)
    {
        //todos os personagens vão começar com nível 1, 0 de XP e 20 de poder
        this.xp = 0;
        this.level = 1;
        this.power = 20;
        this.maxPower = 20;
        //cada personagem começará com nomes e valores diferentes para esses atributos
        this.name = name;
        this.atk = atk;
        this.def = def;
        //apenas o valor inicial de saúde será de acordo com a classe
    }
    
    //construtor de clone
    public Character clone() throws CloneNotSupportedException
    {
        try 
        {
            return (Character)super.clone();
        }
        catch(CloneNotSupportedException error) 
        {
            System.out.println("Ocorreu um erro ao tentar iniciar o jogo.");
            return null;
        }
    }
    
    //getters
    //métodos default
    public int getMaxPower()
    {
        return this.maxPower;
    }
    
    public int getMaxHp()
    {
        return this.maxHp;
    }
    
    public int getPower()
    {
        return this.power;
    }
    
    public int getHp()
    {
        return this.hp;
    }
    
    public int getLevel()
    {
        return this.level;
    }
    
    public int getXp()
    {
        return this.xp;
    }
    
    public int getAttack()
    {
        return this.atk;
    }
    
    public int getDefense()
    {
        return this.def;
    }

    public String getName()
    {
        return this.name;
    }
    
    //setters
    //métodos default
    public void setMaxPower(int maxPower)
    {
       this.maxPower += maxPower;
    }
    
    public void setMaxHp(int maxHp)
    {
        this.maxHp += maxHp;
    }
    
    public void setPower(int power)
    {
        if(this.power - power < 0) this.power = 0;
        else this.power -= power;
    }
    
    public void setHp(int hp)
    {
        if(this.hp + hp > this.maxHp) this.hp = this.maxHp;
        else if(this.hp + hp < 0) this.hp = 0;
        else this.hp += hp;
    }
    
    public void setXp(int xp)
    {
        this.xp += xp;
        //TO DO: esse método irá chamar levelUp dependendo do valor de xp
    }
    
    public void setAttack(int atk)
    {
        this.atk += atk;
    }
    
    public void setDefense(int def)
    {
        this.def += def;
    }

    //método abstract
    public abstract void levelUp();
    
    public abstract void showActions(int power);
    
    public void individualAttack(Character target)
    {
        Random rand = new Random();
        double random = rand.nextDouble();
        int damage = (int)(this.getAttack() * random);
        target.setHp(damage);
        this.setXp(damage);
    }
    
    public void groupAttack()
    {
        Random rand = new Random();
        int random = rand.nextInt(70);
        int damage = this.getAttack() * random/100;
    }
    //os outros métodos serão implementados posteriormente
}
