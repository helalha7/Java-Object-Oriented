package shop;
import java.util.List ; 
import java.util.ArrayList ;

public class Shop 
{
	private List<Instrument> instrument ; 
	
	public Shop()
	{
		instrument = new ArrayList<Instrument>() ;
	}
	
	public void add(Instrument i) 
	{
		instrument.add(i) ;
	}
	
	public Instrument get(int serial)
	{
		for(Instrument i : instrument)
		{
			if(i.getSerial() == serial)
				return i ;
		}
		return null ;
	}
	
	public List<Integer> allSerials()
	{	
		List<Integer> l = new ArrayList<>() ;
		for(Instrument i : instrument)
			l.add(i.getSerial()) ;
		return l ;
			
	}
	
	public List<Integer> guitarsOfType(Type t)
	{
		List<Integer> l = new ArrayList<>() ;
		Guitar g ;
		for(Instrument i : instrument)
		{
			if(i instanceof Guitar)
			{
				g = (Guitar)i;
				if(g.getType().equals(t))
					l.add(g.getSerial()) ;
			}
		}
		return l ;
	}
	
	public void sell(int serial) throws MusicShopException
	{
		int cont = 0 ;
		int index = 0;
		boolean flag = false ;
		for(Instrument i : instrument)
		{
			if(i instanceof Guitar)
			{
				cont ++ ; 
			}
			if(i.getSerial() == serial)
			{
				index = instrument.indexOf(i) ;
				flag = true ;
			}
		}
		if(!flag)
			throw new MusicShopException("its not in the shop .") ;
		if(cont <= 1 && instrument.get(index) instanceof Guitar )
			throw new MusicShopException("there is <= 1 guitars in the shop.") ;
		instrument.remove(index) ;
	}
	
	public int sellAll(int[] serials)
	{	
		int cont = 0 ;
		for(int i = 0 ; i<serials.length ; i++)
			{	try {
					sell(serials[i]) ;
				}catch(MusicShopException e) { cont++ ;}
			}
		return cont ;
		
	}
	
}
