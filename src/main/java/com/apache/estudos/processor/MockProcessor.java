package com.apache.estudos.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MockProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getMessage().setBody("Jujutsu");
    }
}
