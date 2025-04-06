public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Gun", 1, 10, 5);
        weaponList[1] = new Weapon("Sword", 2, 20, 15);
        weaponList[2] = new Weapon("Spear", 3, 30, 25);
        return weaponList;
    }

    public static Weapon getWeaponById(int id) {
        for(Weapon w : weapons()) {
            if(w.getId() == id) {
                return w;
            }
        }
        return null;
    }

}
