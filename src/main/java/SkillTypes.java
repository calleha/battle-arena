public interface SkillTypes {
    void basicAttack(Character target);
    //void magicAttack(Character user, Character target); // called by specialMove()
    void heal(Character user);
    //void attackBuff(Character user); // called by specialMove()
    //void attackDebuff(Character user, Character target); // called by specialMove()
    void specialMove(Character user, Character target);
}
