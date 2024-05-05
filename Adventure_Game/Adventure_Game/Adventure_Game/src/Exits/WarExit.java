package Exits;
import Adventure_Game.Continents;
import strangers.Monster;
import java.util.Scanner;
import Adventure_Game.World;
import Player.Player;
public class WarExit extends Exits {
	private Monster guardingMonster;
    private World world=World.getWorld();
	private Player player=world.getPlayer();

    public WarExit(String name, Continents destination, Monster guardingMonster) {
        super(name, destination);
        this.guardingMonster = guardingMonster;
    }
    
    public Monster getGuardingMonster() {
    	return this.guardingMonster;
    }

    @Override
    public boolean open() {
    	if(guardingMonster.getHealthPoints()<=0) {
    		System.out.println("A fierce monster that guards the exit was found dead .");
    		return true;
    		
    	} else {
        System.out.println("A fierce monster guards the exit.");
        System.out.println("Monster details: " + guardingMonster.getName() + " | Health: " + guardingMonster.getHealthPoints());
        System.out.println("Do you want to attack the monster? (yes/no)");

        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            return attackMonster(guardingMonster, player);
        } else {
            System.out.println("You decide not to attack the monster. The exit remains closed.");
            return false;
        }
    	}
    }
    
    public boolean attackMonster(Monster guardingMonster, Player player) {
    	    guardingMonster.setHealthPoints(guardingMonster.getHealthPoints() - player.getAttackDamage());
    	    player.setHealthPoints(player.getHealthPoints() - guardingMonster.getAttackDamage());
        
    	System.out.println("You Attacked the Monster and he Attacked you as well your current HealthPoints is  "+player.getHealthPoints());
    	if(guardingMonster.getHealthPoints()>=0) {
    	System.out.println("The monster's health Points is  "+guardingMonster.getHealthPoints());}
    	else { System.out.println("The monster's health Points is 0  ");}
        if(player.getHealthPoints()<=0) { 
        	System.out.println("You are defeated you lost Thanks for playing try next time"); 
        	System.exit(0);
         }
        else if(guardingMonster.getHealthPoints()<=0) { 
        	return true;
        }
         return false;  
     }
    

}
