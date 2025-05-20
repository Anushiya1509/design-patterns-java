package com.anushiya.design_patterns.factory.service;

import com.anushiya.design_patterns.factory.reader.DocumentReader;
import com.anushiya.design_patterns.factory.reader.DocumentReaderFactory;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentReaderFactory factory;

    public DocumentService(DocumentReaderFactory factory) {
        this.factory = factory;
    }

    public String readDocument(String type) {
        DocumentReader reader = factory.getReader(type);
        return reader.read();
    }
}