package com.inarixdono.literalura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inarixdono.literalura.dto.BookDTO;
import com.inarixdono.literalura.model.Author;
import com.inarixdono.literalura.model.Book;
import com.inarixdono.literalura.repository.AuthorRepository;
import com.inarixdono.literalura.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class LiteraluraService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Book saveBook(BookDTO bookDTO) {
        Author author = new Author(bookDTO.authors().get(0));

        if(repository.existsByTitle(bookDTO.title())) {
            throw new IllegalArgumentException("Book already exists");
        }

        if(authorRepository.existsByName(author.getName())) {
            author = authorRepository.findByName(author.getName());
        }

        return repository.save(new Book(bookDTO, author));    
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> topBooks() {
        return repository.topBooks();
    }
}
