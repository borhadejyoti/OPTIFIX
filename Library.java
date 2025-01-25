package LibraryManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library extends Object implements Serializable{
	
	private List<Book> collection;
	
	public Library()
	{
		collection = new ArrayList<Book>();
	}
	public void addBook(Book book)
	{
		collection.add(book);
	}
	
	@Override
	public String toString() {
	 String total ="\n";
	 Iterator<Book> i = collection.iterator();
	 while(i.hasNext())
		{
		 Book b = (Book)i.next();
		 total = total +b.toString();
	 
	}
	return total;
}
	public Book getBookByName(String bookTitle) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
