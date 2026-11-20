public class Mage extends Character {
    public Mage(String player, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	super(player, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    @Override public void magicAttack(Character user, Character target) {
	if (user.getMp() >= 15) {
	    target.setHp(getHp() - (user.getMaxDamage() + 4));
	    user.setMp(getMp() - 15);
	}
	else {System.out.println("Nothing happened.");}
    }

    @Override public void heal(Character user) {
	if (user.getMp() >= 25) {
	    user.setHp(getHp() + 30);
	    user.setMp(getMp() - 25);
	}
    }

    @Override
    public void specialMove(Character user, Character target) {magicAttack(user, target);}
}
