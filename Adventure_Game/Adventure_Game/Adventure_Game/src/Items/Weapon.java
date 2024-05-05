package Items;

public class Weapon extends Items {
	private int attackDamage;
    public Weapon(String name , int volume, int attackDamage) {
        super(name,volume);
        this.attackDamage=attackDamage;
    }
    
    public int getAttackDamage() {
    	return this.attackDamage;
    }
}