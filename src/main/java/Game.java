import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private GameCharacter player;
    private GameCharacter computer;
    private boolean isPlayerTurn;
    private int roundCount;
    private Scanner input;
    Random random = new Random();

    public Game(GameCharacter player, GameCharacter computer, Scanner input) {
        this.player = player;
        this.computer = computer;
        this.input = input;
    }

    public void start() {
        isPlayerTurn = random.nextBoolean();
        roundCount = 1;

        System.out.println("\n" + TextColor.GREEN + player.getName() + TextColor.YELLOW +
                           " the " + player.getCharacterType() + TextColor.CYAN + "  VS  " +
                           TextColor.RED + computer.getName() + TextColor.YELLOW +
                           " the " + computer.getCharacterType() + TextColor.RESET);
        System.out.println(TextColor.CYAN + (isPlayerTurn ? "You go first!" : "Computer goes first!") + TextColor.RESET);

        gameLoop();
    }

    public void gameLoop() {
        while (player.isAlive() && computer.isAlive()) {
            if (isPlayerTurn) {
                playerTurn();
                if (computer.isAlive()) {
                    playerTurn2();
                }
                turnWait();
            } else {
                System.out.println(TextColor.PURPLE + "\n--- Computer's turn ---" + TextColor.RESET);
                computerTurn();
                turnWait();
                if (player.isAlive()) {
                    computerTurn();
                    turnWait();
                }
            }
            isPlayerTurn = !isPlayerTurn;
        }

        GameCharacter winner = getWinner();
        System.out.println(TextColor.CYAN + "\n=================================" + TextColor.RESET);
        System.out.println(TextColor.YELLOW + winner.getName() + TextColor.RESET + " wins!");
        System.out.println(TextColor.CYAN + "=================================" + TextColor.RESET);

        //added sound effects
        if (winner == player) {
            SoundManager.playWin();
        } else {
            SoundManager.playDefeat();
        }
    }

    public void playerTurn() {
        System.out.println(TextColor.CYAN + "\n------------Round " + roundCount + "------------" + TextColor.RESET +
                           TextColor.GREEN + "\n\nChoose your action:" + TextColor.RESET +
                           "\n" + TextColor.YELLOW + "1." + TextColor.RESET + " Attack (default)" +
                           "\n" + TextColor.YELLOW + "2." + TextColor.RESET + " Heal (" +
                           TextColor.BLUE + player.getHealCost() + " MP" + TextColor.RESET + ")" +
                           "\n" + TextColor.YELLOW + "3." + TextColor.RESET + " Special (" +
                           TextColor.BLUE + player.getSpecialCost() + " MP" + TextColor.RESET + ")");
        playerTurn2();
        roundCount++;
    }

    //Rensa upp? Slå ihop metod med playerTurn?
    public void playerTurn2() {
        System.out.println("\nYour HP: " + TextColor.GREEN + player.getHp() + TextColor.RESET +
                           "  Computer HP: " + TextColor.RED + computer.getHp() + TextColor.RESET +
                           "\nYour MP: " + TextColor.BLUE + player.getMp() + TextColor.RESET +
                           "  Computer MP: " + TextColor.BLUE + computer.getMp() + TextColor.RESET);
        System.out.print(TextColor.GREEN + "> " + TextColor.RESET);
        String action = input.nextLine();
        switch (action) {
            case "2" -> player.heal(player);
            case "3" -> player.specialMove(player, computer);
            default  -> player.basicAttack(player, computer);
        }
    }

    public void computerTurn() {
        List<Integer> options = new ArrayList<>();
        options.add(0);
        if (computer.canHeal() && computer.getHp() < computer.getMaxHp()) options.add(1);
        if (computer.canSpecial()) options.add(2);

        int computerChoice = options.get(random.nextInt(options.size()));
        switch (computerChoice) {
            case 0  -> computer.basicAttack(computer, player);
            case 1  -> computer.heal(computer);
            default -> computer.specialMove(computer, player);
        }
    }

    //Waits 0.5 seconds before next turn
    public void turnWait() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



    public boolean isGameOver() {
        return !player.isAlive() || !computer.isAlive();
    }

    public GameCharacter getWinner() {
        return player.isAlive() ? player : computer;
    }

    public boolean getIsPlayerTurn() {
        return isPlayerTurn;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
