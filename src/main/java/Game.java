import java.util.Random;
import java.util.Scanner;

public class Game {

    private GameCharacter player;
    private GameCharacter computer;
    private boolean isPlayerTurn;
    private int roundCount;
    //private boolean isRunning;
    private Scanner input;
    Random random = new Random();
    
    public Game(GameCharacter player, GameCharacter computer, Scanner input) {
	this.player = player;
	this.computer = computer;
	//this.isRunning = false;
	this.input = input;
    }


    public void start() {
        isPlayerTurn = random.nextBoolean();
	roundCount = 1;
        gameLoop();
    }

    public void gameLoop() {
        while (player.isAlive() && computer.isAlive()) {
            if (isPlayerTurn) { playerTurn(); playerTurn(); }
	    else { computerTurn(); computerTurn(); }
	    isPlayerTurn = !isPlayerTurn;
	    roundCount++;
	}
	System.out.println(getWinner().getName() + " wins!");
    }

    public void playerTurn() {
        System.out.println("\nYour HP: " + player.getHp() + " | Computer HP: " + computer.getHp() + "\nYour MP: " + player.getMp() + " | Computer MP: " + computer.getMp() + "\n\nChoose your action:\n1. Attack\n2. Heal\n3. Special");
        String action = input.nextLine();

	switch (action) {
	    case "2" -> player.heal(player);
	    case "3" -> player.specialMove(player, computer);
	    default  -> player.basicAttack(player, computer);
	}
    }

    public void computerTurn() {
        int computerChoice = random.nextInt(3);

        if (computerChoice == 0) {
            computer.basicAttack(computer, player);
	} else if (computerChoice == 1) {
	    computer.heal(computer);
        } else if (computerChoice == 2) {
            computer.specialMove(computer, player);
        } else {
            System.out.println("An error has occured");
        }
    }

    public boolean isGameOver() {
        return !player.isAlive() || !computer.isAlive();
    }

    public GameCharacter getWinner() {
        return player.isAlive() ? player : computer;
    }

    //private int GetInitialStartingTurn() {
    //    int turn = random.nextInt(2);
    //    return turn;
    //}

    private boolean getIsPlayerTurn() {
        return isPlayerTurn;
    }

}
