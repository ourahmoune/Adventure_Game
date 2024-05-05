package strangers;
import java.io.Serializable;

public  class Stranger implements Serializable {
	
	 protected String name;
	    
	    
	    
	    public Stranger(String name) {
	        this.name = name;
	    }
	    
	    public String getName(){
	        return this.name ;
	    }
	}


