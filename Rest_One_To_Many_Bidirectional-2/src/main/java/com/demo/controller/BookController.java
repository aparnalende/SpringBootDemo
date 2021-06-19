package com.demo.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.entity.Book;
import com.demo.entity.Library;
import com.demo.repository.BookRepository;
import com.demo.repository.LibraryRepository;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {  
	private final BookRepository bookRepository;
	private final LibraryRepository libraryRepository;

	@Autowired
	public BookController(BookRepository bookRepository, LibraryRepository libraryRepository) {
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository;
	}

	@PostMapping
	public ResponseEntity<Book> create(@RequestBody @Validated Book book) {
		Optional<Library> optionalLibrary = libraryRepository.findById(book.getLibrary().getId());
		if (!optionalLibrary.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		book.setLibrary(optionalLibrary.get());

		Book savedBook = bookRepository.save(book);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBook.getId()).toUri();

		return ResponseEntity.created(location).body(savedBook);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> update(@RequestBody @Validated Book book, @PathVariable Integer id) {
		Optional<Library> optionalLibrary = libraryRepository.findById(book.getLibrary().getId());
		if (!optionalLibrary.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Optional<Book> optionalBook = bookRepository.findById(id);
		if (!optionalBook.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		book.setLibrary(optionalLibrary.get());
		book.setId(optionalBook.get().getId());
		bookRepository.save(book);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Book> delete(@PathVariable Integer id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (!optionalBook.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		bookRepository.delete(optionalBook.get());

		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<Page<Book>> getAll(Pageable pageable) {
		return ResponseEntity.ok(bookRepository.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getById(@PathVariable Integer id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (!optionalBook.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(optionalBook.get());
	}
}
