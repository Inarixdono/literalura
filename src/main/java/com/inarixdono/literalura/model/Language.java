package com.inarixdono.literalura.model;

import java.util.List;

import com.inarixdono.literalura.service.Representable;

import lombok.Getter;

@Getter
public enum Language implements Representable {
    ENGLISH("Inglés", "en"),
    SPANISH("Español", "es"),
    FRENCH("Frances", "fr"),
    GERMAN("Alemán", "de"),
    PORTUGUESE("Portugués", "pt"),;

    private String language;
    private String code;
    public static List<Representable> languages = List.of(Language.values());

    private Language(String language, String code) {
        this.language = language;
        this.code = code;
    }

    public static Language fromCode(String code) {
        for (Language language : Language.values()) {
            if (language.code.equals(code)) {
                return language;
            }
        }
        throw new IllegalLanguageException("Invalid language code");
    }

    @Override
    public String representation() {
        return this.language;
    }
}
