package com.apache.estudos.aggregations;

import com.apache.estudos.entity.Content;
import com.apache.estudos.entity.Jujutsu;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ContentAggregationStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        Jujutsu jujutsu =  oldExchange.getIn().getBody(Jujutsu.class);
        List<Content> listaContent = newExchange.getMessage().getBody(List.class);
        listaContent.forEach(c->jujutsu.getContentList().add(c));

        oldExchange.getIn().setBody(jujutsu);

        return oldExchange;
    }
}
