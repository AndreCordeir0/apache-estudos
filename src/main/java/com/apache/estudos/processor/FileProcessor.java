package com.apache.estudos.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.io.File;

public class FileProcessor implements  Processor {


    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getHeader("id"));
    }
}
