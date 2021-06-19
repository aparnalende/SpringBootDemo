package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Book;
import com.demo.repository.BookRepository;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		book=bookRepository.save(book);
		return book;
	}
	@Override
	public Book findByBookId(int bookId) {
		// TODO Auto-generated method stub
		Book book=bookRepository.findByBookId(bookId);
		return book;
	}
}
