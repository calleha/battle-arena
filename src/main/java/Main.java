import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import java.util.List;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {

	try { Server server = new Server(5000); server.start(); }
	catch (IOException e) { System.err.println("Could not start server: " + e.getMessage()); }
	Client client = new Client("localhost", 5000);

	System.out.print("Write the name of your character: ");
	String name = scanner.nextLine();

	do {
	    System.out.println("Choose your character: WARRIOR (default) | MAGE | TITAN");
	    String type = scanner.nextLine();
	    GameCharacter player = GameHandler.create(type, name);

	    GameCharacter computer = GameHandler.create(computerChoice(), "Computer");
	    Game game = new Game(player, computer, scanner);
	    game.start();

	    MatchResult result = new MatchResult(
		name, player.getCharacterType(), computer.getCharacterType(),
		game.getWinner().getName(), game.getRoundCount());
	    client.sendResult(result);
	    System.out.println(result.toString());
	    
	    System.out.print("Begin new game? (Y/n) ");
	} while (!scanner.nextLine().equalsIgnoreCase("n"));

	FileHandler.showHistory();
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
