package LoicMangele.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazioni {
    @Id
    @GeneratedValue
    @Column(name = "partecipazioni_id")
    private UUID partecipazioniId;

    @ManyToMany
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;


    @Enumerated(EnumType.STRING)
    @Column(name = "stato_partecipazione", nullable = false)
    private StatoPartecipazione statoPartecipazione;


    public Partecipazioni() {}


    public Partecipazioni(Persona persona, Evento evento, StatoPartecipazione statoPartecipazione) {
        this.persona = persona;
        this.evento = evento;
        this.statoPartecipazione = statoPartecipazione;
    }


    public UUID getPartecipazioniId() {
        return partecipazioniId;
    }

    public void setPartecipazioniId(UUID partecipazioniId) {
        this.partecipazioniId = partecipazioniId;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona utente) {
        this.persona = utente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }
}

