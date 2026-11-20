public class Client {
    private String serverAddress;
    private int port;

    public Client(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.port = port;
    }

    public void sendResult(MatchResult result) {
        // TODO: Skicka resultat till servern
    }
}
