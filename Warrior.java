//essa classe pertence ao pacote battlegame
package battlegame;

//classe Warrior, herdeira de Character
public class Warrior extends Character
{
    //instância privada
    private int sword;
        
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
        this.sword = 1;
    }
    
    //getters
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
    
    public int getSword()
    {
        return this.sword;
    }
        
    //setters
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
    
    public void levelUp()
    {
        this.level +=1;
        //TO DO: esse método irá chamar outros setters indicando quais valores devem ser atualizados
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
    
    public void setSword(int sword)
    {
        this.sword += sword;
    }
    
    //os outros métodos serão implementados posteriormente
}
