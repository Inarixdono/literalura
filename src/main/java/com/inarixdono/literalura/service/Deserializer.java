package com.inarixdono.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserializer {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T deserialize (String json, Class<T> classType) {
        try {
            return objectMapper.readValue(json, classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing JSON", e);
        }
    }
}
