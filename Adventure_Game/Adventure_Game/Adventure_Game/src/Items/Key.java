package Items;

public class Key extends Items {
	private String AccessCode;
    public Key(String name , int volume, String AccessCode) {
        super(name,volume);
        this.AccessCode=AccessCode;
    }
    
    public String getAccessCode() {
    	return this.AccessCode;
    }
}
