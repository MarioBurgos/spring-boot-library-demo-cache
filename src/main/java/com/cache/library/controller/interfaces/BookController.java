package com.cache.library.controller.interfaces;

import com.cache.library.model.Book;

public interface BookController {

    Book add(Book book);
    Book update(Book book);
    Book get(Long id);
    String delete(Long id);
}
