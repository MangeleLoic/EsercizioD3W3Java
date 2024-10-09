package LoicMangele.Dao;


import LoicMangele.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDao {
    private final EntityManager entityManager;

    public LocationDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(newLocation);
        transaction.commit();
        System.out.println("La location " +newLocation.getLocationId() + " è stata salvata con successo");

    }
}