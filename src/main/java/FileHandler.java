import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    private static final Path filePath = Path.of("match_history");

    public static synchronized void saveMatch(MatchResult result) {
	try {
	    Files.writeString(filePath, result.toString() + System.lineSeparator(),
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

    public static void showHistory() {
	List<String> matchHistory = readHistory();
	long match = 1;
	System.out.println("------------------------------------------------Previous Games------------------------------------------------");
	for (String line : matchHistory) {
	    System.out.printf("%d - %s\n", match, line);
	    match++;
	}
    }
}
