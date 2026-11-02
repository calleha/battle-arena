public class Warrior extends Character {
    public Warrior(String characterType, int hp, int mp) {
	super(characterType, hp, mp);
    }

    @Override public int basicAttack(Character attacker, Character defender) {
	setDamage(10 * getDamageMultiplier());
	defender.setHp(getHp() - getDamage());
    }

    @Override public int strongAttack(Character attacker, Character defender) {
	setDamage(35);
	attacker.setHp(getHp() - 10);
    }

    @Override public double defenseBuff(Character defender) {
	defender.setDamageMultiplier(getDamageMultiplier() * 0.85);
    }
}
