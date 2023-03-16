package com.cache.library.service.interfaces;

import com.cache.library.model.Book;

public interface BookService {
    Book add(Book book);
    Book update(Book book);
    Book get(Long id);
    String delete(Long id);
}
