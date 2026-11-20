import java.util.Random;
import java.util.Scanner;

public class Game {

    private Character player;
    private Character opponent;
    private boolean playerTurn;
    private int roundCount;
    private boolean isRunning;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);


    public void start() {
        if(GetInitialStartingTurn() == 1){
            playerTurn();
        }else if(GetInitialStartingTurn() == 2){
            computerTurn();
        }else{
            System.out.println("An error has occured");
        }
        gameLoop();
    }

    public void gameLoop() {
        while (player.isAlive() && opponent.isAlive()) {
            // kolla runda, hp, vems tur det är
            // kalla på relevanta metoder, etc.

            // möjliga val är: attack, heal,
	    // magicattack (mage only), buff (titan only), debuff (warrior only)
	    //
            // datorn attackerar, ge status, vad hände? Har datorn och spelarna fortfarande hp?
            //

            if(getPlayerTurn() == true){

                playerTurn();
            }else if(getPlayerTurn() == false){
                computerTurn();
            }else{
                System.out.println("An error has occured");
            }
        }

    }

    public void playerTurn() {
        // TODO: Hantera spelarens tur
        System.out.println("You current HP is:" + player.getHp() + "\nChoose your action:\n1. Attack\n2. Heal\n3. Special");
        String action = input.nextLine();

        if(action.equals("attack")){
            player.basicAttack(opponent);
        }else if(action.equals("heal")){
	    player.heal(player);
	}else if(action.equals("special")){
            player.specialMove(player, opponent);
            computerTurn();
        }
    }

    public void computerTurn() {
        // TODO: Hantera datorns tur

        int computerChoice = rand.nextInt(2); // Ger 1, 2 eller 3

        if (computerChoice == 0) {
            opponent.attack(player);
	} else if (computerChoice == 1) {
	    opponent.heal(opponent);
        } else if (computerChoice == 2) {
            opponent.specialMove(opponent, player);
        } else {
            System.out.println("An error has occured");
        }
    }

    public boolean isGameOver() {
        return false;
    }

    public Character getWinner() {
        return null;
    }

    private int GetInitialStartingTurn() {
        int turn = rand.nextInt(2);
        return turn;
    }

    private boolean getPlayerTurn() {
        return playerTurn;
    }

}
