package com.adventuregame.battle;

import com.adventuregame.location.Location;
import com.adventuregame.main.Player;
import com.adventuregame.monsters.Monster;

import java.util.Random;
import java.util.Scanner;

public class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;
    private Scanner input = new Scanner(System.in);

    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("Now you are here: " + this.getName() + "!");
        System.out.println("Be careful, " + monsterNumber + " " + this.getMonster().getName() + " are here!");
        System.out.println("<S>tart the battle! or <R>un away!");
        String selectCase = input.nextLine().toUpperCase();

        if (selectCase.equals("S") && combat(monsterNumber)) {
                System.out.println(this.getName() + " cleared!");
                return true;
        }

        if (selectCase.equals("R")) {
            System.out.println("You ran away!");
            return false;
        }

        if(this.getPlayer().getHealth() <= 0) {
            System.out.println("You have been defeated!");
            return false;
        }

            return true;
    }

    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getOriginalHealth());

            playerStats();
            monsterStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<A>ttack or <R>un away!");
                String selectCase = input.nextLine().toUpperCase();

                if (selectCase.equals("A")) {
                    System.out.println("You attack the " + this.getMonster().getName() + "!");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterAttack();

                    if (this.getMonster().getHealth() <= 0) {
                        System.out.println("You defeated the " + this.getMonster().getName() + "!");
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                        break;
                    }

                    System.out.println("The " + this.getMonster().getName() + " attacks you!");

                    int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();

                    if (monsterDamage < 0) {
                        monsterDamage = 0;
                    }

                    this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                    afterAttack();

                    if (this.getPlayer().getHealth() <= 0) {
                        return false;
                    }
                } else {
                    System.out.println("You ran away!");
                    return false;
                }

            }

            if(this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println(this.getName() + " cleared!");
                System.out.println("You got " + this.getMonster().getAward() + " gold!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Your current gold: " + this.getPlayer().getMoney());
            } else {
                System.out.println("You have been defeated!");
                return false;
            }
        }
        return true;
    }

    public void afterAttack() {
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " health: " + this.getMonster().getHealth());
        System.out.println("-----------------------------");
    }

    public void playerStats() {
        System.out.println("Player stats:");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
    }

    public void monsterStats(int i) {
        System.out.println(i + "." +this.getMonster().getName() + " stats:");
        System.out.println("Health: " + this.getMonster().getHealth());
        System.out.println("Damage: " + this.getMonster().getDamage());
        System.out.println("Award: " + this.getMonster().getAward());
    }

    public int randomMonsterNumber() {
        Random r = new Random();
        return (this.getMaxMonster() > 0) ? (r.nextInt(this.getMaxMonster()) + 1) : 1;
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
