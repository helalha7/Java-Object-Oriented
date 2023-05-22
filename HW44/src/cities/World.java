package cities;
import java.util.* ;

public class World
{
	private Map<String , Country> countries ;
	
	//normal constructor  
	public World()
	{
		countries = new HashMap<>() ;
	}
	
	//creates new country by name and adds it to countries map
	public void addCountry(String name)
	{
		Country c = new Country(name) ;
		countries.put(name,c);
	}
	
	//creates new city and adds it to her country
	public void addCity(String name , String countryName , int population)
	{
		Country country = countries.get(countryName); 
		if(country == null)
			throw new IllegalArgumentException() ;
		City c = new City(name , country , population); 
		c.getCountry().addCity(c);
	}
	
	//returns the world population 
	public int population()
	{
		int sum = 0 ;
		for(Map.Entry<String, Country> c : countries.entrySet())
			sum += c.getValue().population() ;
		return sum ;
	}
	
	//returns a list of the cities that has a population count under "under" 
	public List<City> smallCities(int under) 
	{
		List<City> city = new ArrayList<>();
		List<Country> c = new ArrayList<>() ;
		for(Map.Entry<String,Country> co : countries.entrySet())
			c.add(co.getValue());
		Collections.sort(c);
		for(Country country : c)
		{
			city.addAll(country.smallCities(under));
		}
		return city ;
	}
	
	public String report()
	{
		StringBuilder b = new StringBuilder() ;
		for(Map.Entry<String, Country> c : countries.entrySet())
		{
			b.append(c.getValue().report());
			b.append("\n");
		}
		b.append("Total population is ");
		b.append(this.population());
		b.append("\n");
		return b.toString() ;
	}
	
}
