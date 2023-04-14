package org.finfour.project.processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.finfour.project.model.Document;
import org.springframework.stereotype.Component;

@Component
public class DocToJsonProcessor implements org.apache.camel.Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // Получаем объект Document из сообщения
        Document document = exchange.getIn().getBody(Document.class);

        //Устанавливаем в заголовок id User
        exchange.getIn().setHeader("UserId", document.getUserId());

        // Сериализуем объект Document в JSON
        String json = new ObjectMapper().writeValueAsString(document);

        // Устанавливаем строку JSON в теле сообщения
        exchange.getIn().setBody(json);
    }
}
