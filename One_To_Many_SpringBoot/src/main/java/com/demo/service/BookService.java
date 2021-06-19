package com.demo.service;

import org.springframework.stereotype.Component;

import com.demo.model.Book;

@Component
public interface BookService {

	public Book saveBook(Book book);
	public Book findByBookId(int bookId);
}
