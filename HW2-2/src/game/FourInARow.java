package game;

public class FourInARow extends Game 
{
	public FourInARow(String player1, String player2) 
	{
		super(6,7,new Player(player1 , 'W'),new Player(player2 , 'B')) ;
	}
	
	@Override 
	protected boolean doesWin(int i, int j)
	{
		if(maxLineContaining(i, j) == 4) 
			return true ;
		return false ;
	}
	@Override
	protected boolean onePlay(Player p)
	{
		int i = board.length-1 , j;
		System.out.format("%s , please enter column :" , p) ;
		j = s.nextInt() ; 
		while(board[0][j]!=null)
		{
			System.out.format("the column is full %n%s , please enter column :" , p) ;
			j = s.nextInt() ; 
		}
		while(i > 0 && board[i][j]!=null)
		{
			i-- ; 
		}
		board[i][j] = p ;
		System.out.print(super.toString());
		if(doesWin(i,j)) 
		{
			System.out.format("%s Won !" , p);
			return true ;
		}
		return false ;
	}

	
}
