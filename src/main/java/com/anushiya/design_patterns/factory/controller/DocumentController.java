package com.anushiya.design_patterns.factory.controller;

import com.anushiya.design_patterns.factory.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/factory")
public class DocumentController {

    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/read")
    public ResponseEntity<?> read(@RequestParam String type) {
        try {
            String content = documentService.readDocument(type);
            return ResponseEntity.ok(Map.of(
                    "type", type.toUpperCase(),
                    "content", content
            ));

        } catch (IllegalArgumentException e) {
            logger.error("Invalid document type input: {}", type, e);
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "Invalid Document Type. Expected one of: PDF, WORD, EXCEL"
            ));

        } catch (Exception e) {
            logger.error("Unexpected error occurred while reading document", e);
            return ResponseEntity.internalServerError().body(Map.of(
                    "error", "Something went wrong. Please try again later!"
            ));
        }
    }
}
