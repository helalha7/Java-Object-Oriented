package graph;
import java.util.* ;

public class Maze implements GraphInterface<Place>{
	
	//the maze as a matrix 
	private String[][] maze;
	
	//constructor for the maze 
	public Maze(int size, int startx, int starty, int endx, int endy) {
		maze = new String[size][size];
		try {
			maze[startx][starty] = "S";
			maze[endx][endy] = "E";
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
	}

	//adding a wall in the maze is : adding @ in the matrix
	public boolean addWall(int x, int y) {
		if (!(maze[x][y] == null))
			return false;
		try {
			maze[x][y] = "@";
			return true;
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
	}

	//to convert the matrix into a maze and to print it
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == null)
					b.append(".");
				else
					b.append(maze[i][j]);
			}
			b.append("\n");
		}
		return b.toString();
	}
	
	//this function checks if the maze is solvable : there is a way from the start to the end
	public boolean isSolvable() {
		//g to save the graph , l to save the vertices in the graph , because the parameters in the graph are private
		Graph<Place> g = new Graph<>();
		List<Place> l = new ArrayList<>();
		//start to save the start point , end to save the end point 
		Place p , start= new Place(0,0,1) , end = new Place(0,1,2) ;
		//adding the correct places to the graph as a vertices
		for(int i = 0 ; i<maze.length ; i++) { 
			for(int j = 0 ; j<maze.length ; j++) {
				if((maze[i][j] == null ) || (!(maze[i][j].equals("@")))) {
					p = new Place(i,j,maze.length) ;
					if((maze[i][j] != null ) && maze[i][j].equals("E"))
						end = p ;
					if((maze[i][j] != null ) && maze[i][j].equals("S"))
						start = p ;
					try {
						g.addVertex(p);
						l.add(p);
					} catch (GraphException e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		//adding the edges between the vertices of the graph
		for(Place p1 : l) {
			for(Place p2 : l) {
				//finding the right neighbour to vertex and add edge between them
				if( (( (p1.getX() == p2.getX()-1) && (p1.getY() == p2.getY()) ) || ((p1.getX() == p2.getX()) && (p1.getY() == p2.getY()-1)) && !(g.hasEdge(p1, p2)))) {
					try {
						g.addEdge(p1, p2);
					} catch (GraphException e) {
						e.printStackTrace();
					}
				}
			}
		}
		//checking if the the maze is solvable
		try {
			return g.connected(start, end);
		} catch (GraphException e) {
			e.printStackTrace();
		}
		return false ;
	}

	@Override
	public Collection<Place> neighbours(Place v) {
		List<Place> l = new ArrayList<>();
		
		try {
			if((maze[v.getX()-1][v.getY()]==null) || !(maze[v.getX()-1][v.getY()].equals("@")))
				l.add(new Place(v.getX()-1,v.getY(),maze.length)) ;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		try {
			if((maze[v.getX()+1][v.getY()]==null) || !(maze[v.getX()+1][v.getY()].equals("@")))
				l.add(new Place(v.getX()+1,v.getY(),maze.length)) ;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		try {
			if((maze[v.getX()][v.getY()-1]==null) || !(maze[v.getX()][v.getY()-1].equals("@")))
				l.add(new Place(v.getX(),v.getY()-1,maze.length)) ;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		try {
			if((maze[v.getX()][v.getY()+1]==null) || !(maze[v.getX()][v.getY()+1].equals("@")))
				l.add(new Place(v.getX(),v.getY()+1,maze.length)) ;
		}catch(ArrayIndexOutOfBoundsException e){}
		
		return l ;
	}

	
}
