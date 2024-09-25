package com.ezio.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.BookStore.entity.Book;
import com.ezio.BookStore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getBook(){
		return bookRepository.findAll();
		}
	
	public Book getBookById(Integer id) {
		return bookRepository.findById(id).get();
	}
	 
	
	public void deleteId(Integer id) {
		 bookRepository.deleteById(id);
	}
}
