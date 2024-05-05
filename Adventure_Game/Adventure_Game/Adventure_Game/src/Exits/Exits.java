package Exits;
import Adventure_Game.Continents;
import java.io.Serializable;
public abstract class Exits implements Serializable  {
    protected String name;
    protected Continents destination;

    public Exits(String name, Continents destination) {
        this.name = name;
        this.destination=destination; 
    }
    
    public String getName() {
    	return name;
    }
    
    public Continents getDestination() {
    	return destination;
    }

    public abstract boolean open();
}

