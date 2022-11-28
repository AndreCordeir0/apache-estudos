package com.apache.estudos.routes;

import com.apache.estudos.DAO.JujutsuDAO;
import com.apache.estudos.aggregationStrategy.CardAggregationStrategy;
import com.apache.estudos.aggregationStrategy.ContentAggregationStrategy;
import com.apache.estudos.entity.Jujutsu;
import com.apache.estudos.processor.CardProcessor;
import com.apache.estudos.processor.ContentProcessor;
import com.apache.estudos.processor.JujutsuProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@CrossOrigin(origins = "*")
public class JujutsuRouter extends RouteBuilder {

    @Autowired
    JujutsuProcessor jujutsuProcessor;

    @Autowired
    CardProcessor cardProcessor;

    @Autowired
    ContentProcessor contentProcessor;

    @Autowired
    CardAggregationStrategy cardAggregationStrategy;

    @Autowired
    ContentAggregationStrategy contentAggregationStrategy;

    private String CONTEXT = "/jujutsu";
    private String DIRECT_JUJUTSU = "direct:jujutsu";
    private String DIRECT_CONTENT = "direct:content";

    private String DIRECT_CARD= "direct:card";

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .port(8081)
                .enableCORS(true) // <-- Important
                .corsAllowCredentials(true) // <-- Important
                .corsHeaderProperty("Access-Control-Allow-Origin","*")
                .corsHeaderProperty("Access-Control-Allow-Headers","Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization")
                .bindingMode(RestBindingMode.auto);

        rest(CONTEXT)
                //Endpoint que consulta todos os personagens
                .get("/get-all")
                .to(DIRECT_JUJUTSU);

        from(DIRECT_JUJUTSU).process(jujutsuProcessor).enrich(DIRECT_CONTENT,contentAggregationStrategy);

        from(DIRECT_CONTENT).process(contentProcessor);
        from(DIRECT_CARD).process(cardProcessor);

    }
}
