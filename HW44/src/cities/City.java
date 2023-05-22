package cities;

public class City implements Comparable<City>
{
	private String name ;
	private Country country ; 
	private int population ;
	
	//normal constructor
	public City(String name , Country country , int population)
	{
		this.name = name ;
		this.country = country ;
		this.population = population ; 
		
	}
	
	//returns the city name 
	public String getName()
	{
		return name ;
	}
	
	//return the country of the city
	public Country getCountry()
	{
		return country ;
	}
	
	//returns the population count of the city
	public int getPopulation()
	{
		return population ;
	}
	
	//normal toString 
	public String toString()
	{
		return name + " (" + "of "+ country + ")" ;
	}

	//compareTo between to cities
	@Override
	public int compareTo(City o) 
	{
		if(this.getCountry().compareTo(o.getCountry()) == 0)
		{
			if(this.getName().compareTo(o.name) == 0)
				return 0 ;
			if(this.getName().compareTo(o.name) < 0)
				return -1 ;
			return 1 ;
		}
		if(this.getCountry().compareTo(o.getCountry()) < 0)
			return -1 ;
		return 1 ;
		
	}
	
	//checks if this city equals city o 
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof City))
			return false ;
		City c = (City) o ;
		if(c.getCountry().equals(this.getCountry()))
			if(c.getName().equals(this.getName()))
				return true ;
		return false ;
	}
	
}
