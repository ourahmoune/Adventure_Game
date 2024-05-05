package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import Adventure_Game.Continents;
import Player.*;

public class PlayerTest {

    @Test
    public void testIncreaseHealth() {
        Player player = new Player("TestPlayer", 100, 10, new Continents("TestContinent"));

        // Augmentez la santé du joueur
        player.increaseHealth(20);

        // Vérifiez si la santé a été augmentée avec succès
        assertEquals(120, player.getHealthPoints());
    }

    @Test
    public void testIncreaseAttackDamage() {
        Player player = new Player("TestPlayer", 100, 10, new Continents("TestContinent"));

        // Augmentez les dégâts d'attaque du joueur
        player.increaseAttackDamage(5);

        // Vérifiez si les dégâts d'attaque ont été augmentés avec succès
        assertEquals(15, player.getAttackDamage());
    }

    @Test
    public void testDecreaseAttackDamage() {
        Player player = new Player("TestPlayer", 100, 10, new Continents("TestContinent"));

        // Diminuez les dégâts d'attaque du joueur
        player.decreaseAttackDamage(3);

        // Vérifiez si les dégâts d'attaque ont été diminués avec succès
        assertEquals(7, player.getAttackDamage());
    }

    @Test
    public void testMoveTo() {
        Player player = new Player("TestPlayer", 100, 10, new Continents("TestContinent"));
        Continents destination = new Continents("NextContinent");

        // Déplacez le joueur vers une nouvelle destination
        player.moveTo(destination);

        // Vérifiez si le joueur a été déplacé avec succès
        assertEquals(destination, player.getContinents());
    }


}

