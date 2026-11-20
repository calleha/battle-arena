public class MatchResult {
    private String playerName;
    private String playerCharacter;
    private String opponentCharacter;
    private String winnerName;
    private int rounds;

    public MatchResult(String playerName, String playerCharacter, String opponentCharacter, String winnerName, int rounds) {
        this.playerName = playerName;
        this.playerCharacter = playerCharacter;
        this.opponentCharacter = opponentCharacter;
        this.winnerName = winnerName;
        this.rounds = rounds;
    }

    public String getPlayerName() { return playerName; }
    public String getPlayerCharacter() { return playerCharacter; }
    public String getOpponentCharacter() { return opponentCharacter; }
    public String getWinnerName() { return winnerName; }
    public int getRounds() { return rounds; }
}
