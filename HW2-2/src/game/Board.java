package game;

public class Board 
{
	protected Player[][] board ;
	protected int n ,m ;
	public Board(int n , int m) 
	{
		this.n = n ;
		this.m = m ;
		board = new Player[n][m] ;
	}
	protected boolean set(int i , int j , Player p) 
	{
		if(board[i][j] != null) 
			return false ;
		board[i][j] = p ;
		return true ;
	}
	public boolean isEmpty(int i , int j) 
	{
		if(board[i][j] == null) 
			return true ;
		return false ;
	}
	public Player get(int i , int j)
	{
		return board[i][j] ; 
	}
	public boolean isFull() 
	{
		for(int i = 0 ; i < n ; i++) 
		{
			for(int j =0 ; j < m ; j++) 
			{
				if(isEmpty(i,j)==true) 
					return false ;
			}
		}
		return true ;
	}
	public String toString()
	{
		String str = "" ;
		for(int i = 0 ; i < n ; i ++) 
		{
			for(int j = 0 ; j < m ;j++) 
			{
				str = str + "" ;
				if(board[i][j]==null) 
					str=str+ "." ;
				else
					str = str + board[i][j].getMark() ;
			} 
			str = str + "\n" ;
		} 
		return str ;
	}
	protected int maxLineContaining(int i , int j)
	{
		int len=0, lenCol = 0 , lenRow=0 , lenDia1 = 0 , lenDia2 = 0; 
		Player temp = board[i][j];  
		int x = i , y = j ; 
		//col -> | :  
		while(x>=0 && board[x][y] == temp) 
		{
			x-- ; 
		}
		x ++;
		while(x < board.length && board[x][y] == temp)
		{
			lenCol ++ ;
			x++ ; 
		}
		x = i ;
		//row -> - : 
		while(y >= 0 && board[x][y]==temp) 
		{
			y-- ;
		}
		y++;
		while(y<board[x].length && board[x][y] == temp)
		{
			lenRow++;
			y++ ;
		}
		y = j ;
		//dia1 -> / :
		while(x >= 0  && y < board[x].length && board[x][y] == temp)
		{
			y++ ;
			x-- ;
		}
		y--;
		x++;
		while(x < board.length && y >= 0 && board[x][y] == temp )
		{
			y--;
			x++;
			lenDia1 ++;
		}
		x=i ; 
		y=j ;
		//dia2 -> \ : 
		while(x >= 0 && y>=0 && board[x][y] == temp)
		{
			x--;
			y--;
		}
		x++;
		y++;
		while(x <board.length && y<board[x].length && board[x][y] == temp) 
		{
			x++;
			y++;
			lenDia2++;
		}
		//maxLen : 
		if(lenCol > len)
			len = lenCol ;
		if(lenRow > len)
			len = lenRow ;
		if(lenDia1 > len)
			len = lenDia1 ;
		if(lenDia2 > len) 
			len = lenDia2 ;
		return len ; 
			
		
	}
}
