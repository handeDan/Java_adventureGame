package com.adventuregame.main;

import com.adventuregame.battle.Cave;
import com.adventuregame.battle.Forest;
import com.adventuregame.battle.River;
import com.adventuregame.location.Location;
import com.adventuregame.location.SafeHouse;
import com.adventuregame.location.ToolStore;

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
        Location location = null;

        while(true) {
            player.printInfo();
            System.out.println("           ");
            System.out.println("### Locations ###");
            System.out.println("1. Safe House :  here, it's a safe house for you, no enemy!");
            System.out.println("2. Tool Store : here, you can buy weapons and armors!");
            System.out.println("3. Cave : award is food! but here, you can face a zombie!");
            System.out.println("4. Forest : award is firewood! but here, you can face a vampire!");
            System.out.println("5. River : award is water! but here, you can face a bear!");
            System.out.println("0. Exit : here, you can exit the game!");
            System.out.println("Please choose a location : ");

            int selectLoc = input.nextInt();
            location = switch (selectLoc) {
                case 0 -> null;
                case 1 -> new SafeHouse(player);
                case 2 -> new ToolStore(player);
                case 3 -> new Cave(player);
                case 4 -> new Forest(player);
                case 5 -> new River(player);
                default -> {
                    System.out.println("Please choose a valid location!");
                    yield null;
                }
            };

            if(location == null) {
                System.out.println("The game is over! See you next time!");
                break;
            }

            if(!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }

        }
    }

}
