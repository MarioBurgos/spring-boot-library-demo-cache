package com.cache.library.service.impl;

import com.cache.library.model.Book;
import com.cache.library.repository.BookRepository;
import com.cache.library.service.interfaces.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book add(Book book) {
        logger.info("add book with id - {}", book.getId());
        return bookRepository.save(book);    }

    @Override
    //@CachePut(cacheNames = "books", key = "#book.id")
    public Book update(Book book) {
        bookRepository.update(book.getId(), book.getName());
        logger.info("book updated with new name");
        return book;
    }

    @Override
    @Cacheable(cacheNames = "books", key = "#id")
    public Book get(Long id) {
        logger.info("fetching book from db");
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent())
            return book.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matches");
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public String delete(Long id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }
}
