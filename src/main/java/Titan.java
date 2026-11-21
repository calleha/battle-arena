public class Titan extends GameCharacter {
    public Titan(String name, String characterType, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	super(name, characterType, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    private void attackBuff(GameCharacter user) {
	if (user.getMp() >= 20) {
	    user.setMaxDamage(user.getMaxDamage() + 4);
	    user.setMp(user.getMp() - 20);
	    System.out.println(user.getName() + "'s max damage increased by 4!");
	} else System.out.println(user.getName() + " doesn't have enough MP!");
    }

    @Override
    public void specialMove(GameCharacter user, GameCharacter target) { attackBuff(user); }

    @Override public int getHealCost()    { return 40; }
    @Override public int getSpecialCost() { return 20; }
}
