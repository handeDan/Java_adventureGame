package com.adventuregame.battle;

import com.adventuregame.main.Player;
import com.adventuregame.monsters.Monster;
import com.adventuregame.monsters.Snake;

public class Mine extends BattleLoc{

    public Mine(Player player) {
        super(player, "Mine",new Snake(), "weapon/armor/money or nothing", 5);
    }
}
