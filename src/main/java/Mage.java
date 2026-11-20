public class Mage extends GameCharacter {
    public Mage(String name, String characterType, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
	super(name, characterType, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    private void magicAttack(GameCharacter user, GameCharacter target) {
	if (user.getMp() >= 15) {
	    int damage = user.getMaxDamage() + 4;
	    target.setHp(target.getHp() - damage);
	    user.setMp(user.getMp() - 15);
	    System.out.println(user.getName() + " hits for " + damage + " damage!");
	}
	else {System.out.println(user.getName() + " doesn't have enough MP!");}
    }

    @Override public void heal(GameCharacter user) { healWithCost(user, 25, 30); }

    @Override
    public void specialMove(GameCharacter user, GameCharacter target) { magicAttack(user, target); }
}
