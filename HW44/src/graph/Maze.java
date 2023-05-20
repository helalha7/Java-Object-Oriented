package graph;

public class Maze 
{
	private String[][] maze ;
	
	public Maze(int size , int startx , int starty , int endx , int endy)
	{
		maze = new String[size][size];
		try {
			maze[startx][starty] = "S";
			maze[endx][endy] = "E" ; 
		}catch(IndexOutOfBoundsException e) {
			throw new IllegalArgumentException() ;
		}
	}
	
	public boolean addWall(int x , int y)
	{
		if(!(maze[x][y]==null))
			return false ;
		try {
			maze[x][y] = "@"; 
			return true ;
		}catch(IndexOutOfBoundsException e) {
			throw new IllegalArgumentException() ;
		}
	}
	
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		for(int i = 0; i<maze.length ; i++)
		{
			for(int j = 0; j<maze.length ; j++)
			{
				if(maze[i][j] == null)
					b.append(".");
				else
					b.append(maze[i][j]);
			}
			b.append("\n");
		}
		return b.toString() ;
	}
	
	public boolean isSolvable()
	{
		Graph<Place> maze = ();
	}
}
