//essa classe pertence ao pacote battlegame
package battlegame;

//classe abstrata Character
public abstract class Character
{
    //instâncias
    int maxPower, maxHp, power, hp, level, xp, atk, def, speed, intel;
        //instância que não será modificada
        final String name;
        
    //métodos
    //construtor
    //apenas setará o nome, pois o construtor de cada classe de personagem fará o resto
    Character(String name)
    {
        this.name = name;
    }
    
    //getters
    //todos abstratos, ou seja, serão implementados apenas nas classes herdeiras
    abstract int getMaxPower();
    abstract int getMaxHp();
    abstract int getPower();
    abstract int getHp();   
    abstract int getLevel();
    abstract int getXp();
    abstract int getAttack();
    abstract int getDefense();
    abstract int getSpeed();
    abstract int getIntel();
    abstract String getName();
        
    //setters
    //todos abstratos, ou seja, serão implementados apenas nas classes herdeiras
    abstract int setMaxPower();
    abstract int setMaxHp();
    abstract int setPower();
    abstract int setHp();   
    abstract int setLevel();
    abstract int setXp();
    abstract int setAttack();
    abstract int setDefense();
    abstract int setSpeed();
    abstract int setIntel();
    
    //os outros métodos serão implementados posteriormente
}
