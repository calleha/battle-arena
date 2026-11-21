import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    private static final Path filePath = Path.of("match_history.csv");

    public static synchronized void saveMatch(MatchResult result) {
	try {
	    Files.writeString(filePath, result.toCsv() + System.lineSeparator(),
			      StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	} catch (IOException e) {
	    System.err.println("Could not save match: " + e.getMessage());
	}
    }

    public static synchronized List<String> readHistory() {
        try {
	    if (!Files.exists(filePath)) return List.of();
	    return Files.readAllLines(filePath);
	} catch (IOException e) {
	    System.err.println("Could not read match history: " + e.getMessage());
	    return List.of();
	}
    }
}
