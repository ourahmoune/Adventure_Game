package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;


import Adventure_Game.World;
import Adventure_Game.Continents;
import strangers.*;
import Exits.*;
import Player.*;
import Items.*;
import java.util.Scanner;

import static org.junit.Assert.*;


public class WorldTest {

	//test unitaires
    @Test
    public void testAddContinent() {
        World world = new World();
        Continents africa = new Continents("Africa");

        // Ajoutez le continent à la liste des continents
        world.addContinent(africa);

        // Vérifiez si le continent a été ajouté avec succès
        assertTrue(world.getContinentsList().contains(africa));
    }

    @Test
    public void testGetContinent() {
        World world = new World();
        Continents africa = new Continents("Africa");

        // Ajoutez le continent à la liste des continents
        world.addContinent(africa);

        // Obtenez le continent par son nom
        Continents retrievedContinent = world.getContinent("Africa");

        // Vérifiez si le continent récupéré est le même que celui ajouté
        assertEquals(africa, retrievedContinent);
    }
    
    @Test
    public void testFindWiseMan() {
        World world = new World();
        Continents africa = new Continents("Africa");
        world.addContinent(africa);

        WiseMan wiseMan = new WiseMan("Mystic", "I know the secrets");
        africa.addStranger(wiseMan);

        // Test avec un nom de WiseMan existant
        WiseMan foundWiseMan = world.findWiseMan("Mystic");
        assertNotNull(foundWiseMan);
        assertEquals("Mystic", foundWiseMan.getName());

        // Test avec un nom de WiseMan non existant
        WiseMan nonExistentWiseMan = world.findWiseMan("NonExistent");
        assertNull(nonExistentWiseMan);
    }
    
    @Test
    public void testGetWorld() {
        World world1 = World.getWorld();
        World world2 = World.getWorld();

        assertSame(world1, world2);
    }
    
    @Test
    public void testHandleGoCommand() {
        // Créez un monde avec deux continents : Africa et Europe
        World world = new World();
        Continents africa = new Continents("Africa");
        Continents europe = new Continents("Europe");
        world.addContinent(africa);
        world.addContinent(europe);

        // Ajoutez une sortie de Africa vers Europe (par exemple, North)
        africa.addExit("North", new SimpleExit("North", europe));

        // Initialisez le joueur en Afrique
        Player player = new Player("Hero", 200, 50, africa);
        world.getPlayer();

        // Exécutez la commande "GO North"
        world.handleGoCommand(new Scanner("GO North"));

        // Vérifiez si la position du joueur est maintenant en Europe
        assertEquals(europe, player.getContinents());
    }
    
    
    public void testHandleTakeCommand() {
        // Créez un monde avec un continent (par exemple, Africa) et un objet à prendre
        World world = new World();
        Continents africa = new Continents("Africa");
        world.addContinent(africa);

        Items itemToTake = new Food("Apple", 10,7);
        africa.addItem(itemToTake);

        // Initialisez le joueur en Afrique
        Player player = new Player("Hero", 200, 50, africa);
        world.getPlayer();

        // Exécutez la commande "TAKE Apple"
        world.handleTakeCommand(new Scanner("TAKE Apple"));

        // Vérifiez si l'objet est maintenant dans le sac du joueur
        assertTrue(player.getBag().getItemsList().contains(itemToTake));
    }
    
    @Test
    public void testHandleUseCommand() {
        // Créez un monde avec un joueur et un objet utilisable dans son sac
        World world = new World();
        Continents africa = new Continents("Africa");
        world.addContinent(africa);

        Player player = new Player("Hero", 200, 50, africa);
        world.getPlayer();

        Items usableItem = new Food("Apple", 10,10);
        player.getBag().addItem(usableItem);

        // Exécutez la commande "USE Apple"
        world.handleUseCommand(new Scanner("USE Apple"));

        // Vérifiez si les attributs du joueur sont mis à jour correctement
        assertEquals(210, player.getHealthPoints()); // Supposons que l'Apple donne 10 points de santé
    }
    
    @Test
    public void testThrowItem() {
        // Créez un monde avec un joueur et un objet dans son sac
        World world = new World();
        Continents africa = new Continents("Africa");
        world.addContinent(africa);

        Player player = new Player("Hero", 200, 50, africa);
        world.getPlayer();

        // Ajoutez un objet (Weapon) au sac du joueur
        Weapon weaponItem = new Weapon("Sword", 20,20);
        player.getBag().addItem(weaponItem);

        // Exécutez la méthode throwItem avec le nom de l'objet
        world.throwItem("Sword");

        // Vérifiez si l'objet a été retiré du sac du joueur
        assertFalse(player.getBag().getItemsList().contains(weaponItem));

        // Vérifiez si l'objet a été ajouté au continent
        assertTrue(africa.getItemsList().contains(weaponItem));

        // Vérifiez si les attributs du joueur ont été mis à jour correctement
        assertEquals(30, player.getAttackDamage()); // Supposons que l'épée donne une diminution de 20 de dégâts
    }
    
}

