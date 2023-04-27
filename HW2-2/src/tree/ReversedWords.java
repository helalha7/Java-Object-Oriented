package tree;
import java.util.Scanner; 
public class ReversedWords {
	public static int checkReversed () {
		int count = 0 ;
		Node temp = new Node() ; 
		Scanner s ;
		String input , reversed="";
		s = new Scanner(System.in) ;
		while(s.hasNext()) {
			input=s.next();
			if(input.compareTo("X") == 0)
				break ;
			//reverses the input : 
			for(int i =0 ; i<input.length() ; i++) 
				reversed = reversed + input.charAt(input.length()-1-i) ;
			//checks if the reversed is not in the tree if not add it to the tree :
			if(temp.num(reversed) > 0) { 
				count ++ ;
			}
			temp.add(input);
			reversed = "" ; 
		}
		s.close() ;  
		return count ; 
	}
}
