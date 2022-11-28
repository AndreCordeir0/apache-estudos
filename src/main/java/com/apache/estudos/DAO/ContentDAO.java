package com.apache.estudos.DAO;

import com.apache.estudos.entity.Content;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class ContentDAO {

    @PersistenceContext
    EntityManager entityManager;


    public List<Content> getAllContents(){
        Query query = entityManager.createQuery("FROM Content");

        return query.getResultList();
    }
}
