package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Serializable>{
public Book findByBookId(int bookId);
}
