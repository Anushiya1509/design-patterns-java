package com.anushiya.design_patterns.factory.reader;

import org.springframework.stereotype.Component;

@Component("excel")
public class ExcelReader implements DocumentReader {
    @Override
    public String read() {
        return "Reading Excel document...";
    }
}