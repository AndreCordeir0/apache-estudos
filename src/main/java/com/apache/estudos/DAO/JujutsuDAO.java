package com.apache.estudos.DAO;

import com.apache.estudos.entity.CardJujutsu;
import com.apache.estudos.entity.Jujutsu;
import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Repository
public class JujutsuDAO extends GenericDAO<Jujutsu>{
    private String imgPath = "C:\\\\Users\\\\André\\\\Downloads\\\\scSNEQO.jpg";
    @PersistenceContext
    EntityManager entityManager;

    public List<Jujutsu> getAll() throws IOException {
        Query query = entityManager.createQuery("SELECT DISTINCT j from Jujutsu j  LEFT JOIN FETCH j.cards", Jujutsu.class);

        File file = new File(imgPath);
        BufferedImage bufferedImage = ImageIO.read(file);
        ByteArrayOutputStream baos =new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", baos );
        byte[] imageInByte = baos.toByteArray();
        byte[] base64 = Base64.getEncoder().encode(imageInByte);
        List<Jujutsu> listaResultado = query.getResultList();
        listaResultado.get(0).setCardUrl(imageInByte);
        return listaResultado ;
    }




}
