package LoicMangele;

import LoicMangele.Dao.EventsDao;

import LoicMangele.entities.Evento;
import LoicMangele.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("E3W3");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventsDao ev = new EventsDao(em);


        Evento beatles = new Evento(
                "Beatles revival",
                LocalDate.of(2024, 11, 11),
                "cover delle più famose hit dei Beatles ",
                TipoEvento.Privato,
                500
        );
        Evento topOfThePops = new Evento(
                "Top of the Pops",
                LocalDate.of(2025, 07, 13),
                "L'evento musicale estivo è tornato ",
                TipoEvento.Publico,
                7000
        );


        //ev.save(beatles);
        //ev.save(topOfThePops);

        try {
            Evento fromDb = ev.getById(12);
            System.out.println(fromDb);

            ev.delete(12);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }


        em.close();
        emf.close();
    }
}

