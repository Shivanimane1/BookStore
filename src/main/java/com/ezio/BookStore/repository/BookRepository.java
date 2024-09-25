package com.ezio.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezio.BookStore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
