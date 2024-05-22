package com.inarixdono.literalura.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResponseDTO(
        Long count,
        List<BookDTO> results) {
}
