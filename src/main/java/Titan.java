public class Titan extends GameCharacter {
    public Titan(String name, String characterType, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	super(name, characterType, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    private void attackBuff(GameCharacter user) {
	if (user.getMp() >= 20) {
	    user.setMaxDamage(user.getMaxDamage() + 2);
	    user.setMp(user.getMp() - 20);
	    System.out.println(user.getName() + "'s max damage increased by 2!");
	}
	else {System.out.println(user.getName() + " doesn't have enough MP!");}
    }

    @Override public void heal(GameCharacter user) { healWithCost(user, 40, 30); }

    @Override
    public void specialMove(GameCharacter user, GameCharacter target) { attackBuff(user); }
}
