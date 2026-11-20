public class Warrior extends Character {
    public Warrior(String player, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	super(player, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    @Override public void attackDebuff(Character user, Character target) {
	if (user.getMp() >= 20) {
	    target.setMaxDamage(target.getMaxDamage() - 3);
	    user.setMp(user.getMp() - 20);
	    System.out.println(target + "'s max damage decreased by 3!");
	}
	else {System.out.println("Nothing happened.");}
    }

    @Override public void heal(Character user) {
	if (user.getMp() >= 40) {
	    user.setHp(getHp() + 30);
	    user.setMp(getMp() - 40);
	}
    }

    @Override
    public void specialMove(Character user, Character target) {attackBuff(user, target);}
}
