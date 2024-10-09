package LoicMangele;

import LoicMangele.Dao.EventsDao;
import LoicMangele.Dao.PersonDao;
import LoicMangele.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("E3W3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDao ev = new EventsDao(em);
        PersonDao pe = new PersonDao(em);


        Location location1 = new Location("Concert Hall", "New York");
        Location location2 = new Location("San Siro", "Milano");

        em.getTransaction().begin();
        em.persist(location1);
        em.persist(location2);
        em.getTransaction().commit();


        Evento beatles = new Evento(
                "Beatles revival",
                LocalDate.of(2024, 11, 11),
                "Cover delle più famose hit dei Beatles",
                TipoEvento.Privato,
                500, location1
        );

        Evento topOfThePops = new Evento(
                "Top of the Pops",
                LocalDate.of(2025, 07, 13),
                "L'evento musicale estivo è tornato",
                TipoEvento.Publico,
                7000, location2
        );


        em.getTransaction().begin();
        ev.save(beatles);
        ev.save(topOfThePops);
        em.getTransaction().commit();


        Persona person = new Persona(
                "Luigi",
                "Rosa",
                "luigi.rosa@example.com",
                LocalDate.of(1991, 7, 22),
                Sesso.MASCHIO
        );


        em.getTransaction().begin();
        pe.save(person);
        em.getTransaction().commit();


        Partecipazioni partecipazione = new Partecipazioni(person, beatles, StatoPartecipazione.CONFERMATO);


        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
