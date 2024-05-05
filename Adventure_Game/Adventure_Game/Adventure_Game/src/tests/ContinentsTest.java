package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import Adventure_Game.*;
import Exits.*;
import strangers.*;
import Items.*;

public class ContinentsTest {

    @Test
    public void testAddExitAndGetExit() {
        Continents continent = new Continents("TestContinent");
        Exits exit = new SimpleExit("North", new Continents("NextContinent"));

        continent.addExit("North", exit);

        // Vérifie si l'exit a été ajouté avec succès
        assertEquals(exit, continent.getExit("North"));
    }

    @Test
    public void testAddItemAndGetItem() {
        Continents continent = new Continents("TestContinent");
        Items item = new Food("Apple", 5,4);

        continent.addItem(item);

        // Vérifie si l'item a été ajouté avec succès
        assertEquals(item, continent.getItem("Apple"));
    }

    @Test
    public void testAddStrangerAndGetStranger() {
        Continents continent = new Continents("TestContinent");
        Stranger stranger = new WiseMan("Gandalf", "You shall not pass!");

        continent.addStranger(stranger);

        // Vérifie si le stranger a été ajouté avec succès
        assertEquals(stranger, continent.getStranger("Gandalf"));
    }

    @Test
    public void testRemoveItem() {
        Continents continent = new Continents("TestContinent");
        Items item = new Food("Banana", 3,4);

        continent.addItem(item);
        continent.removeItem(item);

        // Vérifie si l'item a été retiré avec succès
        assertNull(continent.getItem("Banana"));
    }

    @Test
    public void testGetMonsterByName() {
        Continents continent = new Continents("TestContinent");
        Monster monster = new Monster("Dragon", 50,140);

        continent.addStranger(monster);

        // Vérifie si le monstre est récupéré correctement par son nom
        assertEquals(monster, continent.getMonsterByName("Dragon"));
    }
}

