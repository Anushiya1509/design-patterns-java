package com.anushiya.design_patterns.factory.reader;

import org.springframework.stereotype.Component;

@Component("pdf")
public class PdfReader implements DocumentReader {
    @Override
    public String read() {
        return "Reading PDF document...";
    }
}