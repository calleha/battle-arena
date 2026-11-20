public class Titan extends Character {
    public Titan(String player, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	super(player, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    @Override public void attackBuff(Character user) {
	if (user.getMp() >= 20) {
	    user.setMaxDamageMultiplier(user.getMaxDamage() + 2);
	    user.setMp(getMp() - 20);
	    System.out.println(user + "'s max damage increased by 2!");
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
    public void specialMove(Character user, Character target) {attackBuff(user);}
}
