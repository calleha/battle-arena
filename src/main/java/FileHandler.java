import java.nio.file.Path;
import java.util.List;

public class FileHandler {
    private static final Path filePath = Path.of("match_history.txt");

    public static void saveMatch(MatchResult result) {
        // TODO: Spara med Files och Path
    }

    public static List<String> readHistory() {
        // TODO: Läs in filen
        return null;
    }
}
