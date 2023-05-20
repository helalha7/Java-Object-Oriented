package shop;

public enum Type
{
	ACOUSTIC , ELECTRIC , CLASSICAL; 
	
	@Override
	public String toString() 
	{
		if(this == Type.ACOUSTIC)
			return "Acoustic" ;
		if(this == Type.ELECTRIC)
			return "Electric" ; 
		return "Classical" ;
	}
}
