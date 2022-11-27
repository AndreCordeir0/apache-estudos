package com.apache.estudos.routes;

import com.apache.estudos.aggregationStrategy.AggregationStrategys;
import com.apache.estudos.processor.FileProcessor;
import com.apache.estudos.processor.MockProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {
    @Autowired
    AggregationStrategys aggregationStrategys;

    @Override
    public void configure() throws Exception {


        rest("/integration")
                //Endpoint que consulta todos os personagens
                .get("/files/{id}")
                .to("direct:log-file");


        from("direct:log-file").log("log: ${header.CamelFileName}")
                .process(new FileProcessor()).enrich("direct:mock_test",aggregationStrategys)
            .end().to("file:C:\\Users\\André\\Documents\\TesteApache\\input\\arquivo.txt");

        from("direct:mock_test").process(new MockProcessor());

        from("file:C:\\Users\\André\\Documents\\TesteApache\\input")
                .to("direct:log-file");
    }



}
