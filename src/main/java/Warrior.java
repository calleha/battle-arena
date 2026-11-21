public class Warrior extends GameCharacter {
    public Warrior(String name, String characterType, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	super(name, characterType, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    private void attackDebuff(GameCharacter user, GameCharacter target) {
	if (user.getMp() >= 20) {
	    target.setMaxDamage(target.getMaxDamage() - 3);
	    user.setMp(user.getMp() - 20);
	    System.out.println(target.getName() + "'s max damage decreased by 3!");
	} else System.out.println(user.getName() + " doesn't have enough MP!");
    }

    @Override
    public void specialMove(GameCharacter user, GameCharacter target) { attackDebuff(user, target); }

    @Override public int getHealCost()    { return 40; }
    @Override public int getSpecialCost() { return 20; }
}
