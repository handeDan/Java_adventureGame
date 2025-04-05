import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the game!");

        System.out.println("Please enter a name : ");
        String playerName = input.nextLine();

       this.player = new Player(playerName);
        System.out.println("Welcome " + player.getName() + " to the game!");
        System.out.println("Please select a character : ");
        player.selectChar();
    }

}
