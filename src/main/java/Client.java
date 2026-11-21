import java.io.IOException;
import java.net.Socket;

public class Client {
    private String serverAddress;
    private int port;

    public Client(String serverAddress, int port) {
	this.serverAddress = serverAddress;
	this.port = port;
    }
    
    public static void sendResult(MatchResult result) {
	try (Socket socket = new Socket(serverAddress, port)) {

	    //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

	    out.println(result);

	} catch (IOException e) { e.printStackTrace(); }
    }
}
