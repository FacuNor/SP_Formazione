package listtomap;

import java.util.Objects;

public class Book {

	private String isbn;
	private String desc;
	private String author;
	private String nazione;
	private double price;
	
	public Book(String isbn, String desc, String author,String nazione, double price) {
		super();
		this.isbn = isbn;
		this.desc = desc;
		this.author = author;
		this.nazione = nazione;
		this.price = price;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", desc=" + desc + ", author=" + author + "]";
	}
	
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(desc, other.desc)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(price, other.price)
				&& Objects.equals(nazione,other.nazione);
	}

	
	
	
	
}
