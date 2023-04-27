package library;

public class Library 
{
	private Book[] books ;
	
	public Library(int size)
	{
		books = new Book[size];
	}
	
	public void setBook(int bookNum , String title , Author auth)
	{
		Book temp = new Book(title , auth);
		books[bookNum]=temp;
	}
	
	public Book getBook(int bookNum)
	{
		return books[bookNum] ; 
	}
}
