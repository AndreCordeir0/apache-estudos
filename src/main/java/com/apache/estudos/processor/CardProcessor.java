package com.apache.estudos.processor;

import com.apache.estudos.DAO.CardJujutsuDAO;
import com.apache.estudos.DAO.JujutsuDAO;
import com.apache.estudos.entity.CardJujutsu;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CardProcessor implements Processor {
    @Autowired
    CardJujutsuDAO cardJujutsuDAO;

    @Override
    public void process(Exchange exchange) throws Exception {
        List<CardJujutsu> cards =  cardJujutsuDAO.getAllCardsFromJujutsuID(exchange.getIn().getHeader("id",Long.class));

        exchange.getIn().setBody(cards);
    }
}
