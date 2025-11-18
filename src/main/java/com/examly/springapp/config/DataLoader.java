package com.examly.springapp.config;

import com.examly.springapp.model.Document;
import com.examly.springapp.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (documentRepository.count() == 0) {
            Document doc1 = new Document();
            doc1.setTitle("Annual Report");
            doc1.setDescription("Report for 2023");
            doc1.setFileName("report2023.pdf");
            doc1.setFileType("application/pdf");
            doc1.setOwnerId(101L);
            doc1.setIsPublic(true);
            documentRepository.save(doc1);

            Document doc2 = new Document();
            doc2.setTitle("Private Notes");
            doc2.setDescription("Personal notes");
            doc2.setFileName("notes.docx");
            doc2.setFileType("application/docx");
            doc2.setOwnerId(101L);
            doc2.setIsPublic(false);
            documentRepository.save(doc2);
        }
    }
}