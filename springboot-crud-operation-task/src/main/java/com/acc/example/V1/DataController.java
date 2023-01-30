package com.acc.example.V1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	@Autowired  
	DataService booksService;  
	//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping("/book")  
	private List<DataModel> getAllBooks()   
	{  
	return booksService.getAllBooks();  
	}  
	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/book/{bookid}")  
	private DataModel getBooks(@PathVariable("bookid") int bookid)   
	{  
	return booksService.getBooksById(bookid);  
	}  
	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/book/{bookid}")  
	private void deleteBook(@PathVariable("bookid") int bookid)   
	{  
	booksService.delete(bookid);  
	}  
	//creating post mapping that post the book detail in the database  
	@PostMapping("/books")  
	private int saveBook(@RequestBody DataModel books)   
	{  
	booksService.saveOrUpdate(books);  
	return books.getBid();  
	}  
	//creating put mapping that updates the book detail   
	@PutMapping("/books")  
	private DataModel update(@RequestBody DataModel books)   
	{  
	booksService.saveOrUpdate(books);  
	return books;  
	}  
}
