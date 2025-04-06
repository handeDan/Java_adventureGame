import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private int armor;
    private String name;
    private String charName;
    private Inventory inventory;

    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectChar() {
        Character[] characters = {new Samurai(), new Archer(), new Knight()};

        System.out.println("-------------------------------");
        System.out.println("Characters :");
        for (Character character : characters) {
            System.out.println("ID = " + character.getId() + "  " +
                    "Character = " + character.getName() + "     " +
                    " Damage : " + character.getDamage() +
                    " Health : " + character.getHealth() +
                    " Money : " + character.getMoney());
        }
        System.out.println("-------------------------------");

        System.out.println("Please choose a character by ID : ");
        int selectChard = input.nextInt();
        switch (selectChard) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
        }
        /*System.out.println("Character selected : " + this.getCharName() + "     " +
                " Damage : " + this.getDamage() +
                " Health : " + this.getHealth() +
                " Money : " + this.getMoney()); */
    }

    public void initPlayer(Character character) {
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());
    }

    public void printInfo() {
        System.out.println("-------------------------------");
        System.out.println("Character : " + this.getCharName() + "     " +
                " Weapon : " + this.getInventory().getWeapon().getName() +
                " Damage : " + this.getDamage() +
                " Health : " + this.getHealth() +
                " Money : " + this.getMoney());
        System.out.println("-------------------------------");
    }
}