package com.adventuregame.location;

import com.adventuregame.main.Player;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safe house!");
        System.out.println("Your life is full!");
        return true;
    }

}
