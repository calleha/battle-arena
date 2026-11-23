import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
        gameLoop();
    }

    public void gameLoop() {
        while (player.isAlive() && computer.isAlive()) {
            if (isPlayerTurn) { playerTurn(); if (computer.isAlive()) playerTurn2(); turnWait(); }
	    else { computerTurn(); turnWait(); if (player.isAlive()) computerTurn(); turnWait(); }
	    isPlayerTurn = !isPlayerTurn;
	}
	System.out.println(getWinner().getName() + " wins!");
    }

    public void playerTurn() {
        System.out.println("\n------------Round " + roundCount + "------------" +
			   "\n\nChoose your action:\n1. Attack (default)\n2. Heal (" + player.getHealCost() +
			   " MP)\n3. Special (" + player.getSpecialCost() + " MP)");
	playerTurn2();
	roundCount++;
    }

    public void playerTurn2() {
	System.out.println("\nYour HP: " + player.getHp() + "  Computer HP: " + computer.getHp() +
			   "\nYour MP: " + player.getMp() + "  Computer MP: " + computer.getMp());
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
	    case 0   -> computer.basicAttack(computer, player);
	    case 1   -> computer.heal(computer);
	    default  -> computer.specialMove(computer, player);
	}
    }

    public void turnWait() {
	try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
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
