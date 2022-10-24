package com.apache.estudos.routes;

import com.apache.estudos.processor.FileProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        restConfiguration()
                .host("0.0.0.0").port(8081)
                .bindingMode(RestBindingMode.auto);

        rest("/integration")
                //Endpoint que consulta todos os autores
                .get("/files/{id}")
                .to("direct:log-file");


        from("direct:log-file").log("log: ${header.CamelFileName}")
                .process(new FileProcessor());

        from("file:C:\\Users\\André\\Documents\\TesteApache\\input")
                .to("direct:log-file");
    }



}
