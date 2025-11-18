package com.examly.springapp.service;

import com.examly.springapp.model.Document;
import com.examly.springapp.repository.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not Found"));
    }

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public Document updateDocument(Long id, Document document) {
        Document existing = getDocumentById(id);
        existing.setTitle(document.getTitle());
        existing.setFileName(document.getFileName());
        existing.setFileType(document.getFileType());
        existing.setOwnerId(document.getOwnerId());
        existing.setIsPublic(document.getIsPublic());
        existing.setDescription(document.getDescription());
        return documentRepository.save(existing);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    public List<Document> getPublicDocuments() {
        return documentRepository.findByIsPublicTrue();
    }

    public List<Document> getDocumentsByOwner(Long ownerId) {
        return documentRepository.findByOwnerId(ownerId);
    }
}