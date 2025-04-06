package com.adventuregame.battle;

import com.adventuregame.main.Player;
import com.adventuregame.monsters.Bear;

public class River extends BattleLoc {

    public River(Player player) {
        super(player, "River", new Bear(), "water", 2);
    }
}
