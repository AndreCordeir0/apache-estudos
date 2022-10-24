package com.apache.estudos.routes;

import com.apache.estudos.processor.FileProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("direct:log-file").log("log: ${header.CamelFileName}")
                .process(new FileProcessor());

        from("file:C:\\Users\\André\\Documents\\TesteApache\\input")
                .to("direct:log-file");
    }



}
