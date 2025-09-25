package librarySystem;

public class Book {

	private String id;
	private String title;
	private boolean isBookIssued;

	public Book(String id, String title) {
		this.id = id;
		this.title = title;
		this.isBookIssued = false;
	}

	public String getId() {
		return id;

	}

	public String getTitle() {
		return title;
	}

	public boolean isBookIssued() {
		return isBookIssued;
	}

	public void issue() {
		this.isBookIssued = true;
	}

	public void returnBook() {
		this.isBookIssued = false;
	}

	@Override
	public String toString() {
		return id + " | " + title + (isBookIssued ? " (Issued)" : " (Available)");
	}
}
