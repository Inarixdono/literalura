package com.inarixdono.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inarixdono.literalura.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    public boolean existsByTitle(String title);

    @Query("""
        SELECT b
        FROM Book b
        ORDER BY b.downloadCount DESC
        LIMIT 10
    """)
    public List<Book> topBooks();

}
