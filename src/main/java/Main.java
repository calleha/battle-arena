import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);

public class Main {
    public static void main(String[] args) {

	initialisePlayer();
	startGame();
	printResult();
	saveResult();
	rematchOrQuit();
	


	
	void initialisePlayer() {
	    System.out.print("Write the name of your character: ");
	    setPlayerName(scanner.nextLine());
	    selectPlayerCharacter();
	}

	void selectPlayerCharacter() {
	    System.out.print("Choose your character: WARRIOR | TITAN | MAGE");
	    setCharacterType(scanner.nextLine());
	    selectCharacter(getPlayerName());
	}

	void selectCharacter(String player) {
	    if (getCharacterType().equalsIgnoreCase("WARRIOR")) {Warrior player = new Warrior(player, 120, 60);}
	    if (getCharacterType().equalsIgnoreCase("MAGE"))    {Mage player = new Mage(player, 90, 90);}
	    if (getCharacterType().equalsIgnoreCase("TITAN"))   {Titan player = new Titan(player, 140, 35);}
	}

	void rematchOrQuit() {
	    while (true) {
		System.out.print("Begin new game? (Y/n) ");
		String newGame = scanner.nextLine();

		if (newGame.equalsIgnoreCase("n")) {return;}
		else {selectPlayerCharacter(); startGame();}
	    }
	}
    }
}
