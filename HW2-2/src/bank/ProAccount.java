package bank;

public class ProAccount extends Account 
{
	private int[] history = new int[100] ; 
	private int i = 0 ;
	public ProAccount(String name) 
	{
		super(name);
	}
	public void add(int amount) 
	{
		super.add(amount); 
		history[i] = super.getShekels() ;
		i++;
	}
	public String toString() {
		String his = " [" ;
		for(int j=0 ; j<i-1; j++)
		{
			his = his + history[j] + ",";
		}
		his = his + history[i-1] + "]" ;
		return super.toString() + his ;
	}
	
	public static void transfer(ProAccount from , ProAccount to , int amount) 
	{
		from.add(-amount); 
		to.add(amount);
	}
}
