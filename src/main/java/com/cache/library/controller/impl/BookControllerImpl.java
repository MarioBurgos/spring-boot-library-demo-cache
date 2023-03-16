package com.cache.library.controller.impl;

import com.cache.library.controller.interfaces.BookController;
import com.cache.library.model.Book;
import com.cache.library.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class BookControllerImpl implements BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Book add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @DeleteMapping("/books/{id}")
    public String delete(@PathVariable Long id) {
        return bookService.delete(id);
    }
}
