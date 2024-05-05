package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import Player.Bag;
import Items.Food;

public class BagTest {

    @Test
    public void testAddItem() {
        Bag bag = new Bag();
        Food apple = new Food("Apple", 5,8);

        // Ajoutez l'élément au sac
        bag.addItem(apple);

        // Vérifiez si l'élément a été ajouté avec succès
        assertTrue(bag.getItemsList().contains(apple));
    }

    @Test
    public void testRemoveItem() {
        Bag bag = new Bag();
        Food banana = new Food("Banana", 4,8);

        // Ajoutez l'élément au sac
        bag.addItem(banana);

        // Retirez l'élément du sac
        bag.removeItem(banana);

        // Vérifiez si l'élément a été retiré avec succès
        assertFalse(bag.getItemsList().contains(banana));
    }

    @Test
    public void testCanAddItem() {
        Bag bag = new Bag();
        Food pizza = new Food("Pizza", 10,4);

        // Vérifiez si l'élément peut être ajouté au sac
        assertTrue(bag.canAddItem(pizza));
    }

    @Test
    public void testDisplayContents() {
        Bag bag = new Bag();
        Food sandwich = new Food("Sandwich", 6,7);

        // Ajoutez l'élément au sac
        bag.addItem(sandwich);

        // Affichez le contenu du sac
        bag.displayContents();
    }
}

