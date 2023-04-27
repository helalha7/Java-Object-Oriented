package bank;
public class Account {
	private String name ; 
	private int shekels ; 
	
	public Account(String name) {
		this.name = name ;
		shekels = 0;
	}
	
	public int getShekels() {
		return shekels ;
	}
	
	public String getName() {
		return name ;
	} 
	
	public void add(int amount) {
		shekels = shekels + amount ; 
	}
	
	public String toString() {
	//	return name +" has " + shekels + " shekels" ;
		return String.format("%s has %d shekels",name , shekels) ;
	}
}
