import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Läs emot matchresultat och anropa HistoryManager
	try (socket;
	     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

	    out.println(in.readLine());
	} catch (IOException e) { e.printStackTrace(); }
    }
}
