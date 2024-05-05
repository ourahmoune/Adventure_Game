package Items;

public class Food extends Items {
	
	private int healthPoints;
    public Food(String name ,int volume,int healthPoints ) {
        super(name,volume);
        this.healthPoints=healthPoints;
    }
    
    public int getHealthPoints() {
    	return healthPoints;
    }
}