package com.adventuregame.location;

import com.adventuregame.inventory.Armor;
import com.adventuregame.inventory.Weapon;
import com.adventuregame.main.Player;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the store!");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Buy a weapon");
            System.out.println("2- Buy an armor");
            System.out.println("3- Exit");
            System.out.println("Please choose an option : ");
            int selectCase = input.nextInt();

            while(selectCase < 1 || selectCase > 3) {
                System.out.println("Please choose a valid option : ");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapons() {
        System.out.println("---- Weapons ----");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println("ID = " + weapon.getId() + "  " +
                    "com.adventuregame.inventory.Weapon = " + weapon.getName() + "     " +
                    " Damage : " + weapon.getDamage() +
                    " Price : " + weapon.getPrice());
        }
        System.out.println("0- Exit");
    }
    public void buyWeapon() {
            System.out.println("Please choose a weapon by ID : ");
            int selectWeaponID = input.nextInt();

            while(selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
                System.out.println("Please choose a valid option : ");
                selectWeaponID = input.nextInt();
            }

        if(selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    //buying weapon:
                    System.out.println(selectedWeapon.getName() + " is bought!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your balance is : " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmors(){
        System.out.println("---- Armors ----");
        for (Armor armor : Armor.armors()) {
            System.out.println("ID = " + armor.getId() + "  " +
                    "com.adventuregame.inventory.Armor = " + armor.getName() + "     " +
                    " Block : " + armor.getBlock() +
                    " Price : " + armor.getPrice());
        }
        System.out.println("0- Exit");
    }

    public void buyArmor() {
        System.out.println("Please choose an armor by ID : ");
        int selectArmorID = input.nextInt();

        while(selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Please choose a valid option : ");
            selectArmorID = input.nextInt();
        }

        if(selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorById(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    //buying armor:
                    System.out.println(selectedArmor.getName() + " is bought!");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your balance is : " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }

}