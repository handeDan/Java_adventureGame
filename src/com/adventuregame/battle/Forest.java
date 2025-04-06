package com.adventuregame.battle;

import com.adventuregame.main.Player;
import com.adventuregame.monsters.Vampire;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "firewood", 3);
    }
}
