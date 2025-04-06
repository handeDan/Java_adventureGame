package com.adventuregame.battle;

import com.adventuregame.location.Location;
import com.adventuregame.main.Player;
import com.adventuregame.monsters.Monster;

import java.util.Random;

public class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("Now you are here : " + this.getName() + "!");
        System.out.println("Be careful, " + monsterNumber + " " + this.getMonster().getName() + " are here!");
        System.out.println("<S>tart the battle! or <R>un away!");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")) {
            //Battle
        } else {
            //Run
        }
        return true;
    }

    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }
    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
