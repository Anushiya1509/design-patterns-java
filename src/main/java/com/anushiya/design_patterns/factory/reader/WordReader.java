package com.anushiya.design_patterns.factory.reader;

import org.springframework.stereotype.Component;

@Component("word")
public class WordReader implements DocumentReader {
    @Override
    public String read() {
        return "Reading Word document...";
    }
}