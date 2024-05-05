package Player;
import Adventure_Game.Continents;
import Adventure_Game.World;
import Commands.CommandHandler;
import Items.Items;
import strangers.Stranger;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

import java.io.Serializable;
public  class Player implements CommandHandler,Serializable {
    private String name;
    private int healthPoints;
    private boolean isAlive;
    private int attackDamage;
    private Bag bag;
    private Continents position  ; 
    private World world=World.getWorld();
    private List<String> adviceList= new ArrayList<>();
    
    
    public Player(String name, int healthPoints,  int attackDamage,  Continents position) {
        this.position = position;
        this.name = name;
        this.healthPoints = healthPoints;
        this.isAlive = true;
        this.attackDamage = attackDamage;
        this.bag = new Bag();  // Composition: Player has a Bag
    }
    
    public Bag getBag() {
        return bag;
    }
    public void addAdvice(String advice) {
        adviceList.add(advice);
    }
    public List<String> getAdviceList() {
        return adviceList;
    }
    public void getAdvice(List<String> adviceList) {
        int i = 1;
        for (String advice : adviceList) {
            System.out.println("Advice  " + i + ": " + advice);
            i++;
        }
    }

    	
    
    public  Continents getContinents()  {
        return this.position;
    }
    public int getHealthPoints() {
    	return this.healthPoints;
    }
    public void setHealthPoints(int Hp) { 
    	this.healthPoints=Hp;
    }
    public void setAttackDamage(int Dp) {
    	this.attackDamage=Dp;
    }
    
    public void setPosition (Continents destination )  {
        this.position = destination;
    }
    public void moveTo(Continents destination) {
        this.position = destination;
    }
    public void increaseHealth(int amount) {
        this.healthPoints += amount;
    }

    public void increaseAttackDamage(int amount) {
        this.attackDamage += amount;
    }
    public void decreaseAttackDamage(int amount) {
        this.attackDamage -= amount;
    }
    
    public int getAttackDamage() {
    	return this.attackDamage;
    }
    
    
    @Override
    public void handleCommand(String command) {
    	// Utilisation de Scanner pour analyser la commande
    	Scanner scanner = new Scanner(command);

    	// Récupération du premier mot (commande)
    	if (scanner.hasNext()) {
    		String firstWord = scanner.next();

    		switch (firstWord) {
    		case "GO":

    			world.handleGoCommand(scanner);

    			break;
    		case "HELP":

    			world.displayHelp();
    			break;
    			
            case "CHECK":
                if (scanner.hasNext()) {
                    String argument = scanner.next();
                    world.checkWiseMan(argument);
                    
                } else {
                    System.out.println("Please specify the WiseMan to check.");
                }
                break;	
            case "THROW":
                if (scanner.hasNext()) {
                    String argument = scanner.next();
                    world.throwItem(argument);
                } else {
                    System.out.println("Please specify the item to throw.");
                }
                break;
    		case "LOOK":
    			if (scanner.hasNext()) {
    				String argument = scanner.next();
    				world.displaySpecific(argument);
    			} else {

    				world.displayCurrentPosition();
    			}
    			break;
    			// Ajoutez d'autres commandes selon vos besoins
    		case "TAKE":
    			world.handleTakeCommand(scanner);
    			break;
    		case "USE":
    			if (scanner.hasNext()) {

    				world.handleUseCommand(scanner);

    			} else {
    				System.out.println("ARG IS REQUIRED here");
    			}
    			break;
    		case "SAVE":
                if (scanner.hasNext()) {
                    String fileName = scanner.next();
                    world.saveGame(fileName);
                } else {
                    System.out.println("Please specify the file name to save.");
                }
                break;
            case "LOAD":
                if (scanner.hasNext()) {
                    String fileName = scanner.next();
                    world.loadGame(fileName);
                } else {
                    System.out.println("Please specify the file name to load.");
                }
                break;
            case "TIME":
                // Afficher le temps restant
                world.displayTimeRemaining();
                break;
        
    		case "QUIT":
    			System.out.println("Thank you for playing. Goodbye!");
    			System.exit(0);
    		default:
    			System.out.println("Command not recognized.");
    		}
    	}

    	// Fermer le scanner
    	scanner.close();
    }

}
