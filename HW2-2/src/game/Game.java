package game;
import java.util.Scanner;

public class Game extends Board {
	protected Player[] players = new Player[2];
	protected Scanner s = new Scanner(System.in); 
	
	public Game(int n , int m , Player p1 , Player p2) 
	{
		super(n,m) ; 
		int i = 0 ;
		while(players[i] != null) 
			i++;
		players[i] = p1 ;
		players[i+1] = p2 ;
		
	}
	
	
	protected boolean doesWin(int i ,int j)
	{
		if(i == 0 && j == 0)
			return true ;
		return false ;
	}
	
	protected boolean onePlay(Player p)
	{
		System.out.format("%s , please enter x and y :", p) ; 
		int x = s.nextInt() ; 
		int y = s.nextInt() ; 
		while(isEmpty(x,y) == false)
		{
			System.out.println("There is a piece there already... ");
			System.out.format("%s , please enter x and y :", p) ; 
			x = s.nextInt() ; 
			y = s.nextInt() ; 
		}
		board[x][y] = p ;
		System.out.print(super.toString());
		if(doesWin(x,y))
		{
			System.out.format("%s Won ! %n",p);
			return true ;
		}
		return false ;
	}
	
	public Player play()
	{
		int x = 0 ; 
		while(x == 0)
		{
			if(isFull()== true)
				return null ;
			if(onePlay(players[0])) 
				return players[0] ;
			if(isFull()== true)
				return null ;
			if(onePlay(players[1])) 
				return players[1] ;
		}
		return null; 
	}
	
}
