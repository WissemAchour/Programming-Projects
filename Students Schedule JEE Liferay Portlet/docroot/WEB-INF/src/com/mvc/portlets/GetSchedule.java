package com.mvc.portlets;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GetSchedule {

    public EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    public Salle findSalle(int id) {
        return getEntityManager().find(Salle.class, id);
    }

    public Matiere findMatiere(int id) {
        return getEntityManager().find(Matiere.class, id);
    }

    public Seance findSeance(int id) {
        return getEntityManager().find(Seance.class, id);
    }
    public List<Seance> findSeancesByDay(String jour) {
        return getEntityManager().createQuery("Select s from Seance s WHERE s.jour=:jour").setParameter("jour", jour).getResultList();
    }   

    public List<Affectation> findCellulesByDayAndHeure(String jour, Object heure) {
        return getEntityManager().createQuery("Select a from Affectation a WHERE a.seance.jour='"+jour+"'AND a.seance.heure='"+heure+"'").getResultList();
    }
    public List<Affectation> findCellules(){
        return getEntityManager().createQuery("Select a from Affectation a").getResultList();
    }
    public List<Seance> findSeancesByHeure(String heure) {
        return getEntityManager().createQuery("Select s from Seance s WHERE s.heure=:heure").setParameter("heure", heure).getResultList();
    }
    public void start() {
        entityManager = Persistence.createEntityManagerFactory("JPA_test").createEntityManager();
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
