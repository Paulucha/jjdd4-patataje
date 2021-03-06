package com.hydrozagadka.dao;

import com.hydrozagadka.History;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class HistoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(History history) {
        entityManager.persist(history);
        return history.getId();
    }

    public History update(History history) {
        return entityManager.merge(history);
    }

    public List<History> findByDate(LocalDate date, Long id){
        Query q = entityManager.createQuery("select h from History h where date=:date and h.waterContainers.id=:id");
        q.setParameter("date",date);
        q.setParameter("id",id);
        return q.getResultList();
    }

    public List<History> getHistoryByWaterContainerWithDates(Long id, LocalDate startDate, LocalDate endDate) {
        Query q = entityManager.createQuery(
                "SELECT h FROM History h WHERE h.waterContainers.id = :id AND h.date BETWEEN :startDate AND :endDate");
        q.setParameter("id", id);
        q.setParameter("startDate",startDate);
        q.setParameter("endDate",endDate);
        return q.getResultList();
    }
}
