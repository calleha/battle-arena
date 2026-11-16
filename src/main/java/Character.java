public abstract class Character implements SkillTypes {
    private String playerName;
    private String characterType;
    private int    damage;
    private int    hp;
    private int    mp;
    
    public Character(String player, int hp, int mp) {}

    public String getPlayerName()                        {return playerName;}
    public void   setPlayerName(String playerName)       {playerName = this.playerName;}
    public String getCharacterType()                     {return characterType;}
    public void   setCharacterType(String characterType) {characterType = this.characterType;}
    public int    getDamage()                            {return damage;}
    public void   setDamage(int damage)                  {damage = this.damage;}
    public int    getHp()                                {return hp;}
    public void   setHp(int hp)                          {hp = this.hp;}
    public int    getMp()                                {return mp;}
    public void   setMp(int mp)                          {mp = this.mp;}
}
