package LoicMangele.Dao;


import LoicMangele.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonDao {
    private final EntityManager entityManager;

    public PersonDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPerson) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(newPerson);
        transaction.commit();
        System.out.println("La perrsona " + newPerson.getCognome() + " è stata salvata con successo");

    }
}
