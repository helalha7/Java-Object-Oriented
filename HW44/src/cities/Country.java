package cities;
import java.util.*;

public class Country implements Comparable<Country>
{
	private Set<City> cities ;
	private String name ;
	
	//normal constructor 
	public Country(String name)
	{
		this.name = name ;
		cities = new HashSet<>();
	}
	
	//adds a city to this country
	public void addCity(City city)
	{
		boolean flag = false ;
		
		if(!(city.getCountry().equals(this)))
			throw new IllegalArgumentException();
		for(City c : cities)
		{
			if(c.getName().equals(city.getName()))
				flag = true ;
		}
		if(!flag)
			cities.add(city);
	}
	
	//return the population of the country by summing the population for every city in the country
	public int population()
	{
		int sum = 0 ;
		for(City c : cities)
		{
			sum += c.getPopulation();
		}
		return sum ;
	}
	
	//return the country name 
	public String toString()
	{
		return name ;
	}
	
	//returns a list of cities that haves population count under "under"
	public List<City> smallCities(int under)
	{
		List<City> l = new ArrayList<>();
		for(City c : cities)
		{
			if(c.getPopulation() < under)
				l.add(c);
		}
		Collections.sort(l);
		return l ; 
	}

	//returns the country name and the population count and every city with its population count
	public String report()
	{
		StringBuilder b = new StringBuilder() ; 
		b.append(this.name) ;
		b.append("(");
		b.append(this.population());
		b.append(") : ");
		for(City c : cities)
		{
			b.append(c.getName());
			b.append("(");
			b.append(c.getPopulation()) ;
			b.append("), ");
		}
		b.deleteCharAt(b.length()-1);
		b.deleteCharAt(b.length()-1);
		return b.toString() ;
	}
	
	//compare to other country by name 
	@Override
	public int compareTo(Country o) 
	{
		if(this.name.compareTo(o.name) < 0 )
			return -1 ;
		if(this.name.compareTo(o.name) > 0 )
			return 1 ;
		return 0 ;
	}
	
	//checks if equals to other country by name
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Country))
			return false ;
		Country c = (Country) o ;
		if(this.name.equals(c.name))
			return true ;
		return false ;
	}
}
