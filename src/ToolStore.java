public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the store!");
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
                break;
            case 2:
//                printArmors();
                break;
            case 3:
                System.out.println("Goodbye!");
                return true;
        }
        return true;
    }

    public void printWeapons() {
        System.out.println("---- Weapons ----");
        for(Weapon weapon : Weapon.weapons()) {
            System.out.println("ID = " + weapon.getId() + "  " +
                    "Weapon = " + weapon.getName() + "     " +
                    " Damage : " + weapon.getDamage() +
                    " Price : " + weapon.getPrice());
        }
        System.out.println("Please choose a weapon by ID : ");
        int selectWeaponID = input.nextInt();

        while(selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Please choose a valid option : ");
            selectWeaponID = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponID);
        if(selectedWeapon != null) {
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You don't have enough money!");
            } else {
                System.out.println(selectedWeapon.getName() + " is bought!");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your balance is : " + this.getPlayer().getMoney());
            }
    }

//    public void printArmors {
//        System.out.println("---- Armors ----");
//    }

    }
}
