package LibraryManagementSystem;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.View;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class MainSystem {

	static String fileName=null;
	static Library lib=new Library();
	static Scanner in=new Scanner(System.in);
	static Boolean running =true;
	public static void main(String args[]) throws ClassNotFoundException, FileNotFoundException
	{
		while(running)
		{
			System.out.println("\n Enter 1 for a load a Library"
		 +"\n Enter 2 for save and quit "
		+"\n Enter 3 for list all Books in Library "
		 +"\n Enter 4 for add book to library");
		//+"\n Enter 5 for import and save video/Image/music file to book"
		// +"\n Enter 6 for load and export v is file from book and play it");
			
			int answer =in.nextInt();
			switch(answer)
			{
			case 0:
				System.out.println("Enter the file name to load");
				fileName = in.next();
				LoadScript(in.next());
				break;
				
			case 1:
				saveAndQuit();
				break;
				
			case 2:
				System.out.println(lib.toString());
				break;
				
			case 3:
				addBook();
				break;
				
			case 4:
				importOpenAndSave();
				break;
				
			case 5:
				loadOpenAndExport();
				break;
			}
		}
		System.exit(0);
	}
	private static void loadOpenAndExport() throws FileNotFoundException {
		// TODO Auto-generated method stub
		String vimname= null;
		String bookTitle = null;
		Book book;
		VIM vim =null;
		byte[]data = null;
		System.out.println("\n Enter book title:");
		bookTitle = in.next();
		
		System.out.println("\n Enter Book Author:");
		String bookAuthor = in.next();
		
		System.out.println("\n Enter Book ISBN");
		int isbn = in.nextInt();
		
		
		System.out.println("\n Enter Book Price:");
		double bookPrice = in.nextDouble();
		
		book = lib.getBookByName(bookTitle);
		if(book == null)
		{
			System.out.println("Book does not exist!");
		}
		else
		{
			System.out.println(book.toString());
			System.out.println("Enter the complete file name:");
			vimname = in.next();
			vim = book.getVIMByName(vimname);
			if(vim==null)
			{
				System.out.println("File does not exist!");
				
			}else
			{
			data = vim.getData();	
			
			File file = new File(vim.getName());
			FileOutputStream out = new FileOutputStream(file);
			}
;;		}
	}
	private static void importOpenAndSave() {
		// TODO Auto-generated method stub
		
	}
	private static void addBook() {
		// TODO Auto-generated method stub
		int isbn;
		String title,author;
		double price;
	     
		System.out.println("\n Enter Title: ");
		title = in.next();
		
		System.out.println("\n Enter Author: ");
	    author = in.next();
		
		System.out.println("\n Enter ISBN: ");
		isbn =in.nextInt();

		System.out.println("\n Enter Price: ");
		price = in.nextDouble();
		
		Book b= new Book(isbn,title,author,price);
		lib.addBook(b);
	}
	private static void addVIM() {
		// TODO Auto-generated method stub
		JFileChooser chooser;
		FileNameExtensionFilter filter;
		FileInputStream fis = null;
		Book book;
		String bookTitle;
		VIM vim;
		File file = null;
		byte[]data = null;
		
		boolean stop =false;
		System.out.println("\n Enter book title to put the file on:");
		bookTitle = in.next();
		book = lib.getBookByName(bookTitle);
		if(book == null)
		{
			System.out.println("Book does not exist");
		}
		else
		{
			System.out.println("\n choose your video/Image/music file to add:");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chooser = new JFileChooser();
           
		filter = new FileNameExtensionFilter("video/Image/Music Files","wav","mp3","avi","mp4","png","jpeg");
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int resultCode = chooser.showOpenDialog(null);
		if(resultCode == JFileChooser.APPROVE_OPTION)
		{
			file =chooser.getSelectedFile();
			data= new byte[(int)file.length()];
		}
		else {
			System.out.println("You cancelled adding a vim!");
			stop = true;
		}
		
		if(!stop)
		{
			try {
				fis = new FileInputStream(file);
				try {
					fis.read(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vim = new VIM(file.getName(),data);
			book.addVIM(vim);
			
			System.out.println("you have added"+file.getName()+"to book"+bookTitle+"\n");
		}
		}
	}
	private static void saveAndQuit() {
	    
		System.out.println("Enter Title");
		fileName =in.next();
		running = false;
		 FileOutputStream fos = null;
        ObjectOutputStream out= null;
        try {
        	fos = new FileOutputStream(fileName);
        	out =new ObjectOutputStream(fos);
        	out.writeObject(lib);
        	fos.close();
        	out.close();
        }
        catch(FileNotFoundException e)
        {
        	e.printStackTrace();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
	}
	private static void LoadScript(String name) {
          
		FileInputStream fis = null;
		ObjectInputStream in = null;
		File file = new File(name + ".ser");
		if(file.exists())
		{		
			try {
				
				fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				lib = (Library)in.readObject();
				fis.close();
				in.close();
		}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			
			{
				e.printStackTrace();
			}
		}
		else {
			System.out.println("\n The file does not exist");
		}

	}
}

