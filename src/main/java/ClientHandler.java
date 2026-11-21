import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
	try (socket;
	     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

	    String line;
	    while ((line = in.readLine()) != null) {
		FileHandler.saveMatch(MatchResult.fromCsv(line));
		out.println("OK");
	    }
	} catch (IOException | IllegalArgumentException e) {
	    System.err.println("Client error: " + e.getMessage());
	}
    }
}
