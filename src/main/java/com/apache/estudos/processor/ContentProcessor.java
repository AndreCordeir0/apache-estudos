package com.apache.estudos.processor;

import com.apache.estudos.DAO.ContentDAO;
import com.apache.estudos.entity.Content;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContentProcessor implements Processor {

    @Autowired
    ContentDAO contentDAO;

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Content> listaContents = contentDAO.getAllContents();
        exchange.getMessage().setBody(listaContents);
    }
}
