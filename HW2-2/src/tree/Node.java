package tree;
public class Node {
	private int count = 0  ; 
	private Node[] children = new Node[26] ; 
	
	public int num(String s) {
		Node p = this ;
		int i = 0;
		while(i < s.length())
		{
			if(p.children[s.charAt(i) - 'a'] == null) 
				return 0; 
			//moving to the next char
			p = p.children[s.charAt(i) - 'a'] ;
			i ++ ; 
		}
		return p.count ; 
	}
	
	public void add(String s) {
		int i = 0 ;
		Node p = this ;
		Node n ; 
		while (i < s.length()) {
			// creating a new node for the first time appeard string
			if(p.children[s.charAt(i) - 'a'] == null) {
				n = new Node() ; 
				p.children[s.charAt(i) - 'a'] = n ; 
				p = n ;
				i++;
			}
			else {
				//moving to the next char if there is like it already
				p = p.children[s.charAt(i) - 'a'] ;
				i++ ;
			}
		}
		p.count ++ ;
	}
}
