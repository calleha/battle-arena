public class Mage extends GameCharacter {
    public Mage(String name, String characterType, int hp, int maxHp, int mp, int maxMp, int minDamage, int maxDamage) {
        super(name, characterType, hp, maxHp, mp, maxMp, minDamage, maxDamage);
    }

    private void magicAttack(GameCharacter user, GameCharacter target) {
        if (user.getMp() >= 15) {
            int damage = user.getMaxDamage() + 8;
            target.setHp(target.getHp() - damage);
            user.setMp(user.getMp() - 15);
            //added sound effects
            SoundManager.playMagicAttack();
            System.out.println(TextColor.GREEN + user.getName() + TextColor.YELLOW + " hits for " +
                               TextColor.PURPLE + damage + TextColor.YELLOW + " damage!" + TextColor.RESET);
        } else {
            System.out.println(TextColor.GREEN + user.getName() + TextColor.RED + " doesn't have enough MP!" + TextColor.RESET);
        }
    }

    @Override
    public void specialMove(GameCharacter user, GameCharacter target) {
        magicAttack(user, target);
    }

    @Override public int getHealCost()    { return 25; }
    @Override public int getSpecialCost() { return 15; }
}
