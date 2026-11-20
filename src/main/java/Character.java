import java.util.Random;

public abstract class Character implements SkillTypes {
    private String player;
    private String playerName;
    private String characterType;
    private int    minDamage;
    private int    maxDamage;
    private int    hp;
    private int    maxHp;
    private int    mp;
    private int    maxHp;
    
    public Character(String player, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	this.player     = player;
	this.hp         = hp;
	this.maxHp      = maxHp;
	this.mp         = mp;
	this.maxMp      = maxMp;
	this.minDamage  = minDamage;
	this maxDamage  = maxDamage;
    }

    public String getPlayer()                            {return player;}
    public void   setPlayer(String player)               {player = this.player;}
    public String getPlayerName()                        {return playerName;}
    public void   setPlayerName(String playerName)       {playerName = this.playerName;}
    public String getCharacterType()                     {return characterType;}
    public void   setCharacterType(String characterType) {characterType = this.characterType;}
    public int    getMinDamage()                         {return minDamage;}
    public void   setMinDamage(int damage)               {minDamage = this.minDamage;}
    public int    getMaxDamage()                         {return maxDamage;}
    public void   setMaxDamage(int damage)               {maxDamage = this.maxDamage;}
    public int    getHp()                                {return hp;}
    public void   setHp(int hp)                          {hp = this.hp;}
    public int    getMp()                                {return mp;}
    public void   setMp(int mp)                          {mp = this.mp;}
    public int    getMaxHp()                             {return maxHp;}
    public void   setMaxHp(int hp)                       {hp = this.maxHp;}
    public int    getMaxMp()                             {return maxMp;}
    public void   setMaxMp(int mp)                       {mp = this.maxMp;}

    Random random = new Random();
    @Override
    public void basicAttack(Character target) {
	target.setHp(target.getHp() - random(user.getMinDamage(), user.getMaxDamage));
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }
}
