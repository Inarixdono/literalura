package com.inarixdono.literalura.model;



import com.inarixdono.literalura.dto.AuthorDTO;
import com.inarixdono.literalura.service.Representable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author implements Representable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Short birthYear;
    private Short deathYear;

    public Author(AuthorDTO authorDTO) {
        this.name = authorDTO.name();
        this.birthYear = authorDTO.birthYear();
        this.deathYear = authorDTO.deathYear();
    }

    @Override
    public String toString() {
        return this.name + " (" + this.birthYear + "-" + this.deathYear + ")";
    }

    @Override
    public String representation() {
        return this.toString();
    }

    public Boolean isAlive(Short givenYear) {
        return this.birthYear <= givenYear && (this.deathYear == null || this.deathYear >= givenYear);
    }
}
