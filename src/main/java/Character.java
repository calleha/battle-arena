import java.util.Random;

public abstract class GameCharacter implements SkillTypes {
    private String player;
    private String playerName;
    private String characterType;
    private int    minDamage;
    private int    maxDamage;
    private int    hp;
    private int    maxHp;
    private int    mp;
    private int    maxMp;
    
    public Character(String player, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	this.player     = player;
	this.hp         = hp;
	this.maxHp      = maxHp;
	this.mp         = mp;
	this.maxMp      = maxMp;
	this.minDamage  = minDamage;
	this.maxDamage  = maxDamage;
    }

    public String getPlayer()                            {return player;}
    public void   setPlayer(String player)               {this.player = player;}
    public String getPlayerName()                        {return playerName;}
    public void   setPlayerName(String playerName)       {this.playerName = playerName;}
    public String getCharacterType()                     {return characterType;}
    public void   setCharacterType(String characterType) {this.characterType = characterType;}
    public int    getMinDamage()                         {return minDamage;}
    public void   setMinDamage(int damage)               {this.minDamage = minDamage;}
    public int    getMaxDamage()                         {return maxDamage;}
    public void   setMaxDamage(int damage)               {this.maxDamage = maxDamage;}
    public int    getHp()                                {return hp;}
    public void   setHp(int hp)                          {this.hp = Math.max(0, Math.min(hp, maxHp));}
    public int    getMp()                                {return mp;}
    public void   setMp(int mp)                          {this.mp = Math.max(0, Math.min(mp, maxMp));}
    public int    getMaxHp()                             {return maxHp;}
    public void   setMaxHp(int maxHp)                    {this.maxHp = maxHp;}
    public int    getMaxMp()                             {return maxMp;}
    public void   setMaxMp(int maxMp)                    {this.maxMp = maxMp;}

    Random random = new Random();
    @Override
    public void basicAttack(Character user, Character target) {
	target.setHp(target.getHp() - random.nextInt(user.getMinDamage(), user.getMaxDamage()));
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
