import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.nio.file.Path;
import java.util.List;

public class Server {
    private static final Path filePath = Path.of("match_history.txt");
    private static String matchResult;
    
    private int port;

    public Server(int port) { this.port = port; }
    
    public static void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

	    while (true) {
		try (Socket clientSocket = serverSocket.accept()) {

		    Thread.startVirtualThread(() -> handleClient(clientSocket));
		    	    
		} catch (IOException e) { e.printStackTrace(); }
	    }
	}
    }

    private static void handleClient(Socket socket) {
	try (socket;
	     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

	    String matchResult;
	    while ((matchResult = in.readLine()) != null) {
		saveMatch(new MatchResult(playerName, playerCharacter, opponentCharacter, winnerName, rounds));
		//skriv message till filen - kolla övningen från filhanteringslektionen
	    }
	} catch (IOException e) { System.err.println("Client connection error: " + e.getMessage()); }
    }

    public static void printMatchResult() { System.out.println(matchResult); }
    
    public static void saveMatch(MatchResult result) {}

    public static List<String> readHistory() { return null; }
}
