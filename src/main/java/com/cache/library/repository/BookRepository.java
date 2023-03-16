package com.cache.library.repository;

import com.cache.library.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.name = :name WHERE b.id = :id")
    //    @Query("UPDATE Book b SET b.name = ?2 WHERE b.id = ?1")
    void update(@Param("id") Long id, @Param("name") String name);
}
