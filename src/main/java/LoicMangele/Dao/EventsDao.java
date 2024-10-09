package LoicMangele.Dao;

import LoicMangele.NotFoundException;
import LoicMangele.entities.Evento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jdk.jfr.Event;

public class EventsDao {

    private final EntityManager entityManager;

    public EventsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvent) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(newEvent);
        transaction.commit();
        System.out.println("L'evento " + newEvent.getTitolo() + " è stato creato con successo");

    }

    public Evento getById(long eventId) {
        Evento found = entityManager.find(Evento.class, eventId);
        if (found == null) {
            throw new NotFoundException(eventId);
        }
        return found;


    }
    public void delete(long eventId) {
        Evento found = this.getById(eventId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("L'evento " + found.getTitolo() + " è stato rimosso con successo");
    }
}
