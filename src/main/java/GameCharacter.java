import java.util.Random;

public abstract class GameCharacter implements SkillTypes {
    private String name;
    private String characterType;
    private int    minDamage;
    private int    maxDamage;
    private int    hp;
    private int    maxHp;
    private int    mp;
    private int    maxMp;
    
    public GameCharacter(String name, String characterType, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	this.name          = name;
	this.characterType = characterType;
	this.hp            = hp;
	this.maxHp         = maxHp;
	this.mp            = mp;
	this.maxMp         = maxMp;
	this.minDamage     = minDamage;
	this.maxDamage     = maxDamage;
    }

    public String getName()                              { return playerName; }
    public void   setName(String playerName)             { this.playerName = playerName; }
    public String getCharacterType()                     { return characterType; }
    public void   setCharacterType(String characterType) { this.characterType = characterType; }
    public int    getMinDamage()                         { return minDamage; }
    public void   setMinDamage(int minDamage)            { this.minDamage = minDamage; }
    public int    getMaxDamage()                         { return maxDamage; }
    public void   setMaxDamage(int maxDamage)            { this.maxDamage = Math.max(minDamage, maxDamage); }
    public int    getHp()                                { return hp; }
    public void   setHp(int hp)                          { this.hp = Math.max(0, Math.min(hp, maxHp)); }
    public int    getMp()                                { return mp; }
    public void   setMp(int mp)                          { this.mp = Math.max(0, Math.min(mp, maxMp)); }
    public int    getMaxHp()                             { return maxHp; }
    public void   setMaxHp(int maxHp)                    { this.maxHp = maxHp; }
    public int    getMaxMp()                             { return maxMp; }
    public void   setMaxMp(int maxMp)                    { this.maxMp = maxMp; }

    Random random = new Random();
    @Override
    public void basicAttack(GameCharacter user, GameCharacter target) {
	int damage = random.nextInt(user.getMinDamage(), user.getMaxDamage() + 1);
	target.setHp(target.getHp() - damage);
	System.out.println(user.getPlayerName() + " hits for " + damage + " damage!");
    }

    protected void healWithCost(Character user, int cost, int amount) {
    if (user.getMp() >= cost) {
        user.setHp(user.getHp() + amount);
        user.setMp(user.getMp() - cost);
    } else System.out.println("Not enough MP!");
}

    public boolean isAlive() {
        return hp > 0;
    }
}
