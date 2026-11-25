import java.time.LocalDateTime;

public class MatchResult {
    private String playerName;
    private String playerCharacter;
    private String computerCharacter;
    private String winnerName;
    private int    rounds;
    private LocalDateTime date = LocalDateTime.now();
    private String formattedDate;

    public MatchResult(String playerName, String playerCharacter, String computerCharacter, String winnerName, int rounds) {
        this.playerName        = playerName;
        this.playerCharacter   = playerCharacter;
        this.computerCharacter = computerCharacter;
        this.winnerName        = winnerName;
        this.rounds            = rounds;
	this.formattedDate     = getDate();
    }

    @Override
    public String toString() {
	return String.format("Player %s (%s) vs Computer (%s): %s won in %d rounds. Finished at %s",
		      clean(playerName), playerCharacter, computerCharacter,
		      clean(winnerName), rounds, formattedDate);
    }
    
    public String toCsv() {
	return String.join(",", clean(playerName), playerCharacter, computerCharacter,
			   clean(winnerName), String.valueOf(rounds), formattedDate);
    }

    public static MatchResult fromCsv(String line) {
	String[] values = line.split(",", -1);
	if (values.length != 6) throw new IllegalArgumentException("Bad Line: " + line);
	return new MatchResult(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]));
    }

    private static String clean(String s) { return s.replace(";", ","); }

    public String getPlayerName()        { return playerName; }
    public String getPlayerCharacter()   { return playerCharacter; }
    public String getComputerCharacter() { return computerCharacter; }
    public String getWinnerName()        { return winnerName; }
    public int    getRounds()            { return rounds; }
    public String getDate()              { return String.format("%tF %tT", date, date); }
}
