package com.adventuregame.inventory;

public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public static Armor[] armors() {
        Armor[] armors = new Armor[4];
        armors[0] = new Armor("Helmet", 1, 1, 15);
        armors[1] = new Armor("Chestplate", 2, 3, 20);
        armors[2] = new Armor("Leggings", 3, 5, 25);
        armors[3] = new Armor("Boots", 4, 7, 30);
        return armors;
    }

    public static Armor getArmorById(int id) {
        for(Armor a : armors()) {
            if(a.getId() == id) {
                return a;
            }
        }
        return null;
    }
}
