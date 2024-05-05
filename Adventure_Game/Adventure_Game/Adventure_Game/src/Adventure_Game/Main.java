package Adventure_Game;


public class Main {
 public static void main(String[] args) {
     // Créez une instance de la classe World
     World gameWorld = World.getWorld();

     // Appelez la méthode initGame pour initialiser le jeu
     gameWorld.initGame();
     gameWorld.startGame();
     // Vous pouvez maintenant commencer à interagir avec le jeu

 
 }
}
