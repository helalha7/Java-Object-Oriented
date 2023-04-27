package cities;

public class City
{
	private Road[] roads ;
	private int numRoads ; 
	private String name ; 
	
	public City(String name)
	{
		this.name=name ; 
		roads=new Road[10] ; 
	}
	
	public void connect(Road r)
	{
		numRoads++;
		roads[numRoads-1]=r ; 
	}
	
	public City nearestCity()
	{
		if(numRoads==0)
			return null;
		int minLength=roads[0].getLength();
		int minIndex = 0 ;
		for(int i = 0 ; i<numRoads ; i++)
		{
			if(roads[i].getLength()<minLength)
			{
				minLength=roads[i].getLength();
				minIndex=i ; 
			}
		}
		return roads[minIndex].getCity2();
	} 
	
	public String toString()
	{
		return name;
	}
	
}
