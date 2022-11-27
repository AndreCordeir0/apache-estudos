package com.apache.estudos.DAO;

import com.apache.estudos.entity.CardJujutsu;
import com.apache.estudos.entity.Jujutsu;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JujutsuDAO extends GenericDAO<Jujutsu>{

    @PersistenceContext
    EntityManager entityManager;

    public List<Jujutsu> getAll(){
        Query query = entityManager.createQuery("SELECT j from Jujutsu j  LEFT JOIN FETCH j.cards", Jujutsu.class);

        return  query.getResultList();
    }




}
