package pl.coderslab.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.coderslab.POJO.Book;
import pl.coderslab.utils.Utils;

@Component
public class MemoryBookService implements BookService {

	private	List<Book> books;

	// metoda testowa
	public	MemoryBookService()	{
		books = new ArrayList<>();
		books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel","Helion", "programming"));
		books.add(new Book(2L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, "
				+ "Bates Bert", "Helion", "programming"));
		books.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, "
				+ "Gary Cornell", "Helion", "programming"));
	}
	
	/* (non-Javadoc)
	 * @see pl.coderslab.services.BookService#getList()
	 */
	@Override
	public List<Book> getList() {
		return books;
	}

	/* (non-Javadoc)
	 * @see pl.coderslab.services.BookService#setList(java.util.List)
	 */
	@Override
	public void setList(List<Book> list) {
		this.books = list;
	}
	
	/* (non-Javadoc)
	 * @see pl.coderslab.services.BookService#getDetails(long)
	 */
	@Override
	public Book getDetails(long id) {

		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see pl.coderslab.services.BookService#updateBook(long, pl.coderslab.POJO.Book)
	 */
	@Override
	public void updateBook(long id, Book bookToUpdate) {
		
		for (Book book : books) {
			
			if (book.getId() == id) {
				
				if (Utils.stringNotNull(bookToUpdate.getIsbn())) {
					book.setIsbn(bookToUpdate.getIsbn());
				}
				
				if (Utils.stringNotNull(bookToUpdate.getTitle())) {
					book.setTitle(bookToUpdate.getTitle());
				}
				
				if (Utils.stringNotNull(bookToUpdate.getAuthor())) {
					book.setAuthor(bookToUpdate.getAuthor());
				}
				
				if (Utils.stringNotNull(bookToUpdate.getPublisher())) {
					book.setPublisher(bookToUpdate.getPublisher());
				}
				
				if (Utils.stringNotNull(bookToUpdate.getType())) {
					book.setType(bookToUpdate.getType());
				}
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see pl.coderslab.services.BookService#deleteBook(long)
	 */
	@Override
	public void deleteBook(long id) {
		Iterator<Book> iterator = books.iterator();
		while (iterator.hasNext() ) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
				return;
			}
		}
		
	}
}


