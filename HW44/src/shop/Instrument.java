package shop;

public abstract class Instrument 
{
	private String company ; 
	private int price ; 
	private int serial ; 
	private static int ser = 0 ;
	
	public Instrument(String company , int price)
	{
		this.company = company ;
		this.price = price ;
		this.serial = ser ;
		ser ++ ;
	}
	
	public int getPrice() 
	{
		return price ;
	}
	
	public String getCompany()
	{
		return company ; 
	}
	
	public int getSerial()
	{
		return serial ;
	}
	
	public String toString()
	{
		if(this instanceof Piano)
		{
			Piano p = (Piano)this ;
			return "Piano(" + p.getOctaves() + " octaves) " + p.getCompany() + "(" + p.getSerial() + "), price = " +p.getPrice() ;  
		}
		Guitar g = (Guitar)this ;
		return "Guitar(" + g.getType() + ") " +  g.getCompany() + "(" + g.getSerial() + "), price = " +g.getPrice() ;
	}
}
