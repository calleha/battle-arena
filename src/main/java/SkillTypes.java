public interface SkillTypes {
    void basicAttack(GameCharacter user, GameCharacter target);
    //void magicAttack(Character user, Character target); // called by specialMove()
    void heal(GameCharacter user);
    //void attackBuff(Character user); // called by specialMove()
    //void attackDebuff(Character user, Character target); // called by specialMove()
    void specialMove(GameCharacter user, GameCharacter target);
}
