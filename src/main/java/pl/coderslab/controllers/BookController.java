package pl.coderslab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.POJO.Book;
import pl.coderslab.services.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private MemoryBookService memoryBookService;

	// metoda testowa
	@RequestMapping("/hello")
	public String hello() {
		return "{hello: World}";
	}

	// metoda testowa
	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(1L,"9788324631766","Thinking in Java",
				"Bruce	Eckel","Helion","programming");
	}
	
	@GetMapping
	public List<Book> booksList() {
		return memoryBookService.getList();
	}
	
	@GetMapping("/{id}")
	public Book bookDetails(@PathVariable long id) {
		return memoryBookService.getDetails(id);
	}
	
	@PostMapping
	public void addBook(@RequestBody Book book) {
		List<Book> list = memoryBookService.getList();
		long id = 0;
		for (Book bk : list) {
			if (bk.getId() >= id) {
				id = bk.getId();
				id++;
			}
		}
		book.setId(id);
		list.add(book);
		memoryBookService.setList(list);
	}
}
