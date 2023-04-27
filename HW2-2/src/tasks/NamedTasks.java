
package tasks;

public class NamedTasks extends Tasks {
	private String[] names ; 
	public NamedTasks(String[] names)
	{
		super(names.length); 
		this.names = names ; 
	}
	
	public boolean dependsOn(String task1, String task2) 
	{
		boolean ind1=false , ind2=false ;
		int index1=0 , index2=0 ;
		for(int i =0 ; i<names.length ; i++)
		{
			//finding the index of task1
			if(names[i].compareTo(task1) ==0)
			{
				index1 = i ; 
				ind1 =true ;
			}
			//finding the index of task2
			if(names[i].compareTo(task2) ==0)
			{
				index2 = i ; 
				ind2 = true;
			}
		}
		//checks if the input is correct
		if(ind1 == false || ind2 == false)
			return false ;
		super.dependsOn(index1, index2) ;
		return true ;
	}
	//the same as the nameOrder in Tasks
	public String[] nameOrder()
	{
		int a[] = super.order() ;
		String sorted[] = new String [names.length] ;
		for(int i = 0 ; i<names.length ; i++) 
		{
			sorted[i]=names[a[i]] ;
		}
		return sorted ;
	}

}
