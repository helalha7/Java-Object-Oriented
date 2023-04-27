package tasks;

public class Tasks {
	
	private int[][] task ; 
	
	public Tasks(int num) 
	{
		task=new int[num][num] ; 
	}
	
	public boolean dependsOn(int task1 , int task2) 
	{
		//checks if the input is correct
		if((task1<0) || (task1>task.length) || (task2<0) || (task2>task.length))
			return false ;
		//make the relation between the two tasks using a matix
		task[task2][task1] = 1 ;
		return true ;
	}
	
	
	public int[] order() 
	{	 
		boolean all0 = true , isIn = false ;
		int i ,j , z ,index=0,loop = task.length , count=0;
		int [] sorted = new int[task.length] ; 
		
		//loop = task.length because we need maximum task.length times to do the while
		while(loop > 0)
		{
			for(i=0 ; i<task.length;i++)
			{
				//checks if there is no task before this task by checking the column if its all zeroes
				for(j=0 ; j<task.length ; j++) 
				{
					if(task[j][i] == 1)
					{
						all0=false ;
					}
				}
				//checks if the task is already in the sorted tasks list
				for(z=0;z<index;z++)
				{
					if(sorted[z]==i)
						isIn=true;
				}
				//if no task before this task and its not already in list add it to the list
				if(all0 && isIn==false)
				{
					sorted[index] = i ;
					index++;
					for(z=0;z<task.length ; z++)
					{
						task[i][z] = 0 ;
					}
				}
				all0=true ;
				isIn=false;
			}
			loop -- ;
		}
		//checks if there is no loops in relations between tasks
		for(z=0;z<index;z++)
		{
			if(sorted[z]==0)
				count++;
				
		}
		if(count == 1)
			return sorted;
		return null;
		
		
	}
}
