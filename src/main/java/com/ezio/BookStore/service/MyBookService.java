package com.ezio.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.BookStore.entity.MyBookList;
import com.ezio.BookStore.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository myBookRepository;
	
	public void saveMyBooks(MyBookList myBookList) {
		myBookRepository.save(myBookList);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return myBookRepository.findAll();
	}
	
	public void deleteById(Integer id) {
		myBookRepository.deleteById(id);
	}
}
