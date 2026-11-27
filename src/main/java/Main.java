import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        try {
            Server server = new Server(5000);
            server.start();
        } catch (IOException e) {
            System.err.println(TextColor.RED + "Could not start server: " + e.getMessage() + TextColor.RESET);
        }
        Client client = new Client("localhost", 5000);

        System.out.println(TextColor.CYAN + "\n=================================" +
                           "\n          BATTLE ARENA" +
                           "\n=================================\n" + TextColor.RESET);

        System.out.print(TextColor.GREEN + "Write the name of your character: " + TextColor.RESET);
        String name = scanner.nextLine();

        do {
            System.out.println(TextColor.GREEN + "Choose your character: " +
                               TextColor.YELLOW + "WARRIOR (default) | MAGE | TITAN" + TextColor.RESET);
            String type = scanner.nextLine();
            GameCharacter player = GameHandler.create(type, name);

            GameCharacter computer = GameHandler.create(computerChoice(), "Computer");
            Game game = new Game(player, computer, scanner);
            game.start();

            MatchResult result = new MatchResult(
                    name, player.getCharacterType(), computer.getCharacterType(),
                    game.getWinner().getName(), game.getRoundCount());
            client.sendResult(result);
            System.out.println(TextColor.CYAN + "Match result: " + TextColor.WHITE + result.toCsv() + TextColor.RESET);

            System.out.print(TextColor.GREEN + "\nBegin new game? (Y/n) " + TextColor.RESET);
        } while (!scanner.nextLine().equalsIgnoreCase("n"));

        FileHandler.readHistory();
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
