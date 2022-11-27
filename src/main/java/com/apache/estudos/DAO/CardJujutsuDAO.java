package com.apache.estudos.DAO;

import com.apache.estudos.entity.CardJujutsu;
import com.apache.estudos.entity.Jujutsu;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository

public class CardJujutsuDAO extends GenericDAO<CardJujutsu>{

    @PersistenceContext
    EntityManager entityManager;

    public List<CardJujutsu> getAllCardsFromJujutsuID(Long id){
        Query query = entityManager.createQuery("FROM CardJujutsu c WHERE c.idJujutsu.id = :id ",CardJujutsu.class).setParameter("id",id);
        return (List<CardJujutsu>) query.getResultList();
    }
}
