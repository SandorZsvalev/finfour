package org.finfour.project.configuration;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileRouteBuilder extends RouteBuilder {

    @Value("${finfour.path}") // указываем в пропертях
    private String pathToFile;

    @Override
    public void configure() throws Exception {
        String path = "file://"+pathToFile+"?delete=true";

        String url = "activemq:queue:FILE.OUTPUT";

        from(path)
                .routeId("fileInputRoad")
                .process("fileToDocProcessor")
                .process("storageProcessor")
                .process("docToJsonProcessor")

                .to(url)
                .stop();

        from("direct:documentInput")
                .routeId("docInputRoad")
                .process("storageProcessor")
                .process("docToJsonProcessor")
                .to (url)
                .stop();

    }
}
