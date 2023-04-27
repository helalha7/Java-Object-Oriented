package cards;

public class Card 
{
	private int num , suit ; 
	
	public Card(int num , int suit)
	{
		this.num = num ; 
		this.suit = suit ; 
	}
	
	public int getNum()
	{
		return num ; 
	}
	
	public int getSuit()
	{
		return suit ; 
	}
	
	public String toString()
	{
		if(suit==1)
			return num +"D";
		if(suit==2)
			return num +"H";
		if(suit==3)
			return num +"S";
		return num +"C";
	}
	
	public int compareTo(Card other)
	{
		if(num==other.num)
		{
			if(suit==other.suit)
			{
				return 0 ;
			}
			
			if(suit>other.suit)
			{
				return 1;
			}
			return -1 ; 
		}
		
		else
		{
			if(num>other.num)
				return 1 ;
			return -1;
		}
	}
}
