import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {

	initialisePlayer();

	do {
	    choosePlayerCharacter();
	    initialiseGame();
	    //printResult(); // TODO: Track score between games
	    //saveResult();  // TODO: Append score to file
	    System.out.print("Begin new game? (Y/n) ");
	} while (!scanner.nextLine().equalsIgnoreCase("n"));
    }

	
    public static void initialisePlayer() {
	System.out.print("Write the name of your character: ");
	String name = scanner.nextLine();
    }

    public static void choosePlayerCharacter() {
	System.out.println("Choose your character: WARRIOR (default) | MAGE | TITAN");
	String type = scanner.nextLine();
	GameCharacter player = GameHandler.create(type, name);
    }

    public static void initialiseGame() {
	GameCharacter computer = GameHandler.create(computerChoice(), "Computer");
	Game game = new Game(player, computer, scanner);
	game.start();
    }

    public static String computerChoice() {
	int computerChoice = random.nextInt(3);
	if (computerChoice == 0) { return "WARRIOR"; }
	if (computerChoice == 1) { return "MAGE"; }
	if (computerChoice == 2) { return "TITAN"; }
    }
}
