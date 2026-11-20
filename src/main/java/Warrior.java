public class Warrior extends GameCharacter {
    public Warrior(String player, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	super(player, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    private void attackDebuff(GameCharacter user, GameCharacter target) {
	if (user.getMp() >= 20) {
	    target.setMaxDamage(target.getMaxDamage() - 3);
	    user.setMp(user.getMp() - 20);
	    System.out.println(target + "'s max damage decreased by 3!");
	}
	else {System.out.println("Not enough MP!");}
    }

    @Override public void heal(GameCharacter user) { healWithCost(user, 40, 30); }

    @Override
    public void specialMove(GameCharacter user, GameCharacter target) { attackDebuff(user, target); }
}
