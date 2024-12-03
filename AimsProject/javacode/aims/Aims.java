package aims.Aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collection;
import java.util.Collections;

import aims.cart.Cart;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Track;
import aims.store.Store;

public class Aims {
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		
		Media media1 = new DigitalVideoDisc(001, "naruto", "anime", 100, "dvd", 120);
		Media media2 = new DigitalVideoDisc(002, "AOT", "anime", 120, "dvd", 200);
		
		List<Track> trackOfGao = new ArrayList<Track>(); 
		trackOfGao.add(new Track("tap 1", 20));
		trackOfGao.add(new Track("tap 2", 100));
		
		Media media3 = new CompactDisc(003, "Gao Ranger", "super sentai", 300, "CD", 120, "unknown", trackOfGao);
		
		List<String> listOfAuthors = new ArrayList<String>();
		Media media4 = new Book(004, "Fire and Ice", "novel book", 200, listOfAuthors);
		((Book)media4).addAuthor("author1");
		((Book)media4).addAuthor("author2");
		
		store.addMedia(media1);
		store.addMedia(media2);
		store.addMedia(media3);
		store.addMedia(media4);
		
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			showMenu();
			int input1 = scanner.nextInt();
			scanner.nextLine();
			
			if(input1 == 0) break;
			if(input1 == 1)
			{
				while(true)
				{
					store.print_store();
					storeMenu();
					int input2 = scanner.nextInt(); scanner.nextLine();
					
					if(input2 == 0) break;
					if(input2 == 1)
					{
						System.out.println("Enter the title of media to detail: ");
						String input3 = scanner.nextLine();
						Media output1 = store.search(input3);
						if(output1 == null) System.out.println("The media doesnot exsist!");
						else
						{
							System.out.println(output1.toString());
							mediaDetailsMenu();
							
							int input4 = scanner.nextInt(); scanner.nextLine();
							if(input4 == 1)
							{
								cart.addMedia(output1);
								System.out.println("The numbers of media in the cart: " + cart.getQtyOrderd());
							}
							if(input4 == 2)
							{
								if(output1 instanceof Book) System.out.println("couldn't playing the book");
								else if(output1 instanceof CompactDisc)
									((CompactDisc) output1).play();
								else if(output1 instanceof DigitalVideoDisc)
									((DigitalVideoDisc) output1).play();
							}
						}
						
					}
					if(input2 == 2)
					{
						System.out.println("Enter title of media to add into cart:");
						String input3 = scanner.nextLine();
						cart.addMedia(store.search(input3));
					}
					if(input2 == 3)
					{
						System.out.println("Enter title of media to play:");
						String input3 = scanner.nextLine();
						Media output1 = store.search(input3);
						if(output1 instanceof Book) System.out.println("couldn't playing the book");
						else if(output1 instanceof CompactDisc)
							((CompactDisc) output1).play();
						else if(output1 instanceof DigitalVideoDisc)
							((DigitalVideoDisc) output1).play();
					}
					if(input2 == 4)
					{
						cart.print();
					}
					
				}
				
			}
			if(input1 == 2)
			{
				while(true)
				{
					System.out.println("Option:");
					System.out.println("----------------------");
					System.out.println("1. Add a new media into store");
					System.out.println("2. Remove media from store");
					System.out.println("0. Back");
					
					int input2 = scanner.nextInt(); scanner.nextLine();
					if(input2 == 0) break;
					if(input2 == 2)
					{
						store.print_store();
						System.out.println("Enter the titile of media to remove:");
						String input3 = scanner.nextLine();
						Media ouput1 = store.search(input3);
						if(ouput1 == null) System.out.println("The media doesnot exist");
						else store.removeMedia(ouput1);
					}
					if(input2 == 1)
					{
						System.out.println("Option:");
						System.out.println("-----------------------");
						System.out.println("1. Add a book");
						System.out.println("2. Add a DVD");
						System.out.println("3. Add a CD");
						System.out.println("0. Back");
						
						int input3 = scanner.nextInt(); scanner.nextLine();
						if(input3 == 1)
						{
							System.out.println("Enter the information: (Nhap lan luot: id, title, category, cost)");
							int id = scanner.nextInt(); scanner.nextLine();
							String title = scanner.nextLine();;
							String category = scanner.nextLine();
							float cost = scanner.nextFloat(); scanner.nextLine();
							List<String> listOfAuthors2 = new ArrayList<String>();
							
							Book book = new Book(id, title, category, cost, listOfAuthors2);
							System.out.println("Enter the author: ");
							String author = scanner.nextLine();
							book.addAuthor(author);
							store.addMedia(book);
						}
						if(input3 == 2)
						{
							System.out.println("Enter the information: (Nhap lan luot: id, title, category, cost, directory, length)");
							int id = scanner.nextInt(); scanner.nextLine();
							String title = scanner.nextLine();;
							String category = scanner.nextLine();
							float cost = scanner.nextFloat(); scanner.nextLine();
							String directory = scanner.nextLine();
							int length = scanner.nextInt();
							
							store.addMedia(new DigitalVideoDisc(id, title, category, cost, directory, length));
						}
						if(input3 == 3)
						{
							System.out.println("Enter the information: (Nhap lan luot: id, title, category, cost, directory, length)");
							int id = scanner.nextInt(); scanner.nextLine();
							String title = scanner.nextLine();;
							String category = scanner.nextLine();
							float cost = scanner.nextFloat(); scanner.nextLine();
							String directory = scanner.nextLine();
							int length = scanner.nextInt(); scanner.nextLine();
							List<Track> listTrack = new ArrayList<Track>();
							
							CompactDisc CD = new CompactDisc(id, title, category, cost, directory, length, directory, listTrack);
							System.out.println("Enter the track: (Nhap lan luot title, length)");
							String trackTitle = scanner.nextLine();
							int trackLength = scanner.nextInt(); scanner.nextLine();
							CD.addTrack(new Track(trackTitle, trackLength));
							store.addMedia(CD);
						}
					}
				}
			}
			if(input1 == 3)
			{
				while(true)
				{
					cartMenu();
					cart.print();
					int input2 = scanner.nextInt(); scanner.nextLine();
					if(input2 == 0) break;
					if(input2 == 1)
					{
						System.out.println("1. Filter by ID");
						System.out.println("2. Filter by title");
						System.out.println("0. Back");
						int input3 = scanner.nextInt(); scanner.nextLine();
						if(input3 == 1)
						{
							System.out.println("Enter the ID:");
							int input4 = scanner.nextInt(); scanner.nextLine();
							cart.search(input4);
						}
						if(input3 == 2)
						{
							System.out.println("Enter the title");
							String input4 = scanner.nextLine();
							cart.search(input4);
						}
					}
					if(input2 == 2)
					{
						System.out.println("1. Sort by Cost");
						System.out.println("2. Sort by title");
						System.out.println("0. Back");
						int input3 = scanner.nextInt(); scanner.nextLine();
						if(input3 == 1)
						{
							Collections.sort(cart.getItemOrdered(), Media.COMPARE_BY_COST_TITLE);
						}
						if(input3 == 2)
						{
							Collections.sort(cart.getItemOrdered(), Media.COMPARE_BY_TITLE_COST);
						}
					}
					if(input2 == 3)
					{
						store.print_store();
						System.out.println("Enter the titile of media to remove:");
						String input3 = scanner.nextLine();
						Media ouput1 = store.search(input3);
						if(ouput1 == null) System.out.println("The media doesnot exist");
						else store.removeMedia(ouput1);
					}
					if(input2 == 4)
					{
						System.out.println("Enter title of media to play:");
						String input3 = scanner.nextLine();
						Media output1 = store.search(input3);
						if(output1 instanceof Book) System.out.println("couldn't playing the book");
						else if(output1 instanceof CompactDisc)
							((CompactDisc) output1).play();
						else if(output1 instanceof DigitalVideoDisc)
							((DigitalVideoDisc) output1).play();
					}
					if(input2 == 5)
					{
						System.out.println("An order is created");
					}
				}
			}
		}
	}	
}
