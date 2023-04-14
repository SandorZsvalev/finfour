package org.finfour.project.processors;

import org.apache.camel.Exchange;
import org.finfour.project.model.Document;
import org.finfour.project.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileToDocProcessor implements org.apache.camel.Processor {

    @Autowired
    DocumentService documentService;

    @Override
    public void process(Exchange exchange) throws Exception {

        Document document = documentService.getDocTemplate();

        // Получаем массив байт из сообщения
        byte[] fileData = exchange.getIn().getBody(byte[].class);
        document.setBody(fileData);
        document.setOriginDocName(exchange.getMessage().getHeader("CamelFileName", String.class));

        // Устанавливаем объект Document в сообщение
        exchange.getIn().setBody(document);
    }
}
