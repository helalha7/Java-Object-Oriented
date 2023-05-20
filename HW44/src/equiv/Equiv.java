package equiv;

import java.util.Set ;
import java.util.HashSet ;
import java.util.Arrays;

public class Equiv<E> 
{      	
	private Set<E>[] l ;
	
	@SuppressWarnings("unchecked")
	public Equiv()
	{
		l = (Set<E>[]) new Set[1] ; 
	}
	
	public void add(E e1 , E e2)
	{
		boolean flag1 = false ,flag2=false ;
		int index = 0  ;
		
		//if e1 equals e2 no need to do anything
		if(!(e1.equals(e2)))
		{
			//if there is no equiv classes
			if(l[0] == null)
			{
				l[0]= new HashSet<>(10);
				l[0].add(e1);
				l[0].add(e2);
			}
			//if there are equiv classes
			else
			{
				//checking if they already in an equiv classes
				for(int i = 0; i<l.length ; i++)
				{
					if(l[i].contains(e1))
					{
						flag1 = true ;
						index = i;
					}
					if(l[i].contains(e2))
					{
						flag2=true ;
						index = i;
					}
				}
				//just if they not already in equiv classes we can do the function add
				if(flag1 && flag2)
					System.out.println("the two are already in equiv classes");
				//if not the two are in equiv classes
				else
				{
					//if one of them in equiv class add the other to it
					if(flag1)
						l[index].add(e2);
					if(flag2)
						l[index].add(e1);
					//if non of them is in equiv class open new equiv class for them
					if(flag1 == false && flag2 == false)
					{
						l=Arrays.copyOf(l,l.length+1);
						l[l.length-1]= new HashSet<>(10);
						l[l.length-1].add(e1);
						l[l.length-1].add(e2);
					}
				}
			}
		}
	}
	
	public boolean are(E e1 , E e2)
	{
		//they are the some then they are in the same equiv class
		if(e1.equals(e2))
			return true ;
		//checks if e1 and e2 in the same equiv class by checking all the equv classes we have
		for(int i = 0 ; i<l.length ; i++)
		{
			if(l[i].contains(e1) && l[i].contains(e2))
			{
				return true ;
			}
		}
		return false ;
	}
}
