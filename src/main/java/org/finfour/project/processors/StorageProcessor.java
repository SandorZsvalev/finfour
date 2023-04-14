package org.finfour.project.processors;

import org.apache.camel.Exchange;
import org.finfour.project.model.Document;
import org.finfour.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StorageProcessor implements org.apache.camel.Processor {

    @Autowired
    DocumentService documentService;

    @Override
    public void process(Exchange exchange) throws Exception {
        Document docFromExchange = exchange.getIn().getBody(Document.class);
        documentService.registerDocument(docFromExchange);
    }
}
