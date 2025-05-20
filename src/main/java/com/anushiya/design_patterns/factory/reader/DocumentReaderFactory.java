package com.anushiya.design_patterns.factory.reader;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DocumentReaderFactory {

    @PostConstruct
    public void init() {
        System.out.println("Available readers: " + readerMap.keySet());
    }

    private final Map<String, DocumentReader> readerMap;

    public DocumentReaderFactory(Map<String, DocumentReader> readerMap) {
        this.readerMap = readerMap;
    }

    public DocumentReader getReader(String type) {
        DocumentReader reader = readerMap.get(type.toLowerCase());
        if (reader == null) {
            throw new IllegalArgumentException("Unsupported document type: " + type);
        }
        return reader;
    }
}