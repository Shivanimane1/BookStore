package com.ezio.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezio.BookStore.entity.Book;
import com.ezio.BookStore.entity.MyBookList;
import com.ezio.BookStore.service.BookService;
import com.ezio.BookStore.service.MyBookService;



@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=bookService.getBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		  bookService.saveBook(book);
		  return "redirect:/available_books";
		}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model ) {
		//System.out.println("xfcv");
		List<MyBookList> lists = myBookService.getAllMyBooks();
		model.addAttribute("book", lists);
		return "myBooks";
	}
	
	@GetMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") Integer id) {
        Book b = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") Integer id, Model model) {
		Book b= bookService.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}
	

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteId(id);
		return "redirect:/available_books";
	}
}
