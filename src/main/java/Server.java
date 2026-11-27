import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    //starta server, starta servertråd
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Thread serverThread = new Thread(() -> acceptLoop(serverSocket));
        serverThread.setDaemon(true);
        serverThread.start();
    }

    //accept incomming connections
    private void acceptLoop(ServerSocket serverSocket) {
        try (serverSocket) {
            while (true) {
                Socket socket = serverSocket.accept();
                Thread.startVirtualThread(new ClientHandler(socket));
            }
        } catch (IOException e) {
            System.err.println(TextColor.RED + "Server error: " + e.getMessage() + TextColor.RESET);
        }
    }
}
