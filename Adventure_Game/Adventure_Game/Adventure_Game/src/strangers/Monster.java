package strangers;
import Player.Player;
public class Monster extends Stranger {
    private final int DEFAULT_HEALTHPONITS = 300 ;
    private int healthPoints;
    private boolean isAlive  = true ;
    private int attackDamage;
    
    public Monster (String s,int attackDamage, int healthPoints) {
    	super(s);
    	this.attackDamage=attackDamage;
    	this.healthPoints=healthPoints;
    }
    public void  attack (Player p){
    	
    }
    public boolean isAlive(){
        return this.isAlive;
    }
    public int getAttackDamage() {
		return attackDamage;
	}
    
    public int getHealthPoints() {
    	return this.healthPoints;
    }
    public void setHealthPoints(int Hp) { 
    	this.healthPoints=Hp;
    }
}