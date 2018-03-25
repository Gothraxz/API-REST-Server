package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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


}
