package root;
import java.lang.Math;
public class Rooter 
{
	private double precision ; 
	
	public Rooter(double precision)
	{
		this.precision = precision ;
	}
	
	public void setPrecision(double precision)
	{
		this.precision=precision ; 
	}
	
	public double sqrt(double x)
	{
		double one = x/2 ; 
		double two = x/one ; 
		if(one==two)
			return one ;
		while(Math.abs(one - two) >= precision)
		{
			two=x/one;
			one = (one + two)/2 ; 
		}
		return one ; 
	}
}
