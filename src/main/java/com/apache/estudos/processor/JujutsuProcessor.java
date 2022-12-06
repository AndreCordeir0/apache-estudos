package com.apache.estudos.processor;

import com.apache.estudos.DAO.JujutsuDAO;
import com.apache.estudos.entity.Jujutsu;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;
import java.util.List;

@Component
public class JujutsuProcessor implements Processor {
    @Autowired
    JujutsuDAO jujutsuDAO;
    private String imgPath = "C:\\\\Users\\\\André\\\\Downloads\\\\scSNEQO.jpg";

    @Override
    public void process(Exchange exchange) throws Exception {
        Jujutsu jujutsu  = this.jujutsuDAO.getAll();


        File file = new File(imgPath);
        BufferedImage bufferedImage = ImageIO.read(file);
        ByteArrayOutputStream baos =new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", baos );
        byte[] imageInByte = baos.toByteArray();
        String base64 = Base64.getEncoder().encodeToString(imageInByte);
        jujutsu.setCardUrl(imageInByte);

        exchange.getIn().setHeader("id",jujutsu.getId());
        exchange.getIn().setBody(jujutsu);
    }

}
