import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the game!");

        System.out.println("Please enter a name : ");
        String playerName = input.nextLine();

       Player newPlayer = new Player(playerName);
        System.out.println("Welcome " + newPlayer.getName() + " to the game!");
        System.out.println("Please select a character : ");
        player.selectChar();
    }

}
