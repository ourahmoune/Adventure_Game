package Adventure_Game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.List;
import Player.Player;
import Items.*;
import strangers.*;
import Exits.*;
import Adventure_Game.*;
import DataGame.GameSave;
import DataGame.GameTimer;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;


public class World implements Serializable {
	private static World THEWORLD = new World();
	private final String NOM = "Earth";
	private List<Continents> continentsList = new ArrayList<>();
	private Player player;
	private GameTimer gameTimer=new GameTimer(1200);

	public static World getWorld() {
		return THEWORLD;
	}

	public String getNom() {
		return this.NOM;
	}
	public Player getPlayer() {
		return this.player;
	}
	public List<Continents> getContinentsList() {
		return continentsList;
	}
	
    public Continents getContinent(String ContinentName) {
        for (Continents continent : continentsList) {
            if (continent.getNam().equalsIgnoreCase(ContinentName)) {
                return continent ;
            }
        }
        return null;
    }

	public void addContinent(Continents continent) {
		continentsList.add(continent);
	}

	


	public void initGame() {
		// Initialisation des continents
		addContinent(new Continents("Africa")); 
		addContinent(new Continents("Europe")); 
		addContinent(new Continents("NorthAmerica")); 
		addContinent(new Continents("SouthAmerica"));
		addContinent(new Continents("Australia"));
		addContinent(new Continents("Antarctica")); 
		addContinent(new Continents("Asia"));
		addContinent(new Continents("Oceania")); 
		addContinent(new Continents("Atlantis"));
		addContinent(new Continents("Lemuria"));
		addContinent(new Continents("Mu"));
		addContinent(new Continents("Avalon"));
		
		player = new Player("Hero", 2000, 50, getWorld().getContinent("Africa"));

		for (Continents continent : continentsList) {
			continent.initExits();
		}
		this.introduction();

	}

	public void startGame() {
		// Interaction avec le joueur
	      
	        gameTimer.startTimer();
	        
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter a command: ");
			String command = scanner.nextLine();
			player.handleCommand(command);
			// Exemple de logique de jeu
			if (player.getContinents().getNam().equalsIgnoreCase("Avalon")) {
			    getWorld().winGame();
			}

		}
	}
	
    public void winGame() {
        System.out.println("Congratulations! You have successfully reached Avalon and unlocked the legendary treasure.");
        System.out.println("You are hailed as a hero, and your name will be remembered for generations to come.");
        
        System.exit(0); 
    }
    private void displayItemsByType(String category, List<Items> itemsList, Class<?> itemType) {
        System.out.println(category + " : ");
        for (Items item : itemsList) {
            if (itemType.isInstance(item)) {
                System.out.println("- " + item.getName());
            }
        }
    }
    
    public void displayCurrentPosition() {
		Continents currentContinent = player.getContinents();
		System.out.println("You are in " + currentContinent.getNam() + ". Here, you can find:");
		System.out.println("Items :");
		// Afficher les items
	    displayItemsByType("FOOD", currentContinent.getItemsList(), Food.class);
	    displayItemsByType("Weapons", currentContinent.getItemsList(), Weapon.class);
	    displayItemsByType("Keys", currentContinent.getItemsList(), Key.class);
	

		// Afficher les étrangers
		System.out.println("Strangers :");
		System.out.println("WiseMan :");
		for (Stranger stranger : currentContinent.getStrangersList()) {
			if(stranger instanceof WiseMan)
			System.out.println("- " + stranger.getName());
		}

		// Afficher les sorties
		System.out.println("Exits:");
		for (Map.Entry<String, Exits> exitEntry : currentContinent.getExitsMap().entrySet()) {
			System.out.println("- " + exitEntry.getKey() + ": " + exitEntry.getValue().getName()); 
			// + " to "		+ exitEntry.getValue().getDestination().getNam());
		}

	}

	public void displayHelp() {
		System.out.println("Available Commands:");
		System.out.println("- GO location: Move to the specified location.");
		System.out.println("- HELP: Display available commands.");
		System.out.println("- LOOK [arguments]: Display information about the current location / argument or about your BAG.");
		System.out.println("- CHECK:  to check a WiseMan in the current location.");
		System.out.println("- TAKE argument: Add the specified item to your inventory.");
		System.out.println("- USE arg1 [arg2]: Use the specified object.");
		System.out.println("- QUIT: Quit the game.");
		System.out.println("- SAVE: to save the game.");
		System.out.println("- LOAD: to load the game.");
		System.out.println("- THROW [argument]: to throw an item in the current position.");
	}

	public void introduction() {
		System.out.println("Welcome to " + getNom() + " Hero! An epic adventure awaits you.");
		System.out.println("You find yourself in the land of " + player.getContinents().getNam()
				+ ", a place filled with mysteries,");
		System.out.println("strange creatures, and unexplored continents.");
		System.out.println("As a brave hero, it is your destiny to navigate through different regions,");
		System.out.println("encounter fascinating strangers, collect powerful items, and unlock hidden paths.");
		System.out.println("Your health points are at " + player.getHealthPoints()
				+ " .");
		System.out.println("The choices you make will shape your journey and determine your fate.");
		System.out.println("Are you ready to embark on this thrilling adventure? Let the quest begin!");
		System.out.println();
		System.out.println("Twenty years ago, a time of turmoil swept across the African continent.");
		System.out.println("Before gaining independence, enemies hid a sacred treasure behind a secret door, ");
		System.out.println("but they took with them the only key that could unlock that door.");
		System.out.println("The treasure, an ancient relic with mystical powers, is needed to save");
		System.out.println("someone very dear to your heart. You now embark on a quest");
		System.out.println("across the world to find this lost key and unlock the treasure door.");
		System.out.println("Your adventure begins here, in Africa, where it all started. Good luck, explorer!");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println("Be careful, and pay attention to details.");
		System.out.println("Commands must be entered exactly as displayed. Case and spacing matter.");
		System.out.println(
				"For example, if the screen displays 'SafariKnife', enter it as 'SafariKnife', not 'Safari Knife' or 'safari knife'.");
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		
	}


	// Méthode pour gérer la commande TAKE
	
	public void handleTakeCommand(Scanner scanner) {
		if (scanner.hasNext()) {
			String itemName = scanner.next();

			// Recherche de l'item dans la position actuelle du joueur
			Items item = player.getContinents().getItem(itemName);

			if (item != null) {
				// Vérification si l'item peut être ajouté au sac du joueur
				if (player.getBag().canAddItem(item)) {
					// Ajout de l'item au sac du joueur
					player.getBag().addItem(item);
					player.getBag().setCurrent(item.getVolume()+player.getBag().getCurrent());
					// Suppression de l'item de la position actuelle du joueur
					player.getContinents().removeItem(item);

					System.out.println("You took " + item.getName() + ".");
				} else {
					System.out.println("Your bag is full. Cannot take " + item.getName() + ".");
				}
			} else {
				System.out.println("Item not found.");
			}
		} else {
			System.out.println("Please specify an item to take.");
		}
	}
                   //Look command
	public void displaySpecific(String argument) {
	    // Logique pour afficher quelque chose de spécifique en fonction de l'argument
	    switch (argument.toUpperCase()) {
	        case "BAG":
	            // Afficher le contenu du sac
	            System.out.println("In your bag you have a card where your current informations "
	                    + "are mentioned, so you are in " + player.getContinents().getNam() + ". Your health is "
	                    + player.getHealthPoints());
	            List<String> ListAdvice=player.getAdviceList();
	            System.out.println("The advice gatherred so far are : " ); 
	            System.out.println("----------------- " ); 
	            
	            player.getAdvice(ListAdvice);
	            player.getBag().displayContents();
	            break;
	        default:
	            // Recherche de l'objet correspondant à l'argument dans le sac
	            Items item = player.getContinents().getItem(argument);
	            if (item != null) {
	                // Afficher des informations spécifiques selon le type de l'objet
	                if (item instanceof Food) {
	                    Food foodItem = (Food) item;
	                    System.out.println("This is a food item. Health bonus: " + foodItem.getHealthPoints());
	                } else if (item instanceof Weapon) {
	                    Weapon weaponItem = (Weapon) item;
	                    System.out.println("This is a weapon. Damage points: " + weaponItem.getAttackDamage());
	                } else if (item instanceof Key) { 
	                	Key keyItem=(Key) item;
	                    System.out.println("This is a key in order to use it must grab it first.");
	                }
	            } else {
	            	Stranger stranger=player.getContinents().getStranger(argument);
	            	if(stranger !=null) {
	            	if(stranger instanceof Monster) {
	            		Monster monsterStranger=(Monster)stranger;
	            		System.out.println("This is a monster. Health bonus "+ monsterStranger.getHealthPoints());
	            	} else if (stranger instanceof WiseMan) {
	            		System.out.println("This is a Wise man you need to check him ");
	            	} 
	            } else {
		                System.out.println("Item or stranger doesn't exit in your place or make sure you write it as it is displayed .");
	            }
	            break;
	    
	    }
	    }
	}

           // use command
	public void handleUseCommand(Scanner scanner) {
		if (scanner.hasNext()) {
			String itemName = scanner.next();
			Items item = player.getBag().getItem(itemName);

			if (item != null) {
				// Utilise l'objet et met à jour les attributs du joueur en conséquence
				useItem(item, player);
				if (item instanceof Food ) {

				// Retire l'objet du bag puisqu'il a été utilisé
				player.getBag().removeItem(item);
				}
			} else {
				System.out.println("Item not found in your bag.");
			}
		} else {
			System.out.println("Usage: USE <item>");
		}
	}

	//use of item fct
	private void useItem(Items item, Player player) {
		if (item instanceof Food) {
			player.getBag().setCurrent(player.getBag().getCurrent()-item.getVolume());
			player.increaseHealth(((Food) item).getHealthPoints());
			System.out.println("You used " + item.getName() + ". Health increased to "+player.getHealthPoints());
		} else if (item instanceof Weapon) {
			// player.increaseAttackDamage(((Weapon) item).getAttackDamage());
			System.out.println("You used " + item.getName() + ". Attack damage increased to "+player.getAttackDamage());
		} else if (item instanceof Key) {
			System.out.println("You used " + item.getName() + ". the code is : " +
			 ((Key) item).getAccessCode());
		}

	}

	// Méthode pour gérer la commande GO
	public void handleGoCommand(Scanner scanner) {
	    if (scanner.hasNext()) {
	        String exitDirection = scanner.next();

	        if (exitDirection != null && player.getContinents().getAvailableExits().contains(exitDirection)) {
	            Exits exit = player.getContinents().getExit(exitDirection);

	            if (exit instanceof CodeExit) {
	                // S'il s'agit d'un CodeExit, demander le code
	                boolean isCodeCorrect = ((CodeExit) exit).open();

	                if (isCodeCorrect) {
	                    // Si le code est correct, déplacer le joueur
	                    Continents destination = exit.getDestination();
	                    player.moveTo(destination);
	                    System.out.println("You moved to " + destination.getNam() + ".");
	                }
	            } else if(exit instanceof WarExit) {
	            	boolean isMonsterDead=((WarExit)exit).open();
	            	
	            	if(isMonsterDead) { 
	                    Continents destination = exit.getDestination();
	                    player.moveTo(destination);
	                    System.out.println("You moved to " + destination.getNam() + ".");	
	            	}
	            	
	            } else {
	                // Pour les autres types d'Exits (SimpleExit, etc.), déplacer le joueur
	                Continents destination = exit.getDestination();
	                player.moveTo(destination);
	                System.out.println("You moved to " + destination.getNam() + ".");
	            }
	        } else {
	            System.out.println("Invalid direction in this continent.");
	        }
	    } else {
	        System.out.println("Please specify a direction to take.");
	    }
	}
	
	
	public void checkWiseMan(String wiseManName) {
	    WiseMan wiseMan = findWiseMan(wiseManName);
	    if (wiseMan != null) {
	        wiseMan.giveAdvice();
	        player.addAdvice(wiseMan.getAdvice());
	    } else {
	        System.out.println("No WiseMan found with the name: " + wiseManName);
	    }
	}	
	
	// look for a wiseMan in a strangerList
    public WiseMan findWiseMan(String wiseManName) {
        for (Stranger stranger : player.getContinents().getStrangersList()) {
            if (stranger instanceof WiseMan && stranger.getName().equalsIgnoreCase(wiseManName)) {
                return (WiseMan) stranger;
            }
        }
        return null;
    }
    
    public void throwItem(String itemName) {

			Items item = player.getBag().getItem(itemName);

			if (item != null && item instanceof Weapon) {
					player.getContinents().addItem(item);
					player.getBag().removeItem(item);
					player.decreaseAttackDamage(((Weapon)item).getAttackDamage());
					player.getBag().setCurrent((item.getVolume()+player.getBag().getCurrent()));

					System.out.println("You throw " + item.getName() + ".");
				
			} else if (item != null) {
				System.out.println("You throw " + item.getName() + ".");
				player.getContinents().addItem(item);
				player.getBag().removeItem(item);
				player.getBag().setCurrent((player.getBag().getCurrent()-item.getVolume()));
			}
			else {
				System.out.println("Item not found.");
			}
		
	}
    
    
    public void saveGame(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            GameSave gameSave = new GameSave(continentsList, player);
            oos.writeObject(gameSave);
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadGame(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            // Charger l'objet sérialisé (GameSave au lieu de World)
            GameSave loadedGameSave = (GameSave) objectInputStream.readObject();

            // Remplacer le contenu actuel du monde par celui chargé
            this.continentsList = loadedGameSave.getContinentsList();
    		for (Continents continent : continentsList) {
    			continent.initExits();
    		}
            
            this.player = loadedGameSave.getPlayer();

            System.out.println("Game loaded successfully.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading the game.");
        }
    }
    
    
    public void displayTimeRemaining() {

        long timeRemaining = gameTimer.getTimeRemaining();

        System.out.println("Time remaining: " + timeRemaining + " seconds.");
    }


	
	



}
