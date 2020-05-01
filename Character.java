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
    //todos abstratos, ou seja, serão implementados apenas nas classes herdeiras
    public abstract int getMaxPower();
    public abstract int getMaxHp();
    public abstract int getPower();
    public abstract int getHp();   
    public abstract int getLevel();
    public abstract int getXp();
    public abstract int getAttack();
    public abstract int getDefense();
    public abstract int getSpeed();
    public abstract int getIntel();
    public abstract String getName();
        
    //setters
    //todos abstratos, ou seja, serão implementados apenas nas classes herdeiras
    public abstract void setMaxPower(int maxPower);
    public abstract void setMaxHp(int maxHp);
    public abstract void setPower(int power);
    public abstract void setHp(int hp);   
    public abstract void levelUp();
    public abstract void setXp(int xp);
    public abstract void setAttack(int atk);
    public abstract void setDefense(int def);
    public abstract void setSpeed(int speed);
    public abstract void setIntel(int intel);
    
    //os outros métodos serão implementados posteriormente
}
