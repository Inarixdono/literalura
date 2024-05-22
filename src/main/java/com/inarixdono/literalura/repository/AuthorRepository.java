package com.inarixdono.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inarixdono.literalura.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
    public boolean existsByName(String name);
    public Author findByName(String name);
}
