package strangers;

public class WiseMan extends Stranger{
	private String advice;
	public WiseMan(String s, String advice){
		super(s);
		this.advice=advice;
	}
	public String getAdvice() {
		return this.advice;
	}
	
    public void giveAdvice() {
        // Méthode pour donner des conseils au joueur
        System.out.println(name + " says: "+ getAdvice());
        // Ajoutez d'autres conseils ici
    }
}