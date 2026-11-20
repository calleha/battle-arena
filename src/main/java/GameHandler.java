import java.util.Random;

public class GameHandler {
    
    Random random = new Random();
    
    void startGame() {
	int computerCharacterChoice = random.nextInt(2);
	if (computerCharacterChoice = 0) {setCharacterType("WARRIOR");}
	if (computerCharacterChoice = 1) {setCharacterType("MAGE");}
	if (computerCharacterChoice = 2) {setCharacterType("TITAN");}
	selectCharacter("computer");
	start();
    }
}
