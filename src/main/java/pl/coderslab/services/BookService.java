package pl.coderslab.services;

import java.util.List;

import pl.coderslab.POJO.Book;

public interface BookService {

	List<Book> getList();

	void setList(List<Book> list);

	Book getDetails(long id);

	void updateBook(long id, Book bookToUpdate);

	void deleteBook(long id);

}