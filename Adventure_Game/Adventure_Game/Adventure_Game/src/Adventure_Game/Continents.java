package Adventure_Game;
import java.util.ArrayList;

import java.util.List;
import Exits.*;
import Items.*;
import strangers.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import strangers.Monster;

public class Continents implements Serializable {
    private String name;
    private Map<String, Exits> exitsMap = new HashMap<>();
    private List<Items> itemsList = new ArrayList<>();
    private List<Stranger> strangersList = new ArrayList<>();
    
    
    public Continents(String name) {
        this.name = name;
        initItems();  // Appel de la méthode pour initialiser les items
        initStrangers(); // Appel de la méthode pour initialiser les Strangers
        //initExits();  // appel de la méthode pour initialiser les Exits
    }

    public void addExit(String exitName, Exits exit) {
        exitsMap.put(exitName, exit);
    }
    public Exits getExit(String exitName) {
        return exitsMap.get(exitName);
    }

    public void addItem(Items item) {
        itemsList.add(item);
    }

    public void addStranger(Stranger stranger) {
        strangersList.add(stranger);
    }

   
    public String getNam() {
    	return this.name;
    }
    
    public List<Items> getItemsList() {
        return itemsList;
    }

    public List<Stranger> getStrangersList() {
        return strangersList;
    }
    public Items getItem(String itemName) {
        for (Items item : itemsList) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Retourne null si l'item n'est pas trouvé
    }
    
    public Stranger getStranger(String strangerName) {
        for (Stranger stranger : strangersList) {
            if (stranger.getName().equalsIgnoreCase(strangerName)) {
                return stranger;
            }
        }
        return null; // 
    }

    public void removeItem(Items item) {
        itemsList.remove(item);
    }
    
    public Map<String, Exits> getExitsMap() {
        return exitsMap;
    }

    public List<String> getAvailableExits() {
        return new ArrayList<>(exitsMap.keySet());
    }
        
      public Monster getMonsterByName(String monsterName) {
            for (Stranger stranger : strangersList) {
                if (stranger instanceof Monster && stranger.getName().equalsIgnoreCase(monsterName)) {
                    return (Monster) stranger;
                }
            }
            return null; // Retourne null si aucun monstre avec le nom donné n'est trouvé
        }
    
    
                                         //init les items pour chaque continent
    private void initItems() {
        switch (name) {
            case "Africa":
            	addItem(new Food("AfricanFruit", 3,7));
            	addItem(new Weapon("SafariKnife", 2,15));
                addItem(new Food("SavannaBerries", 3, 3));
                break;
            case "Europe":
            	addItem(new Food("Baguette", 2,8));
            	addItem(new Key("KeyAntarctica", 1,"I fly without wings. I cry without eyes. Wherever I go, darkness follows me. What am I? this the code to access Asia"));
                addItem(new Food("CheeseWheel", 2, 5));
                addItem(new Weapon("KnightSword", 3,5));
                addItem(new Food("ChocolateTruffles", 2, 7));
                break;
            case "NorthAmerica":
                addItem(new Food("BisonJerky", 3, 30));
                addItem(new Weapon("Revolver", 4,10));
                addItem(new Food("MapleSyrupPancakes", 3, 30));
                addItem(new Weapon("Tomahawk", 4,10));
                
                break;
            case "SouthAmerica":
                addItem(new Food("AmazonFruit", 5, 1));

                break;
            case "Asia":
                addItem(new Food("Sushi", 6, 10));
                addItem(new Food("MangoLassi", 4, 8));
                addItem(new Key("FrontierGateKey", 3, "I am a three-digit number. My tens digit is five more than my ones digit. My hundreds digit is eight less than my tens digit. What number am I?"));
                break;
            case "Australia":
                addItem(new Food("KangarooJerky", 5, 10));
                addItem(new Food("PavlovaDessert", 3, 20));
                addItem(new Key("KeySouthAsia",18,"775"));
                break;
            case "Antarctica":
                addItem(new Food("IcebergLichen", 4, 20));
                addItem(new Weapon("FrostSpear", 2,5));
                addItem(new Food("SnowflakeChocolate", 4, 20));
                addItem(new Weapon("GlacialIceAxe", 2,5));
                break;
            case "Oceania":
                addItem(new Food("IcebergLichen", 2, 5));
                addItem(new Weapon("FrostSpear", 10,9));
                addItem(new Food("SnowflakeChocolate", 1, 3));
                addItem(new Weapon("GlacialIceAxe", 14,5));
                addItem(new Key("FrozenGateKey", 1, "864"));
                break;
            case "Atlantis":
                addItem(new Food("IcebergLichen", 2, 5));
                addItem(new Food("SnowflakeChocolate", 1, 3));
                addItem(new Key("KeyLemuriaAfrica", 1, "864"));
                break;
            case "Lemuria":
                addItem(new Food("LemurianFruit", 3, 60));
                addItem(new Weapon("CrystalScepter", 1,5));
                break;
            case "Mu":
                addItem(new Food("MuBreadfruit", 5, 40));
                addItem(new Key("KeyAvalon", 1, "4666"));
                break;
            case "Avalon":
                addItem(new Food("Ambrosia", 8, 16));
                addItem(new Weapon("Excalibur", 20,20));
                break;
                
            // a modifier
            default:
               
            	addItem(new Food("Generic Food", 2,7));
                addItem(new Weapon("Basic Sword", 5,10));
        }
    }
    
    private void initStrangers() {
        switch (name) {
            case "Africa":
            	addStranger(new WiseMan("ZuluElder", " hmmmmmmmmm."));
                addStranger(new WiseMan("SavannaShaman", "Stories say that the treasure is in Avalon."));
                addStranger(new WiseMan("NomadicStoryteller", "find a wiseMan in Europe he may help you to reach other destinations."));
                break;
            case "Europe":
            	addStranger(new WiseMan("Gandalf","The only way back to Africa is from Lemuria remember it well!"));
                addStranger(new WiseMan("CelticDruid", "go and check Gandlaf I'm tired today."));;
                addStranger(new WiseMan("RoyalScholar", "I am weightless and formless, dancing in the sky. I bring rain, shade, and whimsical shapes. What am I. it's a hint to access Asia later"));
                addStranger(new WiseMan("MysteriousBard", "The king of the jungle is a code for one door, but I forgot which one."));
            	addStranger(new Monster("Werewolf",70,100));
                break;
             
            case "SouthAmerica":
                addStranger(new WiseMan("AmazonianShaman", "Hope you grabbed that key in Australia."));
                addStranger(new WiseMan("AndeanVisionary", "Continue to Asia in order to access Atlantis to go back to lemuria."));
                addStranger(new WiseMan("CarnivalDancer", "Lemuria leads to Africa"));
                break;

            case "NorthAmerica":
                addStranger(new WiseMan("NativeSpiritGuide", "Connect with the land, and it will guide you, you are not far away from MU where the Avalonkey is hidden."));
                addStranger(new WiseMan("FrontierExplorer", "Beware of AboriginalDreamer; his words are but illusions. Many have fallen victim to his deceitful traps. Trust in your instincts, for the truth may be hidden behind a curtain of lies."));
                addStranger(new WiseMan("AppalachianStoryteller", " sleeping sleeping ."));
                break;

            case "Asia":
                addStranger(new WiseMan("HimalayanMonk", "the tens degit is 9."));
                addStranger(new WiseMan("JapaneseTeaMaster", "Harmony is found in the simplest of rituals."));
                addStranger(new WiseMan("SilkRoadNomad", "you are not far from  winning."));
                break;

            case "Antarctica":
                addStranger(new WiseMan("AntarcticExplorer", "Endurance and adaptability are the keys to survival, Enemies took this road once."));
                addStranger(new Monster("PolarBearGuardian", 60,290));
                addStranger(new Monster("BabyPolarBear",20,190));
                break;

            case "Australia":
                addStranger(new WiseMan("AboriginalDreamer", "Oceania is vibrant and full of secrets waiting to be uncovered. Ignore the doom-monger, and you may find treasures beyond your wildest dreams."));
                addStranger(new Monster("OutbackDingoSpirit", 45,140));
                addStranger(new WiseMan("BarrierReefGuardian", "Beware, adventurer! Oceania is a forsaken land, a deserted island where the journey might become your eternal home. Once you step into its depths, there's no turning back. Choose your path wisely."));     
                addStranger(new WiseMan("AussieStoryteller", "To go back to Africa there is only path from Lemuria ."));
                break;

            case "Oceania":
                addStranger(new WiseMan("PolynesianNavigator", "Stars guide not only the seas but destinies."));
                addStranger(new WiseMan("TribalElder", "Welcome to this desolate place, wanderer. In this city of shadows, remember this: not everything is as it seems. Deception lurks in the silence, and truth wears a disguise. Trust not every word, for in the echoes of the dead, illusions may arise. Distinguish reality from illusion, and you may find the way forward. Beware, for in this dead land, truths may be buried beneath layers of deception."));
                 addStranger(new WiseMan("OceanicSage", "Beware, weary traveler, for I once followed a Wiseman's counsel, and it led us into the clutches of this desolate land. The path he guided us on was a treacherous maze. Not all who offer guidance have noble intentions. Trust not every word, for deception may lurk behind wisdom's veil."));
                break;
            case "Atlantis":
                addStranger(new WiseMan("AtlanteanScholar", "words are but illusions."));
                addStranger(new WiseMan("AquaticVisionary", " Oceania is a desolate place."));
                addStranger(new WiseMan("LuminescentOracle", "here's the key the only key to access Africa from Lemuria."));
                break;
            case "Lemuria":
                addStranger(new WiseMan("LemurianMystic", "Atlantis is accessible from Asia."));
                addStranger(new WiseMan("CelestialHarmonist", "From here you can go back to your home but with a code of course that will be found in Atlantis."));
                addStranger(new WiseMan("DimensionalSeer", "I'm sleeping . .. . but I've an advice for you drop some weapons and grab they key that you will find in Australia"));
                break;
            case "Mu":
                addStranger(new WiseMan("MuianSage", "Brave adventurer, you have arrived in the land where the key to ancient treasures lies hidden. Your journey has just begun, and the challenges you face will test your mettle. May your spirit remain strong, and may the wisdom of the land guide you to the elusive key. Welcome, seeker of mysteries!"));
                addStranger(new Monster("TitanicColossus", 4000,4000));
                addStranger(new WiseMan("AncientAlchemist", "The most Dangerous monster ever is here."));
                addStranger(new WiseMan("CosmicTraveler", "No one has ever made it through this door, don't go through go back to Antartica and find an other way to Africa."));
                break;
            case "Avalon":
                addStranger(new WiseMan("AvalonianDruid", "Ah, traveler from distant lands, your path has led you to the legendary realm of Avalon, where the sacred treasure awaits those deemed worthy. In this mystical land, secrets are woven into the fabric of reality. Seek the heart of Avalon, and you shall find the key to unlock the treasures hidden for centuries. May your quest be blessed with wisdom and fortune, noble adventurer!."));
                addStranger(new WiseMan("FeyEnchantress", "Magic flows where intention goes."));
                addStranger(new WiseMan("ArthurianSage", "The sword reveals destiny; the heart forges it."));
                break;
                
            
            default:
               
        }
    }
    
    public void initExits() {
        World world = World.getWorld();
       List<Continents>  listcotinents = world.getContinentsList();
        
        switch (name) {
            case "Africa":
                addExit("North", new SimpleExit("Door to Europe",world.getContinent("Europe")));
                addExit("South", new CodeExit("Code Door to Avalon",world.getContinent("Avalon"),"4666"));
               
                break;
            case "Europe":
                addExit("West", new WarExit("Door guarded by a monster to North America", world.getContinent("NorthAmerica"), getMonsterByName("Werewolf")));

                break;
            case "NorthAmerica":
                addExit("South", new SimpleExit("Door to South America",world.getContinent("SouthAmerica")));
                addExit("North", new CodeExit("Code Door to Antarctica",world.getContinent("Antarctica"),"cloud"));
                

                break;
            case "SouthAmerica":
                addExit("East", new CodeExit("Code Door to Asia",world.getContinent("Asia"),"775"));
               

                break;
            case "Australia":
                addExit("Sud", new SimpleExit("Door to Oceania",world.getContinent("Oceania")));
                addExit("East", new WarExit("Door guarded by a monster to South America", world.getContinent("SouthAmerica"), getMonsterByName("OutbackDingoSpirit")));

                break;
            case "Asia":
                addExit("North", new CodeExit("Door to Europe",world.getContinent("Atlantis"),"194"));
               

                break;
            case "Antarctica":
                addExit("East", new WarExit("Door guarded by a monster to Mu", world.getContinent("Mu"), getMonsterByName("PolarBearGuardian")));
                addExit("West", new WarExit("Door guarded by a monster to Lemuria", world.getContinent("Lemuria"), getMonsterByName("BabyPolarBear")));
                break;
            case "Mu":
                addExit("West", new SimpleExit("Door to Antarctica", world.getContinent("Antarctica")));
                addExit("South", new WarExit("Door to Africa", world.getContinent("Africa"),getMonsterByName("TitanicColossus")));

                break;
            case "Atlantis":
                addExit("West", new SimpleExit("Door to Lemuria", world.getContinent("Lemuria")));
                break;
            case "Lemuria":
                addExit("East", new CodeExit("Door to Africa",world.getContinent("Africa"),"864"));
                addExit("South", new SimpleExit("Door to Australia",world.getContinent("Australia")));
                break;
            
            default:

        }
    }
}
