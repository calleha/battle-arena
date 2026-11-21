public interface SkillTypes {
    void basicAttack(GameCharacter user, GameCharacter target);
    void heal(GameCharacter user);
    void specialMove(GameCharacter user, GameCharacter target);
}
