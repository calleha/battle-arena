public class Mage extends Character {
    public Warrior(String characterType, int hp, int mp) {
	super(characterType, hp, mp);
    }

    @Override public int basicAttack(Character attacker, Character defender) {
	setDamage(5 * getDamageMultiplier());
	defender.setHp(getHp() - getDamage());
    }

    @Override public int strongAttack(Character attacker, Character defender) {
	setDamage(35);
	attacker.setHp(getMp() - 10);
    }

    @Override public double attackBuff(Character attacker) {
	attacker.setDamageMultiplier(attacker.getDamageMultiplier() * 1.15);
    }

    @Override public int heal(Character attacker) {
	attacker.setHp(getHp() + 25);
    }
}
