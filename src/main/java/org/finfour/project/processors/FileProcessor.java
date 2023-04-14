package org.finfour.project.processors;

import org.apache.camel.Exchange;
import org.finfour.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor implements org.apache.camel.Processor {

    @Autowired
    private DocumentService documentService;

    @Override
    public void process(Exchange exchange) throws Exception {
        // здесь логика проверки данных
    }
}
