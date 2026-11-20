public class GameHandler {
    public static GameCharacter create(String type, String name) {
	return switch (type.toUpperCase()) {
	    case "MAGE" -> new Mage(name, "Mage", 90, 90, 90, 90, 5, 15);
	    case "TITAN" -> new Titan(name, "Titan", 140, 140, 40, 40, 5, 20);
	    default -> new Warrior(name, "Warrior", 120, 120, 60, 60, 8, 18);
	};
    }
}
