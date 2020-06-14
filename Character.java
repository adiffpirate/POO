//essa classe pertence ao pacote battlegame
package battlegame;

//classe abstrata Character, implementa Cloneable
public abstract class Character implements Cloneable
{
    //instâncias são protected pois precisam ser acessadas pelas classes herdeiras
    protected int maxPower, maxHp, power, hp, level, xp, atk, def, speed, intel;
        //instância que não será modificada
        final String name;
        
    //métodos
    //construtor
    //apenas setará o nome, pois o construtor de cada classe de personagem fará o resto
    public Character(String name)
    {
        this.name = name;
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
    
    public int getSpeed()
    {
        return this.speed;
    }
    
    public int getIntel()
    {
        return this.intel;
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
        if(this.power + power > this.maxPower) this.power = this.maxPower;
        else this.power += power;
    }
    
    public void setHp(int hp)
    {
        if(this.hp + hp > this.maxHp) this.hp = this.maxHp;
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
    
    public void setSpeed(int speed)
    {
        this.speed += speed;
    }
    
    public void setIntel(int intel)
    {
        this.intel += intel;
    }
    //método abstract
    public abstract void levelUp();
    //os outros métodos serão implementados posteriormente
}
