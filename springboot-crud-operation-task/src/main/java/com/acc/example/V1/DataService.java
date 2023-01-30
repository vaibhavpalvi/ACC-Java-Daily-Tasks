package com.acc.example.V1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
	
	@Autowired
	BookRepo bookRepo;
	
	public List<DataModel> getAllBooks()   
	{  
	List<DataModel> books = new ArrayList<DataModel>();  
	bookRepo.findAll().forEach(books1 -> books.add(books1));  
	return books;  
	}
	
	public DataModel getBooksById(int id)   
	{  
	return bookRepo.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(DataModel books)   
	{  
		bookRepo.save(books);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		bookRepo.deleteById(id);  
	}  
	//updating a record  
	public void update(DataModel books, int bookid)   
	{  
		bookRepo.save(books);  
	}  
}
