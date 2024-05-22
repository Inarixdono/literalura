package com.inarixdono.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorDTO(
        String name,
        @JsonProperty("birth_year") Short birthYear,
        @JsonProperty("death_year") Short deathYear) {
}
