package Items;

import java.io.Serializable;


public class Items implements Serializable {
    protected String name;
    protected int volume ;
    public Items(String name , int volume) {
        this.name = name;
        this.volume = volume;

    }
    public int getVolume() {
        return this.volume;
    }
    public String getName (){
        return this.name ;
    }
}
