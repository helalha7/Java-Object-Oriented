package graph;

public class Place
{
	private int x ;
	private int y ;
	
	//noraml constructor but if x or y not in range 0 - bound-1 its illegal argument.
	public Place(int x , int y , int bound)
	{
		if(x < 0 || x>bound-1 || y < 0 || y>bound-1)
			throw new IllegalArgumentException();
		this.x = x ;
		this.y = y ;
	}
	
	//returns x 
	public int getX()
	{
		return x ;
	}
	
	//return y 
	public int getY()
	{
		return y ;
	}

	//checks if this object is equal to another object 
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Place))
			return false ; 
		Place p = (Place) o ;
		if(p.x == this.x)
			if(p.y == this.y)
				return true ;
		return false ;
	}
	
	//calculates the HashCode of this Place .
	@Override
	public int hashCode()
	{
		return x*y ; 
	}
}
