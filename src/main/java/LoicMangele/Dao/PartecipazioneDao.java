package LoicMangele.Dao;


import LoicMangele.entities.Partecipazioni;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDao {
    private final EntityManager entityManager;

    public PartecipazioneDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazioni newPartecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(newPartecipazione);
        transaction.commit();
        System.out.println("La partecipazione " + newPartecipazione.getPartecipazioniId() + " è stata salvata con successo");

    }
}
