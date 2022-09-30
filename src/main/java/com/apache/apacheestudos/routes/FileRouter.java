package com.apache.apacheestudos.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {

    private String path = "";
    @Override
    public void configure() throws Exception {
        from(path).log("Apache camel ${}").to(path);
    }



}
