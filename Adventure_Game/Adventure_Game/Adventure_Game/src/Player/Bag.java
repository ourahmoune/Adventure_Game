package Player;
import java.util.ArrayList;
import java.util.List;

import Items.Items;
import java.io.Serializable;

public class Bag implements Serializable {
    private final static int DEFAULT_VOLUME_MAX = 20 ;
    private final static int DEFAULT_EMPTY_VOLUME= 0 ; 
    private  int current_volume  = DEFAULT_EMPTY_VOLUME ; 
    private List<Items> itemsList = new ArrayList<>();
    
    public void addItem(Items item) {
        itemsList.add(item);
        
    }
    
    public List<Items>getItemsList(){
    	return itemsList;
    }
    
    public int getCurrent() {
    	return this.current_volume;
    }
    public void setCurrent(int cur) {
    	this.current_volume=cur;
    }
    
    public Items getItem(String itemName) {
        for (Items item : itemsList) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    public void removeItem(Items item){
       itemsList.remove(item); 
    }
    public boolean canAddItem(Items item) {
        // Vérifie si le volume disponible dans le sac est suffisant
        return (current_volume + item.getVolume()) <= DEFAULT_VOLUME_MAX;
    }
    public void displayContents() {
        if (itemsList.isEmpty()) {
            System.out.println("Your bag is empty.");
            System.out.println("You have a space of 20.");
        } else {
            System.out.println("Items in your bag:");
            System.out.println("you have space of  "+ (20-getCurrent()));
            for (Items item : itemsList) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
