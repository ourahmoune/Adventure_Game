package Exits;
import Adventure_Game.Continents;
public class SimpleExit extends Exits {
    public SimpleExit(String name,Continents destination) {
        super(name, destination);
    }

    @Override
    public boolean open() {
    	return true;
        // Implement logic for opening a simple exit
    }
}

