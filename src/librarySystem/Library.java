package librarySystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
	private Map<String, Book> books = new HashMap<>();
	private Scanner sc;

	public Library() {

		sc = new Scanner(System.in);
	}

	public void bookDetails() {
		while (true) {
			// Scanner sc = new Scanner(System.in);
			System.out.println(" \n ------:Library:------");
			System.out.println("1. Add Books ");
			System.out.println("2. Issue Book");
			System.out.println("3. Return Book");
			System.out.println("4. Show All Books ");
			System.out.println("5. Exit  ");
			System.out.print(" Enter Choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				addBook();
				break;
			case 2:
				System.out.println(issueBook());
				break;
			case 3:
			    System.out.println(returnBook());

				break;
			case 4:
				showAllBooks();
				break;

			case 5:
				System.out.println("Exiting...");
				return;
				

			default:
				System.out.println("Invalid Choice : ");
			}

		}
	}

	// add a book
	public void addBook() {
		System.out.print("Enter the book ID  : ");
		String id = sc.next();
		System.out.print("Enter the book Title  : ");
		String title = sc.nextLine();
		sc.nextLine();

		Book myBook = new Book(id, title);
		books.put(id, myBook);

		System.out.println("\t Book added successfully: " + title);

		// books.put(book.getId(), book);
	}

	public String issueBook() {
		System.out.print("Enter Book ID to issue: ");
		String bookId = sc.next();

		System.out.print("Enter your User ID: ");
		String userId = sc.next();

		System.out.print("Enter your Name: ");
		String userName = sc.nextLine();
		sc.nextLine();
		// create User object from input
		User user = new User(userId, userName);

		// book from map
		Book book = books.get(bookId);

		if (book == null) {
			return "Book not found.. ";
		}
		if (book.isBookIssued()) {
			return "Book already issued.. ";
		}

		// issue the book
		book.issue();

		return "Book '" + book.getTitle() + "' issued to " + user.getUserName();
	}

	// return a book
	public String returnBook() {
	    System.out.print("Enter Book ID to return: ");
	    String bookId = sc.next();

	    System.out.print("Enter your User ID: ");
	    String userId = sc.next();

	    System.out.print("Enter your Name: ");
	    String userName = sc.nextLine();
	    sc.nextLine();
	    // create User object from input
	    User user = new User(userId, userName);

	    // get book from map
	    Book book = books.get(bookId);

	    if (book == null) {
	        return "Book not found.. ";
	    }
	    if (!book.isBookIssued()) {
	        return "Book was not issued.";
	    }

	    // return the book
	    book.returnBook();

	    return "Book '" + book.getTitle() + "' returned by " + user.getUserName();
	}


	// get all the books
	public void showAllBooks() {

		System.out.println("\n \t -----------------All Books---------------");

		for (Book book : books.values()) {
			System.out.println("| " + book);
		}

	}

}
