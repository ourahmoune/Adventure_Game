package Exits;
import Adventure_Game.Continents;
import java.util.Scanner;

public class CodeExit extends Exits {
	 private String accessCode;

	    public CodeExit(String name, Continents destination, String accessCode) {
	        super(name, destination);
	        this.accessCode = accessCode;
	    }

	    @Override
	    public boolean open() {
	        // Logique pour demander le code à l'utilisateur et vérifier s'il est correct
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the code: ");
	        String enteredCode = scanner.nextLine();
	        
	        // Compare le code saisi avec le code attendu
	        boolean isCodeCorrect = enteredCode.equals(accessCode);

	        if (isCodeCorrect) {
	            System.out.println("Code correct. You can now proceed.");
	        } else {
	            System.out.println("Incorrect code. You cannot proceed.");
	        }

	        return isCodeCorrect;
	    }

}
	    
