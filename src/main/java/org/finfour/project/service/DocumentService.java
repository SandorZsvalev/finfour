package org.finfour.project.service;

import org.apache.camel.Exchange;
import org.finfour.project.model.Document;

import java.util.List;

public interface DocumentService {

    Document registerDocument(Exchange exchange);
//    Document registerFromApiDocument(Exchange exchange);

    List<Document> getAllDocumentsByUserId(int userId) throws RuntimeException;

    List<Document> getAllDocuments();

    Document registerDocument(Document document);

    Document getDocumentById(int id);

    Document getDocTemplate();

    void removeDocumentById(int id);


}
