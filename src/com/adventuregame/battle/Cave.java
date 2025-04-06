package com.adventuregame.battle;

import com.adventuregame.main.Player;
import com.adventuregame.monsters.Zombie;

public class Cave extends BattleLoc{

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "food", 3);
    }

}
