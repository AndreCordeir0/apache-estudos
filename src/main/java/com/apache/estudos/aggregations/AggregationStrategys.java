package com.apache.estudos.aggregations;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class AggregationStrategys implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        var id = oldExchange.getIn().getBody(String.class);
        var novo = newExchange.getMessage().getBody(String.class);

        var novoId = id + 1;
        System.out.println(newExchange);
        oldExchange.getMessage().setBody("Antigo: " + id + " Novo: " + novo);
        return oldExchange;
    }


}
