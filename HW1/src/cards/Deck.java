package cards;

public class Deck 
{
	private Card[] cards ; 
	private int numCards;
	
	public	Deck(int num)
	{
		numCards= 4 * (num) ; 
		cards=new Card[16] ; 
		for(int i=0 ;i<num;i++)
		{	
			for(int j = 0 ; j<4 ; j++)
			{
				Card temp = new Card(i,j);
				cards[j+(4*i)]= temp ; 
			}
		}
	}
	
	public Deck(Deck from, int num)
	{	
		int lastIndex = from.numCards-1;
		int i = 0 ;
		if(num<=from.numCards)
		{
			cards=new Card[num];
		}
		else
		{
			cards=new Card[from.numCards];
		}
		while(num!=0 && lastIndex!=-1)
		{
			cards[i]=from.takeOne();
			i++;
			lastIndex--;
			num--;
			numCards++;
		}
	}

	public Deck(Deck first, Deck second) 
	{
		int firstLength = first.numCards ; 
		int secondLength = second.numCards ; 
		numCards = firstLength + secondLength ; 
		cards=new Card[numCards]; 
		int i = 0 ; 
		while(firstLength!=0 && secondLength!=0)
		{
			cards[i]=first.takeOne() ;
			firstLength -- ;
			cards[i+1]=second.takeOne() ;
			secondLength -- ;
			i=i+2;
		}
		while(firstLength!=0)
		{
			cards[i]=first.takeOne();
			i++;
			firstLength--;
		}
		while(secondLength!=0)
		{
			cards[i]=second.takeOne();
			i++;
			secondLength--;
		}
	}
	
	public int getNumCards()
	{
		return numCards ; 
	}
	
	public Card takeOne()
	{	
		Card temp = cards[numCards-1] ;
		cards[numCards-1] = null ; 
		numCards -- ;
		return temp ; 
	}

	public String toString() 
	{
		if(numCards==0)
		{
			return "[]";
		}
		String temp = "[" ; 
		for(int i=0 ; i<numCards-1 ; i++)
		{
			temp = temp + cards[i].toString() + ", " ;
		}
		temp = temp + cards[numCards-1].toString() + "]" ; 
		return temp ;
	}
	
	public void sort()
	{	
		Card temp;
		int length=numCards;
		for(int i=0 ; i<length-1 ; i++)
		{
			for(int j=0 ; j<length-(i+1); j++)
			{
				if(cards[j].compareTo(cards[j+1])==1)
				{
					temp=cards[j];
					cards[j]=cards[j+1];
					cards[j+1]=temp;
				}
			}
		}
	}
}
