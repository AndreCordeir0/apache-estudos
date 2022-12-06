package com.apache.estudos.processor;

import com.apache.estudos.DAO.ContentDAO;
import com.apache.estudos.DTO.ContentDTO;
import com.apache.estudos.entity.Content;
import com.apache.estudos.mappers.ContentMapper;
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
        List<ContentDTO> contentsDTO = ContentMapper.INSTANCE.listContentToDTO(listaContents);
        exchange.getMessage().setBody(contentsDTO);
    }
}
