import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {

	System.out.print("Write the name of your character: ");
	String name = scanner.nextLine();

	Server server = new Server(5000);
	server.start();
	Client client = new Client("localhost", 5000);

	do {
	    System.out.println("Choose your character: WARRIOR (default) | MAGE | TITAN");
	    String type = scanner.nextLine();
	    GameCharacter player = GameHandler.create(type, name);

	    GameCharacter computer = GameHandler.create(computerChoice(), "Computer");
	    Game game = new Game(player, computer, scanner);
	    game.start();

	    client.sendResult();
	    //printResult(); // TODO: Track score between games
	    //FileHandler.saveMatch();  // TODO: Append score to file
	    
	    System.out.print("Begin new game? (Y/n) ");
	} while (!scanner.nextLine().equalsIgnoreCase("n"));
    }

    public static String computerChoice() {
	int computerChoice = random.nextInt(3);
	return switch (computerChoice) {
	    case 1 -> "MAGE";
	    case 2 -> "TITAN";
	    default -> "WARRIOR";
	};
    }
}
