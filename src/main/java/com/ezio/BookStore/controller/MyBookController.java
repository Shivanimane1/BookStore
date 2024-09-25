package com.ezio.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezio.BookStore.service.MyBookService;

@Controller
public class MyBookController {

	@Autowired
	private MyBookService myBookService;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") Integer id) {
		myBookService.deleteById(id);
		return "redirect:/my_books";
	}
}
