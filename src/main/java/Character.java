public abstract class Character implements SkillTypes {
    private int damage;
    private String characterType;
    private int hp;
    private int mp;
    
    public Character(String characterType, int hp, int mp) {}

    public int getDamage() {return damage;}
    public int setDamage(int damage) {
	damage = this.damage;
    }
}
