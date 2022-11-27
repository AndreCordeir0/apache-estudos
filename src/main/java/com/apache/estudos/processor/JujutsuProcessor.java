package com.apache.estudos.processor;

import com.apache.estudos.DAO.JujutsuDAO;
import com.apache.estudos.entity.Jujutsu;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JujutsuProcessor implements Processor {
    @Autowired
    JujutsuDAO jujutsuDAO;

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Jujutsu> lista   = this.jujutsuDAO.getAll();
        exchange.getIn().setHeader("id",lista.get(0).getId());
        exchange.getIn().setBody(lista);
    }

}
